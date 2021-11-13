package com.example.bottomnavigationbarwithsavefragmentinstancestate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.bottomnavigationbarwithsavefragmentinstancestate.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        // 下部メニューコンポーネントの取得
        val bottomNavView: BottomNavigationView = binding.bottomNavigation
        // ナビゲーションフラグメントの取得
        // REF: https://stackoverflow.com/questions/58703451/fragmentcontainerview-as-navhostfragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // 下部メニューとナビゲーションを関連付け
        NavigationUI.setupWithNavController(bottomNavView, navController)
        setContentView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}