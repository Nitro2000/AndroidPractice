package com.example.listadapteranddiffutil

import android.app.Person
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter:
    ListAdapter<PersonModel, PersonAdapter.ViewHolder>(DiffUtils()) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById<TextView>(R.id.nameText)
        private val icon: TextView = itemView.findViewById<TextView>(R.id.iconText)

        fun bind(item: PersonModel) {
            name.text = item.name
            icon.text = item.icon
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffUtils : DiffUtil.ItemCallback<PersonModel>() {
        override fun areItemsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean {
            return oldItem == newItem
        }

    }
}