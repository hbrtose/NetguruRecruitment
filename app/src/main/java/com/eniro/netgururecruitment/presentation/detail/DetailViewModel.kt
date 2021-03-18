package com.eniro.netgururecruitment.presentation.detail

import android.location.Geocoder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eniro.netgururecruitment.presentation.base.BaseViewModel
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val geocoder: Geocoder) : BaseViewModel() {

    private val _location = MutableLiveData<LatLng>()
    val location: LiveData<LatLng> = _location

    fun getLocation(name: String) {
        _location.value = geocoder.getFromLocationName(name, 1)
                .map { LatLng(it.latitude, it.longitude) }[0]
    }
}