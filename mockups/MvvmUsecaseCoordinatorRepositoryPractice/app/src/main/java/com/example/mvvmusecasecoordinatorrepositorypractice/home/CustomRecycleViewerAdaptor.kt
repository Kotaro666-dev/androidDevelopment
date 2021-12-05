package com.example.mvvmusecasecoordinatorrepositorypractice.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmusecasecoordinatorrepositorypractice.R
import com.example.mvvmusecasecoordinatorrepositorypractice.database.TodoDataClass

class CustomAdapter :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var todoList = mutableListOf<TodoDataClass>()

    fun setTodoList(todoList: List<TodoDataClass>) {
        this.todoList = todoList.toMutableList()
        notifyDataSetChanged()
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.title)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.todo_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        if (todoList.isEmpty()) {
            return
        }
        viewHolder.textView.text = todoList[position].title
        viewHolder.checkBox.isChecked = todoList[position].isDone
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return if (todoList.isEmpty()) {
            0
        } else {
            todoList.size
        }
    }

}