package com.example.fastfoodprictice.fragments.menu

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.MenuAdapter
import com.example.fastfoodprictice.databinding.FragmentMenuBinding
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
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
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
    lateinit var fragmentMenuBinding: FragmentMenuBinding
    lateinit var root:View
    lateinit var menuAdapter: MenuAdapter
    lateinit var listCategory:ArrayList<Category>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       fragmentMenuBinding = FragmentMenuBinding.inflate(inflater,container,false)
        root = fragmentMenuBinding.root
        loadCategory()
        menuAdapter = MenuAdapter(listCategory,requireActivity())
        fragmentMenuBinding.viewpager2.adapter = menuAdapter
        TabLayoutMediator(fragmentMenuBinding.tabLayout,fragmentMenuBinding.viewpager2){ tab,position->
            tab.text = listCategory[position].name
        }.attach()
        setTabs()
        fragmentMenuBinding.tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val binding = tab?.customView?.let { ItemTabBinding.bind(it) }
                binding?.textItem?.setTextColor(Color.parseColor("#FCB600"))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val binding = tab?.customView?.let { ItemTabBinding.bind(it) }
                binding?.textItem?.setTextColor(Color.parseColor("#8D9BA8"))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        return root
    }

    private fun setTabs() {
        val tabCount = fragmentMenuBinding.tabLayout.tabCount
        for (i in 0 until tabCount){
            val itemTabBinding = ItemTabBinding.inflate(LayoutInflater.from(root.context), null, false)
            val tabAt = fragmentMenuBinding.tabLayout.getTabAt(i)
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
        listCategory.add(Category("Lavash"))
        listCategory.add(Category("Shaurma"))
        listCategory.add(Category("Donar"))
        listCategory.add(Category("Burger"))
        listCategory.add(Category("Hotdog"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}