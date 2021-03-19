package com.eniro.netgururecruitment.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eniro.netgururecruitment.databinding.ActivityMainBinding
import com.eniro.netgururecruitment.R
import com.eniro.netgururecruitment.presentation.detail.DetailFragment
import com.eniro.netgururecruitment.presentation.list.ListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NetguruActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navigationViewModel by viewModels<NavigationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.addOnBackStackChangedListener {
            supportActionBar?.setDisplayHomeAsUpEnabled(supportFragmentManager.backStackEntryCount > 0)
        }
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_navigation, ListFragment())
                .commit()
        } else {
            if (supportFragmentManager.backStackEntryCount > 0) {
                pop()
            }
        }
        navigationViewModel.currentDetail.observe(this) { item ->
            item?.let {
                if (resources.getBoolean(R.bool.is_tablet_land)) {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.detail_navigation, DetailFragment.newInstance(it))
                        .commit()
                } else {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_navigation, DetailFragment.newInstance(it))
                        .addToBackStack(DetailFragment::class.java.simpleName)
                        .commit()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            pop()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun pop() {
        supportFragmentManager.popBackStack()
        navigationViewModel.pop()
    }
}