package com.example.mvvmusecasecoordinatorrepositorypractice.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmusecasecoordinatorrepositorypractice.R
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass
import com.example.mvvmusecasecoordinatorrepositorypractice.databinding.ActivityHomeBinding
import com.example.mvvmusecasecoordinatorrepositorypractice.model.ViewModels

class HomeActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
    }

    private val viewModel by lazy {
        ViewModels.of(this, HomeViewModel::class.java)
    }

    private lateinit var mAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.buttonGoToAddTodo.setOnClickListener {
            viewModel.goToAddTodoScreen(this)
        }

        val dataSet = listOf(
            TodoDataClass(title = "test1"),
            TodoDataClass(title = "test2"),
            TodoDataClass(title = "test3")
        )

        // RecyclerViewの取得
        val recyclerView = binding.recyclerView

        // LayoutManagerの設定
        recyclerView.layoutManager = LinearLayoutManager(this)

        // CustomAdapterの生成と設定
        mAdapter = CustomAdapter(dataSet)
        recyclerView.adapter = mAdapter
    }
}