package com.example.changefragmentinbottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.changefragmentinbottomnavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.bottomNavigationViewPager.adapter = BottomNavigationPagerAdapter(this)
        binding.bottomNavigationViewPager.isUserInputEnabled = false

        binding.bottomNavigation.setOnItemSelectedListener {
            val currentItem =
                when (it.itemId) {
                    R.id.first_tab -> 0
                    R.id.second_tab -> 1
                    else -> 0
                }
            binding.bottomNavigationViewPager.setCurrentItem(currentItem, false)
            return@setOnItemSelectedListener true
        }
        setContentView(binding.root)
    }
}