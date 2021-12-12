package com.example.httpgetpractice.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.httpgetpractice.R
import com.example.httpgetpractice.model.Menu

class CustomRecyclerAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var menuList: List<Menu> = emptyList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerViewHolder {

        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater.inflate(R.layout.list_item_card, viewGroup, false)

        return RecyclerViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.itemIndexView.text = menuList[position].index.toString()
        viewHolder.itemTextView.text = menuList[position].text
        viewHolder.itemUrlView.text = menuList[position].url
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun updateMenuList(menuList: MutableList<Menu>) {
        this.menuList = menuList
        notifyDataSetChanged()
    }
}