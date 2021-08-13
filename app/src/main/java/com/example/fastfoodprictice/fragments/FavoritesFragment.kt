package com.example.fastfoodprictice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fastfoodprictice.R
import com.example.fastfoodprictice.adapters.AdapterLeek
import com.example.fastfoodprictice.databinding.AdapterLeekBinding
import com.example.fastfoodprictice.databinding.FragmentFavoritesBinding
import com.example.fastfoodprictice.models.FastFood

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoritesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritesFragment : Fragment() {
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
    lateinit var fragmentFavoritesBinfing:FragmentFavoritesBinding
    lateinit var root:View
    lateinit var adapterLeek: AdapterLeek
    lateinit var listFavorities:ArrayList<FastFood>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      fragmentFavoritesBinfing = FragmentFavoritesBinding.inflate(inflater,container,false)
        root = fragmentFavoritesBinfing.root
        loadLeek()
        adapterLeek = AdapterLeek()
        adapterLeek.submitList(listFavorities)
        fragmentFavoritesBinfing.leekRv.adapter = adapterLeek
        return root
    }

    private fun loadLeek() {
        listFavorities= ArrayList()
        listFavorities.add(FastFood("Lavash","https://smachno.ua/wp-content/uploads/2009/05/maxresdefault-4.jpg","19 000 so`m"))
        listFavorities.add(FastFood("Shaurma","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwFEBntlUkIJUDaExMSepV5ePVPg0Zi2wYqA&usqp=CAU","17 000 so`m"))
        listFavorities.add(FastFood("Xotdog","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ETa46w3ARqLIcxM65WcKauMYgwphTkKqFw&usqp=CAU","10 000 so`m"))
        listFavorities.add(FastFood("Lavash","https://smachno.ua/wp-content/uploads/2009/05/maxresdefault-4.jpg","19 000 so`m"))
        listFavorities.add(FastFood("Shaurma","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwFEBntlUkIJUDaExMSepV5ePVPg0Zi2wYqA&usqp=CAU","17 000 so`m"))
        listFavorities.add(FastFood("Xotdog","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ETa46w3ARqLIcxM65WcKauMYgwphTkKqFw&usqp=CAU","10 000 so`m"))
        listFavorities.add(FastFood("Lavash","https://smachno.ua/wp-content/uploads/2009/05/maxresdefault-4.jpg","19 000 so`m"))
        listFavorities.add(FastFood("Shaurma","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwFEBntlUkIJUDaExMSepV5ePVPg0Zi2wYqA&usqp=CAU","17 000 so`m"))
        listFavorities.add(FastFood("Xotdog","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ETa46w3ARqLIcxM65WcKauMYgwphTkKqFw&usqp=CAU","10 000 so`m"))
        listFavorities.add(FastFood("Lavash","https://smachno.ua/wp-content/uploads/2009/05/maxresdefault-4.jpg","19 000 so`m"))
        listFavorities.add(FastFood("Shaurma","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwFEBntlUkIJUDaExMSepV5ePVPg0Zi2wYqA&usqp=CAU","17 000 so`m"))
        listFavorities.add(FastFood("Xotdog","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ETa46w3ARqLIcxM65WcKauMYgwphTkKqFw&usqp=CAU","10 000 so`m"))
        listFavorities.add(FastFood("Lavash","https://smachno.ua/wp-content/uploads/2009/05/maxresdefault-4.jpg","19 000 so`m"))
        listFavorities.add(FastFood("Shaurma","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwFEBntlUkIJUDaExMSepV5ePVPg0Zi2wYqA&usqp=CAU","17 000 so`m"))
        listFavorities.add(FastFood("Xotdog","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ETa46w3ARqLIcxM65WcKauMYgwphTkKqFw&usqp=CAU","10 000 so`m"))
        listFavorities.add(FastFood("Lavash","https://smachno.ua/wp-content/uploads/2009/05/maxresdefault-4.jpg","19 000 so`m"))
        listFavorities.add(FastFood("Shaurma","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwFEBntlUkIJUDaExMSepV5ePVPg0Zi2wYqA&usqp=CAU","17 000 so`m"))
        listFavorities.add(FastFood("Xotdog","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ETa46w3ARqLIcxM65WcKauMYgwphTkKqFw&usqp=CAU","10 000 so`m"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoritesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoritesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}