package com.example.fastfoodprictice.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.ViewPagerAdapter
import com.example.fastfoodprictice.databinding.FragmentHomeBinding
import nl.joery.animatedbottombar.AnimatedBottomBar

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var fragmentHomebinding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = fragmentHomebinding!!
    lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomebinding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        loadView()
        fragmentHomebinding?.viewpager?.isUserInputEnabled = false
        fragmentHomebinding?.bottomBar?.setOnTabInterceptListener(object:AnimatedBottomBar.OnTabInterceptListener{
            override fun onTabIntercepted(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ): Boolean {
               fragmentHomebinding?.viewpager?.currentItem = newIndex
             return true
            }
        })
        return root
    }

    private fun loadView() {
        viewPagerAdapter = ViewPagerAdapter(requireActivity())
        fragmentHomebinding?.viewpager?.adapter = viewPagerAdapter
        fragmentHomebinding?.viewpager?.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0->{
                        fragmentHomebinding?.bottomBar?.selectTabById(R.id.home1)
                    }
                    1->{
                        fragmentHomebinding?.bottomBar?.selectTabById(R.id.favorites)
                    }
                    2->{
                        fragmentHomebinding?.bottomBar?.selectTabById(R.id.menu)
                    }
                    3->{
                        fragmentHomebinding?.bottomBar?.selectTabById(R.id.restourant)
                    }
                    4->{
                        fragmentHomebinding?.bottomBar?.selectTabById(R.id.profil)
                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.setHomeButtonEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_logo)
        (activity as AppCompatActivity).supportActionBar!!.show()
    }




    override fun onDestroyView() {
        super.onDestroyView()
        fragmentHomebinding = null
    }
}