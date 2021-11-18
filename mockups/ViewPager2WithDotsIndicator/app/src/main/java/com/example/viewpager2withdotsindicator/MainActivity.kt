package com.example.viewpager2withdotsindicator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewpager2withdotsindicator.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        val pagerAdaptor = ViewPagerAdapter(this)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager2
        viewPager.adapter = pagerAdaptor
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            println("$tab: $position")
        }.attach()
        setContentView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}