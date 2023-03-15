package com.example.smaplesocketcrypto.domain.usecase

import android.annotation.SuppressLint
import com.example.smaplesocketcrypto.domain.executor.PostExecutionThread
import com.example.smaplesocketcrypto.domain.executor.ThreadExecutor
import com.example.smaplesocketcrypto.domain.model.ExampleModels
import com.example.smaplesocketcrypto.domain.repository.ExampleRepository
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class ExampleConnectableUseCase @Inject constructor(
    private val repository: ExampleRepository,
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : ConnectableUseCase<ExampleModels>(
    repository.connectable,
    postExecutionThread,
    threadExecutor
) {

    init {
        repository.getSymbolModel().subscribe {
            output.accept(it)
        }
        repository.getLastPriceModel().subscribe {
            output.accept(it)
        }
        repository.getChangePriceModel().subscribe {
            output.accept(it)
        }
    }

    fun requestSymbolModel() = repository
        .requestSymbolModel()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)!!

    fun requestLastPriceModel() = repository
        .requestLastPriceModel()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)!!

    fun requestChangePriceModel() = repository
        .requestChangePriceModel()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)!!
}