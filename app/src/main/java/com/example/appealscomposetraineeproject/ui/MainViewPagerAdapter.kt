package com.example.appealscomposetraineeproject.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.appealscomposetraineeproject.ui.screens.appeal.AppealFragment
import com.example.appealscomposetraineeproject.ui.screens.history.AppealHistoryFragment


class MainViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment)  {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0->{
                AppealFragment()
            }
            1->{
                AppealHistoryFragment()
            }
            else->{
                Fragment()
            }
        }
    }

}