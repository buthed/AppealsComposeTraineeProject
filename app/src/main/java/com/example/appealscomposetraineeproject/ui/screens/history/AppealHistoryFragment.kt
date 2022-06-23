package com.example.appealscomposetraineeproject.ui.screens.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.appealscomposetraineeproject.viewmodel.MainViewModel

class AppealHistoryFragment: Fragment() {

    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                AppealHistoryScreen(viewModel)
            }
        }
    }
}