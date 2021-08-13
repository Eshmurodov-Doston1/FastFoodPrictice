package com.example.fastfoodprictice.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.AdapterAdd
import com.example.fastfoodprictice.databinding.FragmentAddFoodBinding
import com.example.fastfoodprictice.models.Add

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFoodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFoodFragment : Fragment() {
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
    lateinit var fragmentAddFoodBinding: FragmentAddFoodBinding
    lateinit var root:View
    lateinit var adapterAdd: AdapterAdd
    lateinit var listAdd:ArrayList<Add>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       fragmentAddFoodBinding = FragmentAddFoodBinding.inflate(inflater,container,false)
        root = fragmentAddFoodBinding.root
        loadUi()
        adapterAdd  = AdapterAdd()
        adapterAdd.submitList(listAdd)
        fragmentAddFoodBinding.rvAdd.adapter = adapterAdd
        return root
    }

    private fun loadUi() {
        listAdd = ArrayList()
        listAdd.add(Add("CocaCola","12000","https://icf.listex.info/300x200/3caadd6d-ab1b-0b91-a999-bcb62c5bafb1.jpg",0))
        listAdd.add(Add("CocaCola","12000","https://icf.listex.info/300x200/3caadd6d-ab1b-0b91-a999-bcb62c5bafb1.jpg",0))
        listAdd.add(Add("CocaCola","12000","https://icf.listex.info/300x200/3caadd6d-ab1b-0b91-a999-bcb62c5bafb1.jpg",0))
        listAdd.add(Add("CocaCola","12000","https://icf.listex.info/300x200/3caadd6d-ab1b-0b91-a999-bcb62c5bafb1.jpg",0))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFoodFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Int) =
            AddFoodFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                }
            }
    }
}