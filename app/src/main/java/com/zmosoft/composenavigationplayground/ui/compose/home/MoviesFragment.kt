package com.zmosoft.composenavigationplayground.ui.compose.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme

class MoviesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(inflater.context).apply {
            setContent {
                ComposeNavigationPlaygroundTheme {
                    MoviesScreen()
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MoviesFragment()
    }
}