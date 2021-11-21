import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadaptors.R

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemTextView: TextView = view.findViewById(R.id.itemListTextView)
    val itemImageView: ImageView = view.findViewById(R.id.itemListImageView)

    init {
        // Define click listener for the ViewHolder's View.
        val cardView: CardView = view.findViewById(R.id.card_view)
        cardView.setOnClickListener {
            Toast.makeText(view.context, itemTextView.text, Toast.LENGTH_SHORT).show()
        }
    }
}