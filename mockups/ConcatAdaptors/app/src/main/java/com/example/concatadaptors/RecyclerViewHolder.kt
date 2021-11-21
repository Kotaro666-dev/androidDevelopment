import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadaptors.R

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemTextView: TextView = view.findViewById(R.id.itemListTextView)
    val itemImageView: ImageView = view.findViewById(R.id.itemListImageView)

    init {
        // Define click listener for the ViewHolder's View.

    }
}