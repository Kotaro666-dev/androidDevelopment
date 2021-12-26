package com.example.daggerhiltandpokeapi

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daggerhiltandpokeapi.repository.Pokemon

class CustomAdapter(private val context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var pokemonList: List<Pokemon> = listOf()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagePokemon: ImageView = view.findViewById(R.id.image_pokemon)
        val namePokemon: TextView = view.findViewById(R.id.name_pokemon)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pokemon_item_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        // ピカソ等を使って画像を表示
        viewHolder.namePokemon.text = pokemonList[position].name
        Glide.with(context).load(pokemonList[position].imageUrl).into(viewHolder.imagePokemon)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = pokemonList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updatePokemonList(pokemonList: List<Pokemon>) {
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }
}