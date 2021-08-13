package com.example.fastfoodprictice.fragments.restaran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.RestaurantRvAdapter
import com.example.fastfoodprictice.databinding.FragmentRestaranCategoryBinding
import com.example.fastfoodprictice.models.Restaurant

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaranCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaranCategoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
        }
    }
    lateinit var fragmentRestaranCategoryBinding: FragmentRestaranCategoryBinding
    lateinit var root:View
    lateinit var restaurantRvAdapter:RestaurantRvAdapter
    lateinit var listRestaurant:ArrayList<Restaurant>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentRestaranCategoryBinding = FragmentRestaranCategoryBinding.inflate(inflater,container,false)
        root = fragmentRestaranCategoryBinding.root
        loadRestaurant()
        restaurantRvAdapter = RestaurantRvAdapter(object:RestaurantRvAdapter.OnItemClickListener{
            override fun onItemClick(restaurant: Restaurant, position: Int) {

            }
        })
        restaurantRvAdapter.submitList(listRestaurant)
        fragmentRestaranCategoryBinding.rvRestaurant.adapter = restaurantRvAdapter
        return root
    }

    private fun loadRestaurant() {
        listRestaurant = ArrayList()
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
        listRestaurant.add(Restaurant("Algaritm","09:00-13:00","Chilonzor rayoni, Sugoli ota 56"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RestaranCategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Int) =
            RestaranCategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                }
            }
    }
}