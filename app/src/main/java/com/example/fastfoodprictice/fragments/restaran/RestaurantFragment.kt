package com.example.fastfoodprictice.fragments.restaran

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.RestaurantAdapter
import com.example.fastfoodprictice.databinding.FragmentRestaurantBinding
import com.example.fastfoodprictice.databinding.ItemTabBinding
import com.example.fastfoodprictice.models.Category
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantFragment : Fragment() {
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
    lateinit var fragmentRestaurantBinding: FragmentRestaurantBinding
    lateinit var root:View
    lateinit var restaurantAdapter: RestaurantAdapter
    lateinit var listCategory:ArrayList<Category>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      fragmentRestaurantBinding = FragmentRestaurantBinding.inflate(inflater,container,false)
        root = fragmentRestaurantBinding.root
        loadCategory()
        restaurantAdapter = RestaurantAdapter(listCategory,requireActivity())
        fragmentRestaurantBinding.viewpager2.adapter = restaurantAdapter
        TabLayoutMediator(fragmentRestaurantBinding.tabLayout,fragmentRestaurantBinding.viewpager2){ tab,position->
            tab.text = listCategory[position].name
        }.attach()
        setText()
        fragmentRestaurantBinding.tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val itemTabBinding = tab?.customView?.let { ItemTabBinding.bind(it) }
                itemTabBinding?.textItem?.setTextColor(Color.parseColor("#FCB600"))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val itemTabBinding = tab?.customView?.let { ItemTabBinding.bind(it) }
                itemTabBinding?.textItem?.setTextColor(Color.parseColor("#8D9BA8"))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        return root
    }

    private fun setText() {
        val tabCount = fragmentRestaurantBinding.tabLayout.tabCount
        for (i in 0 until tabCount){
            val itemTabBinding = ItemTabBinding.inflate(LayoutInflater.from(root.context), null, false)
            val tabAt = fragmentRestaurantBinding.tabLayout.getTabAt(i)
            tabAt?.customView = itemTabBinding.root
            itemTabBinding.textItem.text = listCategory[i].name
            if (i==0){
                itemTabBinding.textItem.setTextColor(Color.parseColor("#FCB600"))
            }else{
                itemTabBinding.textItem.setTextColor(Color.parseColor("#8D9BA8"))
            }
        }
    }

    private fun loadCategory() {
        listCategory = ArrayList()
        listCategory.add(Category("Toshkent"))
        listCategory.add(Category("Qashqadaryo"))
        listCategory.add(Category("Surxandaryo"))
        listCategory.add(Category("Navoiy"))
        listCategory.add(Category("Xorazm"))
        listCategory.add(Category("Samarqand"))
        listCategory.add(Category("Buxoro"))
        listCategory.add(Category("Sirdaryo"))
        listCategory.add(Category("Andijon"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RestaurantFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RestaurantFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}