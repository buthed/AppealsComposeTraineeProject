package com.example.appealscomposetraineeproject.ui.screens.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.appealscomposetraineeproject.model.entities.Appeal
import com.example.appealscomposetraineeproject.model.entities.SortAttributes
import com.example.appealscomposetraineeproject.viewmodel.MainViewModel

class AppealHistoryFragment: Fragment(), AppealHistoryScreenCallback {

    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getAppeals()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val appealsData: State<List<Appeal>> = viewModel.appeals.observeAsState(listOf())
                AppealHistoryScreen(appealsData,viewModel, object: AppealHistoryScreenCallback{
                    override fun onSearch(query: String) {
                        viewModel.search(query)
                    }

                    override fun onSort(column: SortAttributes) {
                        viewModel.sortByDate(column)
                    }

                    override fun onGetData() {
                        viewModel.getAppeals()
                    }
                })

            }
        }
    }

    override fun onSearch(query: String) {
        viewModel.search(query)
    }

    override fun onSort(column: SortAttributes) {
        viewModel.sortByDate(column)
    }

    override fun onGetData() {
        viewModel.getAppeals()
    }
}