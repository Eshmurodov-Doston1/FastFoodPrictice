package com.example.fastfoodprictice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fastfoodprictice.databinding.ItemAddBinding
import com.example.fastfoodprictice.models.Add
import com.squareup.picasso.Picasso

class AdapterAdd:ListAdapter<Add,AdapterAdd.Vh>(MyDiffUtill()) {
    inner class Vh(var itemAddBinding: ItemAddBinding):RecyclerView.ViewHolder(itemAddBinding.root){
        fun onBind(add: Add,position: Int){
            Picasso.get().load(add.image).into(itemAddBinding.myImage)
            itemAddBinding.textName.text = add.name
            itemAddBinding.rate.text = add.rate
        }
    }

    class MyDiffUtill:DiffUtil.ItemCallback<Add>(){
        override fun areItemsTheSame(oldItem: Add, newItem: Add): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Add, newItem: Add): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemAddBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }
}