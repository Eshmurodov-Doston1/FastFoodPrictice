package com.example.fastfoodprictice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fastfoodprictice.databinding.ItemFoodBinding
import com.example.fastfoodprictice.models.FastFood
import com.squareup.picasso.Picasso

class FoodRv(var onItemClickListener: OnItemClickListener):ListAdapter<FastFood,FoodRv.Vh>(MyDiffUtill()) {
    inner class Vh(var itemFoodBinding:ItemFoodBinding):RecyclerView.ViewHolder(itemFoodBinding.root){
        fun onBind(fastFood: FastFood,position: Int){
            Picasso.get().load(fastFood.image).into(itemFoodBinding.imageFood)
            itemFoodBinding.nameFood.text = fastFood.name
            itemFoodBinding.rate.text= fastFood.rate
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(fastFood,position)
            }
            itemFoodBinding.save.setOnClickListener {
                onItemClickListener.onItemClick(fastFood,position)
            }
        }
    }

    class MyDiffUtill:DiffUtil.ItemCallback<FastFood>(){
        override fun areItemsTheSame(oldItem: FastFood, newItem: FastFood): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FastFood, newItem: FastFood): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }
    interface OnItemClickListener{
        fun onItemClick(fastFood: FastFood,position: Int)
        fun saveSasket(fastFood: FastFood,position: Int)
    }

}