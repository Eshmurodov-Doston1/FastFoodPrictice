package com.example.fastfoodprictice.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.findNavController
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.FoodRv
import com.example.fastfoodprictice.databinding.FragmentMainBinding
import com.example.fastfoodprictice.models.Add
import com.example.fastfoodprictice.models.FastFood
import com.example.fastfoodprictice.utils.MyList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
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
    lateinit var fragmentMainBinding:FragmentMainBinding
    lateinit var root:View
    lateinit var foodRv: FoodRv
    lateinit var listFood:ArrayList<FastFood>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      fragmentMainBinding = FragmentMainBinding.inflate(inflater,container,false)
        root = fragmentMainBinding.root
        loadFood()
        foodRv = FoodRv(object:FoodRv.OnItemClickListener{
            override fun onItemClick(fastFood: FastFood, position: Int) {
                var bundle = Bundle()
                bundle.putString("image",fastFood.image)
                bundle.putString("rate",fastFood.rate)
                findNavController().navigate(R.id.orderFragment,bundle)
            }
            override fun saveSasket(fastFood: FastFood, position: Int) {
                MyList.listSave.add(Add(fastFood.name,fastFood.rate,fastFood.image,1))
                Toast.makeText(root.context, "Savatga qo`shildi", Toast.LENGTH_SHORT).show()
            }
        })
        foodRv.submitList(listFood)
        fragmentMainBinding.myRv.adapter = foodRv
        fragmentMainBinding.myRv.isNestedScrollingEnabled=false
        return root
    }

    private fun loadFood() {
        listFood = ArrayList()
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Xotdog","https://i.ytimg.com/vi/VUV-fsiHUwM/hqdefault.jpg","10000"))
        listFood.add(FastFood("Burger","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR33Aie_Ac4Uiv8NxsfVJfabSsv5tYd-_sMAw&usqp=CAU","15000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
        listFood.add(FastFood("Lavash","https://static.1000.menu/img/content-v2/43/f0/42850/farshirovannyi-lavash-v-duxovke_1580382171_10_max.jpg","19000"))
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}