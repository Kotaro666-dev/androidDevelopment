package com.example.concatadaptors.helpers

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadaptors.R
import com.example.concatadaptors.activities.ItemPageActivity

const val EXTRA_ITEM_TEXT = "item_text"

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemTextView: TextView = view.findViewById(R.id.itemListTextView)
    val itemImageView: ImageView = view.findViewById(R.id.itemListImageView)

    init {
        // Define click listener for the ViewHolder's View.
        val cardView: CardView = view.findViewById(R.id.card_view)
        cardView.setOnClickListener {
//            Toast.makeText(view.context, itemTextView.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(view.context, ItemPageActivity::class.java).apply {
                val itemText = itemTextView.text.toString()
                putExtra(EXTRA_ITEM_TEXT, itemText)
            }
            startActivity(view.context, intent, null)
        }
    }
}