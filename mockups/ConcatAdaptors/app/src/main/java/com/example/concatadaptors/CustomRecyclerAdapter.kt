package com.example.concatadaptors

import RecyclerViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerAdapter(
    private val itemsList: List<String>
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerViewHolder {

        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater.inflate(R.layout.list_item, viewGroup, false)

        return RecyclerViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.itemTextView.text = itemsList[position]
        viewHolder.itemImageView.setImageResource(R.mipmap.ic_launcher)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}