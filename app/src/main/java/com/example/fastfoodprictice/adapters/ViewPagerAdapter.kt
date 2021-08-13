package com.example.fastfoodprictice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fastfoodprictice.fragments.*
import com.example.fastfoodprictice.fragments.main.MainFragment
import com.example.fastfoodprictice.fragments.menu.MenuFragment
import com.example.fastfoodprictice.fragments.restaran.RestaurantFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0->{
                MainFragment()
            }
           1->{
               FavoritesFragment()
           }
           2->{
               MenuFragment()
           }
           3->{
               RestaurantFragment()
           }
           4->{
               ProfilFragment()
           }
           else->{
               MainFragment()
           }
        }
    }

}