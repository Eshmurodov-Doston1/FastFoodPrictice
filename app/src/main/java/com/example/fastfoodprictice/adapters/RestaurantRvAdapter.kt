package com.example.fastfoodprictice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fastfoodprictice.databinding.ItemRvBinding
import com.example.fastfoodprictice.models.Restaurant

class RestaurantRvAdapter(var onItemClickListener: OnItemClickListener):ListAdapter<Restaurant,RestaurantRvAdapter.Vh>(MyDiffUtil()) {
    inner class Vh(var itemRvBinding:ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(restaurant: Restaurant,position: Int){
            itemRvBinding.name.text = restaurant.name
            itemRvBinding.delivery.text =restaurant.delivery
            itemRvBinding.time.text = restaurant.time
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(restaurant,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

    }
    class MyDiffUtil:DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.equals(newItem)
        }
    }
    interface OnItemClickListener{
        fun onItemClick(restaurant: Restaurant,position: Int)
    }
}