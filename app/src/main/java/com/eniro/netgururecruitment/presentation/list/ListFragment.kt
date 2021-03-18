package com.eniro.netgururecruitment.presentation.list

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eniro.netgururecruitment.R
import com.eniro.netgururecruitment.databinding.FragmentListBinding
import com.eniro.netgururecruitment.presentation.NavigationViewModel
import com.eniro.netgururecruitment.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>(ListViewModel::class) {

    private val navigationViewModel by activityViewModels<NavigationViewModel>()

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    override fun onBound(binding: FragmentListBinding) {
        val adapter = ListRecycler(viewModel.items, this) {
            if (requireContext().resources.getBoolean(R.bool.is_tablet_land)) {
                navigationViewModel.navigate(it)
            } else {
                findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(it))
            }
        }
        binding.listRecycler.layoutManager = LinearLayoutManager(context)
        binding.listRecycler.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        viewModel.stop()
    }

    override fun onResume() {
        super.onResume()
        viewModel.run()
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(requireContext(),
                R.color.design_default_color_primary)))
    }
}