package com.example.books.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.books.R

class Adapter(var items:ArrayList<String>):RecyclerView.Adapter<Adapter.viewholder>() {

    class viewholder(itemView: View) :ViewHolder(itemView){
        var txt = itemView.findViewById<TextView>(R.id.txt)
        fun bind (data: String){
            txt.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}