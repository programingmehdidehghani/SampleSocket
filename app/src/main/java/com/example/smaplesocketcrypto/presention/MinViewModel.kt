package com.example.smaplesocketcrypto.presention

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.smaplesocketcrypto.domain.model.ExampleModels
import com.example.smaplesocketcrypto.domain.usecase.ExampleConnectableUseCase
import io.reactivex.rxjava3.subscribers.DisposableSubscriber
import javax.inject.Inject

class MinViewModel @Inject constructor (
    private val exampleConnectable: ExampleConnectableUseCase
) : ViewModel() {

    lateinit var symbol: String
    lateinit var lastPrice: String
    lateinit var changePriceList: String

    fun getStartSocket() {
        exampleConnectable.connect(javaClass.name, object : DisposableSubscriber<ExampleModels>() {
            override fun onNext(t: ExampleModels) {
                when (t) {
                    is ExampleModels.SymbolModel -> {
                        symbol
                    }
                    is ExampleModels.ChangePriceModel -> {
                        lastPrice
                    }
                    is ExampleModels.LastPriceModel -> {
                        changePriceList
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

    @SuppressLint("CheckResult")
    fun request(){
        exampleConnectable.requestSymbolModel()
            .subscribe({
            }, {
                it.printStackTrace()
            })
        exampleConnectable.requestLastPriceModel()
            .subscribe({

            }, {
                it.printStackTrace()
            })
        exampleConnectable.requestChangePriceModel()
            .subscribe({
            }, {
                it.printStackTrace()
            })
    }


}