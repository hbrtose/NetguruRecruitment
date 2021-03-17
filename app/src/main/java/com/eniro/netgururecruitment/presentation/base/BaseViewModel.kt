package com.eniro.netgururecruitment.presentation.base

import androidx.lifecycle.ViewModel
import com.eniro.netgururecruitment.util.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {

    val error = SingleLiveEvent<String>()
    protected val disposables = CompositeDisposable()

    fun Disposable.register() {
        disposables.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}