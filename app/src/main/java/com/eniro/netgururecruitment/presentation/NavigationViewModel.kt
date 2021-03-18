package com.eniro.netgururecruitment.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eniro.netgururecruitment.data.ListItemData
import com.eniro.netgururecruitment.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor() : BaseViewModel() {

    private val _currentDetail = MutableLiveData<ListItemData>()
    val currentDetail: LiveData<ListItemData> = _currentDetail

    fun navigate(direction: ListItemData) {
        _currentDetail.value = direction
    }
}