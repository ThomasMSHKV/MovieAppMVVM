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
import com.example.movieapp.data.network.models.MainMovieApi
import com.example.movieapp.data.network.models.ProductionCompany

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val callbackInstance = object : MovieCallback {
        override fun openFragment(mainMovieApi: MainMovieApi) {
        }
    }
    var callback: MovieCallback? = null
    var itemPick = mutableListOf<MainMovieApi>()
    var itemMov = mutableListOf<ProductionCompany>()

    fun setData(list: List<MainMovieApi>) {
        itemPick = list as MutableList<MainMovieApi>
        notifyDataSetChanged()
    }

    fun replaceList(data: List<MainMovieApi>) {
        itemPick.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return ViewHolder(itemView, callback ?: callbackInstance, itemPick)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(itemMov[position].logo_path).into(holder.image)
        holder.movieName.text = itemPick[position].original_title
        holder.setOnRootClickListener()
    }

    override fun getItemCount(): Int {
        return itemPick.size
    }

    class ViewHolder(
        itemView: View,
        private val callback: MovieCallback,
        private val itemPick: MutableList<MainMovieApi>
    ) : RecyclerView.ViewHolder(itemView) {
        val root: CardView = itemView.findViewById(R.id.card_view)
        val image: ImageView = itemView.findViewById(R.id.movieImage)
        val movieName: TextView = itemView.findViewById(R.id.movieName)

        fun setOnRootClickListener(){
            root.setOnClickListener {
                callback.openFragment(itemPick[adapterPosition])
            }
        }
    }
}