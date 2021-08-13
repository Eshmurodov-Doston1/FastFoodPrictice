package com.example.fastfoodprictice.fragments.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.FoodRv
import com.example.fastfoodprictice.databinding.FragmentMenuCategoryBinding
import com.example.fastfoodprictice.models.FastFood

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuCategoryFragment : Fragment() {
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
    lateinit var fragmentMenuCategoryBinding: FragmentMenuCategoryBinding
    lateinit var root:View
    lateinit var foodRv: FoodRv
    lateinit var listFood:ArrayList<FastFood>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       fragmentMenuCategoryBinding = FragmentMenuCategoryBinding.inflate(inflater,container,false)
        root = fragmentMenuCategoryBinding.root
        loadListFood()
        foodRv = FoodRv(object:FoodRv.OnItemClickListener{
            override fun onItemClick(fastFood: FastFood, position: Int) {
                var bundle = Bundle()
                bundle.putString("image",fastFood.image)
                bundle.putString("rate",fastFood.rate)
                findNavController().navigate(R.id.orderFragment,bundle)
            }

            override fun saveSasket(fastFood: FastFood, position: Int) {

            }
        })
        foodRv.submitList(listFood)
        fragmentMenuCategoryBinding.rvFood.adapter = foodRv

        return root
    }

    private fun loadListFood() {
        listFood = ArrayList()
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRu8zC94bwIywHI66l6N_fRgQHkKTjuCCUwrA&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrdY4DScE1_Itai4ZAoMKAvy10iOAmILb9og&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcTppRa691ydhFejeK3jAX5ordt87eEtVhew&usqp=CAU","19000"))
       listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRu8zC94bwIywHI66l6N_fRgQHkKTjuCCUwrA&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrdY4DScE1_Itai4ZAoMKAvy10iOAmILb9og&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcTppRa691ydhFejeK3jAX5ordt87eEtVhew&usqp=CAU","19000"))
       listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRu8zC94bwIywHI66l6N_fRgQHkKTjuCCUwrA&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrdY4DScE1_Itai4ZAoMKAvy10iOAmILb9og&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcTppRa691ydhFejeK3jAX5ordt87eEtVhew&usqp=CAU","19000"))
       listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRu8zC94bwIywHI66l6N_fRgQHkKTjuCCUwrA&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrdY4DScE1_Itai4ZAoMKAvy10iOAmILb9og&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcTppRa691ydhFejeK3jAX5ordt87eEtVhew&usqp=CAU","19000"))
       listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRu8zC94bwIywHI66l6N_fRgQHkKTjuCCUwrA&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrdY4DScE1_Itai4ZAoMKAvy10iOAmILb9og&usqp=CAU","19000"))
        listFood.add(FastFood("Lavash","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcTppRa691ydhFejeK3jAX5ordt87eEtVhew&usqp=CAU","19000"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuCategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Int) =
            MenuCategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                }
            }
    }
}