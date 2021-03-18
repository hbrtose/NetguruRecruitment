package com.eniro.netgururecruitment.presentation.detail

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.eniro.netgururecruitment.databinding.FragmentDetailBinding
import com.eniro.netgururecruitment.presentation.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(DetailViewModel::class) {

    companion object {
        private const val ZOOM_LEVEL = 11f
        private const val ANIMATION_TIME = 900
    }

    private val args: DetailFragmentArgs by navArgs()

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun onBound(binding: FragmentDetailBinding) {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.setBackgroundDrawable(ColorDrawable(args.item.color))
            it.title = args.item.name
        }
        val mapFragment = SupportMapFragment.newInstance()
        childFragmentManager.beginTransaction().replace(binding.detailMapContainer.id, mapFragment).commit()
        mapFragment.getMapAsync { map ->
            viewModel.location.observe(viewLifecycleOwner) {
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(it, ZOOM_LEVEL), ANIMATION_TIME, null)
            }
            viewModel.getLocation(args.item.toString())
        }
    }
}