package com.example.smaplesocketcrypto.presention

import androidx.lifecycle.ViewModel
import com.example.smaplesocketcrypto.domain.repository.ExampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.subscribers.DisposableSubscriber
import javax.inject.Inject

@HiltViewModel
class MinViewModel  @Inject constructor (
    private val exampleRepository: ExampleRepository
) : ViewModel() {

    init {
        getStartSocket()
    }

    private fun getStartSocket() {
        exampleRepository.connect(javaClass.name, object : DisposableSubscriber<ExampleModels>() {
            override fun onNext(t: ExampleModels) {
                when (t) {
                    is ExampleModels.ModelA -> {
                        mainView.showAData(listOf(t))
                    }
                    is ExampleModels.ModelB -> {
                        mainView.showBData(listOf(t))
                    }
                }
            }

            override fun onComplete() {
                /* explicitly empty */
            }

            override fun onError(t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }


}