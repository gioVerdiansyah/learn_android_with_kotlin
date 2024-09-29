package com.verdixi.basickotlin.models.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.verdixi.basickotlin.databinding.ItemRowHeroBinding
import com.verdixi.basickotlin.models.data.HeroWithLibrary

class HeroAdapterWithViewBinding(private val listHero: ArrayList<HeroWithLibrary>): RecyclerView.Adapter<HeroAdapterWithViewBinding.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // ViewHolder class using View Binding
    class ListViewHolder(private val binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: HeroWithLibrary, onItemClickCallback: OnItemClickCallback) {
            binding.tvItemName.text = hero.name
            binding.tvItemDescription.text = hero.description
            Glide.with(binding.root.context)
                .load(hero.photo)
                .into(binding.imgItemPhoto)

            // Set onClickListener for item
            binding.root.setOnClickListener {
                onItemClickCallback.onItemClicked(hero)
            }
        }
    }

    // Properly implement onCreateViewHolder to return ListViewHolder from this class
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    // Implement onBindViewHolder to bind data to the ViewHolder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        holder.bind(hero, onItemClickCallback)
    }

    override fun getItemCount(): Int = listHero.size

    // Interface for item click callback
    interface OnItemClickCallback {
        fun onItemClicked(data: HeroWithLibrary)
    }
}
