package com.example.movieapp.presention.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.contract.MovieCallback
import com.example.movieapp.data.network.models.Result

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var callback: MovieCallback? = null
    var itemPick = mutableListOf<Result>()
    var listResult = mutableListOf<Result>()


    fun setData(list: List<Result>) {
        itemPick = list as MutableList<Result>
        notifyDataSetChanged()
    }

    fun replaceList(data: List<Result>) {
        itemPick.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.root.setOnClickListener {
            callback?.openFragment(itemPick[holder.adapterPosition])
        }

        return holder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listResult[position].multimedia.src)
            .into(holder.image)
        holder.movieName.text = itemPick[position].display_title
        holder.root.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return itemPick.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root: CardView = itemView.findViewById(R.id.card_view)
        val image: ImageView = itemView.findViewById(R.id.movieImage)
        val movieName: TextView = itemView.findViewById(R.id.movieName)

    }
}
