package com.example.fastfoodprictice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fastfoodprictice.databinding.AdapterLeekBinding
import com.example.fastfoodprictice.models.FastFood
import com.squareup.picasso.Picasso

class AdapterLeek:ListAdapter<FastFood,AdapterLeek.Vh>(MyDiffutill()) {
    inner class Vh(var adapterLeekBinding: AdapterLeekBinding):RecyclerView.ViewHolder(adapterLeekBinding.root){
        fun onBind(fastFood: FastFood,position: Int){
            Picasso.get().load(fastFood.image).into(adapterLeekBinding.myImage)
            adapterLeekBinding.name.text = fastFood.name
            adapterLeekBinding.rate.text = fastFood.rate
        }
    }

    class MyDiffutill:DiffUtil.ItemCallback<FastFood>(){
        override fun areItemsTheSame(oldItem: FastFood, newItem: FastFood): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: FastFood, newItem: FastFood): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(AdapterLeekBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }
}