package com.example.bottomnavigationbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomnavigationbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }
        binding.bottomNavigationViewPager.adapter = BottomNavigationPagerAdapter(this)
        binding.bottomNavigationViewPager.isUserInputEnabled = false

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            val currentItem =
                when (it.itemId) {
                    R.id.home_tab -> 0
                    R.id.register_tab -> 1
                    R.id.view_tab -> 2
                    R.id.my_page_tab -> 3
                    else -> 0
                }
            binding.bottomNavigationViewPager.setCurrentItem(currentItem, false)
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
