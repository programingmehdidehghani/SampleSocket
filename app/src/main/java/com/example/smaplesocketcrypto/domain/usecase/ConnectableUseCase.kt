package com.example.smaplesocketcrypto.domain.usecase

import com.example.smaplesocketcrypto.domain.executor.PostExecutionThread
import com.example.smaplesocketcrypto.domain.executor.ThreadExecutor
import com.example.smaplesocketcrypto.domain.repository.Connectable
import com.jakewharton.rxrelay3.PublishRelay
import com.jakewharton.rxrelay3.Relay
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subscribers.DisposableSubscriber

abstract class ConnectableUseCase<OUTPUT> (
    private val connectable: Connectable,
    private val postExecutionThread: PostExecutionThread,
    private val threadExecutor: ThreadExecutor
) {
    protected val output: Relay<OUTPUT> by lazy { PublishRelay.create<OUTPUT>().toSerialized() }

    protected open fun buildOutput(): Observable<OUTPUT> = output

    private val disposeables by lazy { hashMapOf<String, DisposableSubscriber<OUTPUT>>() }

    fun connect(from: String, observer: DisposableSubscriber<OUTPUT>) {
        disposeables[from]?.dispose()
        if (connectable.isConnected.not())
            connectable.connect()
        disposeables.put(
            from,
            buildOutput()
                .toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(observer)
        )
    }

    fun dispose(from: String) {
        disposeables[from]?.dispose()
        if (disposeables.isEmpty())
            connectable.disconnect()
    }
}