package com.eniro.netgururecruitment.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eniro.netgururecruitment.data.ListItemData
import com.eniro.netgururecruitment.data.MainData
import com.eniro.netgururecruitment.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.channels.ticker
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : BaseViewModel() {

    companion object {
        private const val DELAY = 5L
    }
    private val _items = MutableLiveData<List<ListItemData>>()
    val items: LiveData<List<ListItemData>> = _items
    private val itemList = mutableListOf<ListItemData>()

    fun run() {
        Observable.interval(DELAY, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                itemList.add(
                    ListItemData(MainData.cities.random(),
                        MainData.colorMap[MainData.colors.random()]!!)
                )
                _items.value = itemList
            }.register()
    }

    fun stop() {
        disposables.clear()
    }
}