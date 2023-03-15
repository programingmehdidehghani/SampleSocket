package com.example.smaplesocketcrypto.presention

import androidx.lifecycle.ViewModel
import com.example.smaplesocketcrypto.domain.model.ExampleModels
import com.example.smaplesocketcrypto.domain.usecase.ExampleConnectableUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.subscribers.DisposableSubscriber
import javax.inject.Inject

@HiltViewModel
class MinViewModel  @Inject constructor (
    private val exampleConnectable: ExampleConnectableUseCase
) : ViewModel() {

    init {
        getStartSocket()
    }

    private fun getStartSocket() {
        exampleConnectable.connect(javaClass.name, object : DisposableSubscriber<ExampleModels>() {
            override fun onNext(t: ExampleModels) {
                when (t) {
                    is ExampleModels.SymbolModel -> {
                    }
                    is ExampleModels.ChangePriceModel -> {
                    }
                    is ExampleModels.LastPriceModel -> {
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