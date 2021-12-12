package com.example.httpgetpractice.menu

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.httpgetpractice.R

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemIndexView: TextView = view.findViewById(R.id.index)
    val itemTextView: TextView = view.findViewById(R.id.text)
    val itemUrlView: TextView = view.findViewById(R.id.url)

    init {
        // Define click listener for the ViewHolder's View.
    }
}