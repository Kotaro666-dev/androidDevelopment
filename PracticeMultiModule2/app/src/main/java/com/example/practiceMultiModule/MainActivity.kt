package com.example.practiceMultiModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.favorite.FavoriteFragment
import com.example.home.HomeFragment
import com.example.ranking.RankingFragment
import com.example.search.SearchFragment
import com.example.setting.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val favoriteFragment = FavoriteFragment()
        val searchFragment = SearchFragment()
        val rankingFragment = RankingFragment()
        val settingFragment = SettingFragment()

        setCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> setCurrentFragment(homeFragment)
                R.id.menu_favorite -> setCurrentFragment(favoriteFragment)
                R.id.menu_search -> setCurrentFragment(searchFragment)
                R.id.menu_ranking -> setCurrentFragment(rankingFragment)
                R.id.menu_setting -> setCurrentFragment(settingFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_screen, fragment)
            commit()
        }
}