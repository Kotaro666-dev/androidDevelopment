package com.example.mvvmusecasecoordinatorrepositorypractice.addTodo


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmusecasecoordinatorrepositorypractice.R
import com.example.mvvmusecasecoordinatorrepositorypractice.databinding.ActivityAddTodoBinding
import com.example.mvvmusecasecoordinatorrepositorypractice.model.ViewModels

class AddTodoActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityAddTodoBinding>(this, R.layout.activity_add_todo)
    }

    private val viewModel by lazy {
        ViewModels.of(this, AddTodoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}