package com.eniro.netgururecruitment.di

import android.content.Context
import android.location.Geocoder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {
    @Provides
    fun provideGeocoder(@ApplicationContext context: Context) : Geocoder {
        return Geocoder(context, Locale.getDefault())
    }
}