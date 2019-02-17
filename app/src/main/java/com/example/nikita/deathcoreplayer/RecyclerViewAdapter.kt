package com.example.nikita.deathcoreplayer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class RecyclerViewAdapter(list: List<Audio>, internal var context: Context) : RecyclerView.Adapter<ViewHolder>() {

    internal var list = emptyList<Audio>()

    init {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title: TextView = itemView.findViewById(R.id.title)
    var playpause: ImageView = itemView.findViewById(R.id.play_pause)

}
