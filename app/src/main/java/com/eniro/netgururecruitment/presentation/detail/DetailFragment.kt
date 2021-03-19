package com.eniro.netgururecruitment.presentation.detail

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.eniro.netgururecruitment.data.ListItemData
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
        private const val ARG_ITEM = "ARG_ITEM"

        fun newInstance(item: ListItemData): DetailFragment {
            return DetailFragment().apply {
                arguments = bundleOf(ARG_ITEM to item)
            }
        }
    }

    private lateinit var name: String;

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun onBound(binding: FragmentDetailBinding) {
        (activity as AppCompatActivity).supportActionBar?.let {
            arguments?.getParcelable<ListItemData>(ARG_ITEM)?.let { args ->
                it.setBackgroundDrawable(ColorDrawable(args.color))
                it.title = args.name
                this.name = args.name
            }
        }
        val mapFragment = SupportMapFragment.newInstance()
        childFragmentManager.beginTransaction().replace(binding.detailMapContainer.id, mapFragment).commit()
        view?.let {
            mapFragment.getMapAsync { map ->
                viewModel.location.observe(viewLifecycleOwner) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(it, ZOOM_LEVEL),
                        ANIMATION_TIME, null)
                }
                viewModel.getLocation(name)
            }
        }
    }
}