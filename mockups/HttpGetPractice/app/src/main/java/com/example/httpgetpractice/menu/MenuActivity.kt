package com.example.httpgetpractice.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.httpgetpractice.R
import com.example.httpgetpractice.databinding.ActivityMenuBinding
import com.example.httpgetpractice.main.MainActivity
import com.example.httpgetpractice.repository.Repository
import com.example.httpgetpractice.room.CustomerDatabase

class MenuActivity : AppCompatActivity() {

    private val binding: ActivityMenuBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_menu)
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = MenuViewModelFactory(
            MenuCoordinator(),
            MenuUseCase(Repository(CustomerDatabase.getInstance(this)))
        )
        viewModel = ViewModelProvider(this, viewModelFactory)[MenuViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel.fetchMenuData()
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }
}