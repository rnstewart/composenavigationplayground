package com.zmosoft.composenavigationplayground.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.HomeViewModel
import com.zmosoft.composenavigationplayground.ui.compose.home.HomeScreen
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(inflater.context).apply {
            setContent {
                ComposeNavigationPlaygroundTheme {
                    HomeScreen(
                        date = homeViewModel.date.value
                    )
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as ComposeNavigationPlaygroundApplication)
            .appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.init()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }
}