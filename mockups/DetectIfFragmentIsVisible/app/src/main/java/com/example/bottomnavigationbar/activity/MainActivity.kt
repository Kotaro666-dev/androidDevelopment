package com.example.bottomnavigationbar.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomnavigationbar.R
import com.example.bottomnavigationbar.databinding.ActivityMainBinding
import com.example.bottomnavigationbar.view.BottomNavigationPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationViewPager.adapter = BottomNavigationPagerAdapter(this)
        binding.bottomNavigationViewPager.isUserInputEnabled = false

        binding.bottomNavigation.setOnItemSelectedListener {
            val currentItem = getCurrentItem(it.itemId)
            binding.bottomNavigationViewPager.setCurrentItem(currentItem, true)
            return@setOnItemSelectedListener true
        }
    }

    private fun getCurrentItem(itemId: Int): Int {
        return when (itemId) {
            R.id.home_tab -> 0
            R.id.register_tab -> 1
            R.id.view_tab -> 2
            R.id.my_page_tab -> 3
            else -> 0
        }
    }
}
