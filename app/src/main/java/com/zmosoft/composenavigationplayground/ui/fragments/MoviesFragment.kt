package com.zmosoft.composenavigationplayground.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.zmosoft.composenavigationplayground.ComposeNavigationPlaygroundApplication
import com.zmosoft.composenavigationplayground.mvvm.viewmodels.MoviesViewModel
import com.zmosoft.composenavigationplayground.ui.compose.home.MoviesScreen
import com.zmosoft.composenavigationplayground.ui.theme.ComposeNavigationPlaygroundTheme
import javax.inject.Inject

class MoviesFragment : Fragment() {
    @Inject
    lateinit var moviesViewModel: MoviesViewModel

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

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as ComposeNavigationPlaygroundApplication)
            .appComponent.inject(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MoviesFragment()
    }
}