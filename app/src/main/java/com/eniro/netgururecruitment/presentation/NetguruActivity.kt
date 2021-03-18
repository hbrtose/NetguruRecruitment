package com.eniro.netgururecruitment.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.eniro.netgururecruitment.databinding.ActivityMainBinding
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.eniro.netgururecruitment.R
import com.eniro.netgururecruitment.presentation.base.EmptyFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NetguruActivity: AppCompatActivity() {

    private lateinit var appBarConfig: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding
    private val navigationViewModel by viewModels<NavigationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.main_navigation)
        appBarConfig = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfig)
        navigationViewModel.currentDetail.observe(this) {
            if (resources.getBoolean(R.bool.is_tablet_land)) {
                (supportFragmentManager.findFragmentById(R.id.detail_navigation) as NavHostFragment)
                    .navController.navigate(EmptyFragmentDirections.actionEmptyFragmentToDetailFragment(it))
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.main_navigation).navigateUp() || super.onSupportNavigateUp()
    }
}