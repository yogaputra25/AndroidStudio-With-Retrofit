package com.respApi.retro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.respApi.retro.api.MainModel
import com.respApi.retro.api.ResultsItem

class MainAdapter(private val dataSet: List<ResultsItem?>??) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMorty = view.findViewById<ImageView>(R.id.item_image_Morty)
        val nameMorty = view.findViewById<TextView>(R.id.item_name_morty)
        val statusMorty = view.findViewById<TextView>(R.id.item_status_morty)
        val speciesMorty = view.findViewById<TextView>(R.id.item_species_morty)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.nameMorty.text = dataSet?.get(position)?.name
        viewHolder.statusMorty.text = dataSet?.get(position)?.status
        viewHolder.speciesMorty.text = dataSet?.get(position)?.species

        Glide.with(viewHolder.imgMorty)
            .load(dataSet?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(viewHolder.imgMorty)

        viewHolder.itemView.setOnClickListener {
            val name = dataSet?.get(position)?.name
            Toast.makeText(viewHolder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        if (dataSet != null){
            return dataSet.size
        }
        return 0
    }

}