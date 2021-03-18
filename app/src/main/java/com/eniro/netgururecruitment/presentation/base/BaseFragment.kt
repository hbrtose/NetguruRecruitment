package com.eniro.netgururecruitment.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.eniro.netgururecruitment.util.viewModels
import kotlin.reflect.KClass

abstract class BaseFragment<V: ViewBinding, T : BaseViewModel>(vm: KClass<T>): Fragment() {

    protected val viewModel: T by viewModels(vm)
    private var binding: V? = null
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = bind(inflater, container)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBound(binding!!)
    }

    protected abstract fun bind(inflater: LayoutInflater, container: ViewGroup?): V

    protected abstract fun onBound(binding: V)
}