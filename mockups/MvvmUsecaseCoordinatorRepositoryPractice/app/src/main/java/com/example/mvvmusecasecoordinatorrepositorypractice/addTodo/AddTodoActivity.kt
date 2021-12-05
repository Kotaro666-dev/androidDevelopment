package com.example.mvvmusecasecoordinatorrepositorypractice.addTodo


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmusecasecoordinatorrepositorypractice.R
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass
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
        setBackButtonOnActionBar()

        binding.buttonAddTodo.setOnClickListener {
            onClickAddTodoButton()
        }
    }

    private fun onClickAddTodoButton() {
        val title = binding.titleEditText.text.toString()
        val description = binding.descriptionEditText.text.toString()

        if (title.trim().isEmpty()) {
            return
        }

        val todo = TodoDataClass(
            title = title,
            description = description
        )
        viewModel.addTodo(todo)
            .also {
                clearEditText()
                onBackPressed()
            }
    }

    private fun clearEditText() {
        binding.titleEditText.text.clear()
        binding.titleEditText.clearFocus()
        binding.descriptionEditText.text.clear()
        binding.descriptionEditText.clearFocus()
    }

    private fun setBackButtonOnActionBar() {
        val actionbar = supportActionBar
        actionbar!!.title = "Add Todo"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}