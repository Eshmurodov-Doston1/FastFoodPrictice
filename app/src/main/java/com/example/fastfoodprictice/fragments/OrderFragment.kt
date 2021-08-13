package com.example.fastfoodprictice.fragments

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainer
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.AddFood
import com.example.fastfoodprictice.databinding.FragmentOrderBinding
import com.example.fastfoodprictice.databinding.ItemtabAddBinding
import com.example.fastfoodprictice.models.Category
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var fragmentOrderBinding: FragmentOrderBinding
    lateinit var root:View
    lateinit var addFood: AddFood
    lateinit var listCategory:ArrayList<Category>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      fragmentOrderBinding = FragmentOrderBinding.inflate(inflater,container,false)
        root = fragmentOrderBinding.root
        loadCategory()
        (activity as AppCompatActivity).supportActionBar!!.hide()
        val image = arguments?.getString("image")
        val rate = arguments?.getString("rate")
        Picasso.get().load(image).into(fragmentOrderBinding.image)
        fragmentOrderBinding.rate.text = rate
        addFood = AddFood(listCategory,requireActivity())
        fragmentOrderBinding.viewpager2.adapter = addFood
        TabLayoutMediator(fragmentOrderBinding.tabLayout,fragmentOrderBinding.viewpager2){tab,position->
            tab.text = listCategory[position].name
        }.attach()
        loadUi()
        fragmentOrderBinding.tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val itemTabAddBinding = tab?.customView?.let { ItemtabAddBinding.bind(it) }
                itemTabAddBinding?.cons?.elevation = 2F
                itemTabAddBinding?.text?.setTextColor(Color.BLACK)
                var gradientDrawable = itemTabAddBinding?.cons?.background?.mutate() as GradientDrawable
                gradientDrawable.setColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val itemTabAddBinding = tab?.customView?.let { ItemtabAddBinding.bind(it) }
                itemTabAddBinding?.cons?.elevation = 0F
                itemTabAddBinding?.text?.setTextColor(Color.parseColor("#8D9BA8"))
                var gradientDrawable = itemTabAddBinding?.cons?.background?.mutate() as GradientDrawable
                gradientDrawable.setColor(Color.parseColor("#EDEFF3"))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        return root
    }

    private fun loadUi() {
        val tabCount = fragmentOrderBinding.tabLayout.tabCount
        for (i in 0 until tabCount){
            var itemTabAddBinding = ItemtabAddBinding.inflate(LayoutInflater.from(root.context),null,false )
            val tabAt = fragmentOrderBinding.tabLayout.getTabAt(i)
            tabAt?.customView = itemTabAddBinding.root
            itemTabAddBinding.text.text = listCategory[i].name
            if (i==0){
                itemTabAddBinding.cons.elevation = 2F
                itemTabAddBinding.text.setTextColor(Color.BLACK)
                var gradientDrawable = itemTabAddBinding.cons.background.mutate() as GradientDrawable
                gradientDrawable.setColor(Color.WHITE)
            }else{
                itemTabAddBinding.cons.elevation = 0F
                itemTabAddBinding.text.setTextColor(Color.parseColor("#8D9BA8"))
                var gradientDrawable = itemTabAddBinding.cons.background.mutate() as GradientDrawable
                gradientDrawable.setColor(Color.parseColor("#EDEFF3"))
            }
        }
    }

    private fun loadCategory() {
        listCategory = ArrayList()
        listCategory.add(Category("Klassik"))
        listCategory.add(Category("Katta"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}