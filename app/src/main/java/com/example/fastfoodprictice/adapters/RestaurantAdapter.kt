package com.example.fastfoodprictice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fastfoodprictice.fragments.restaran.RestaranCategoryFragment
import com.example.fastfoodprictice.models.Category

class RestaurantAdapter(var list: List<Category>, fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return RestaranCategoryFragment.newInstance(list[position].name.toString(),position)
    }

}