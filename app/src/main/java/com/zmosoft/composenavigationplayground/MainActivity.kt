package com.zmosoft.composenavigationplayground

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.zmosoft.composenavigationplayground.databinding.ActivityMainBinding
import com.zmosoft.composenavigationplayground.ui.compose.MainScreen
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        (applicationContext as ComposeNavigationPlaygroundApplication).appComponent.inject(this)

        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment)?.let { navHostFragment ->
            NavigationUI.setupWithNavController(
                binding.mainContent.navBottom,
                navHostFragment.navController
            )
        }
    }
}
