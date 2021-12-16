package com.app.endclothing.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.app.endclothing.data.model.Products
import com.app.endclothing.databinding.ItemViewBinding
import java.util.*

class ItemAdapter : ListAdapter<Products, ItemViewHolder>(ItemAdapter) {
    companion object : DiffUtil.ItemCallback<Products>() {
        override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val binding = holder.binding as ItemViewBinding
        val currentUser = getItem(position)

        binding.run {
            productItems = currentUser
            executePendingBindings()
        }
    }

    fun addMore(products: ArrayList<Products>) {

        this.submitList(products)
        notifyDataSetChanged()
    }


}

class ItemViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)