package com.example.bottomnavigationbar.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bottomnavigationbar.fragment.HomeFragment
import com.example.bottomnavigationbar.fragment.MyPageFragment
import com.example.bottomnavigationbar.fragment.RegisterFragment
import com.example.bottomnavigationbar.fragment.ViewFragment

class BottomNavigationPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    companion object {
        private const val ITEM_COUNT = 4
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> RegisterFragment()
            2 -> ViewFragment()
            3 -> MyPageFragment()
            else -> HomeFragment()
        }
    }
}