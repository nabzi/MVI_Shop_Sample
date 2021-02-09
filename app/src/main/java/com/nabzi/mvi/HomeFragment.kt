package com.nabzi.mvi

import android.R
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.nabzi.mvi.databinding.FragmentHomeBinding
import com.nabzi.mvi.model.Item
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment  : Fragment(){
    lateinit var adapter : ItemAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val navController = NavHostFragment.findNavController(this)
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        var itemList = arrayListOf<Item>(
            Item (1,"item1" , "desc1" , "" , 100f),
            Item (2,"item2" , "desc2" , "" , 200f),
            Item (3,"item3" , "desc3" , "" , 300f),
            Item (4,"item4" , "desc5" , "" , 400f)

        )
        adapter = ItemAdapter {
            //add item to cart
        }
        binding.rvItems1.adapter = adapter
        adapter.submitList(itemList)
       // val toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        //setSupportActionBar(toolbar)
//        collapsing_toolbar_layout.run {
//           // title = "Test Title"
//           // setCollapsedTitleTextAppearance(R.style.coll_toolbar_title)
//            //setExpandedTitleTextAppearance(R.style.exp_toolbar_title)
//           // setContentScrimColor(Color.GREEN)
//        }
        return binding.root
    }
}