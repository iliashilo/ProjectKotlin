package com.example.projectkotlin.presentation.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectkotlin.R
import com.example.projectkotlin.data.local.CardsDC

class FirstImagesAdapter(val listener: Listener) :
    RecyclerView.Adapter<FirstImagesAdapter.ViewHolder>() {

    private val arrayOfAnimals = ArrayList<CardsDC>()

    fun setListOfAnimals(arrayOfAnimals: List<CardsDC>) {
        this.arrayOfAnimals.clear()
        this.arrayOfAnimals.addAll(arrayOfAnimals)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewFact: TextView = itemView.findViewById(R.id.tv_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cards_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return arrayOfAnimals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val card = arrayOfAnimals[position]
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }

        holder.textViewFact.text = card.descOnCard


    }

    interface Listener {
        fun onClick(itemView: Int)
    }
}