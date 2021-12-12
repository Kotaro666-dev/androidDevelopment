package com.example.httpgetpractice.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

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

        viewAdapter = CustomRecyclerAdapter()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView = binding.recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        viewModel.menuList.observe(this, Observer {
            (this.viewAdapter as CustomRecyclerAdapter).updateMenuList(it)
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }
}