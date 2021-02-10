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
import com.nabzi.mvi.view.SliderAdapter
import com.nabzi.mvi.view.bindImageFromUrl
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment  : Fragment(){
    lateinit var adapter : ItemAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val navController = NavHostFragment.findNavController(this)
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        //binding.tmp  = "https://www.quoteshacks.com/wp-content/uploads/2019/07/Sad-.jpg"

        var itemList = arrayListOf<Item>(
            Item (1,"item1" , "desc1" , "https://homepages.cae.wisc.edu/~ece533/images/airplane.png" , 100f),
            Item (2,"item2" , "desc2" , "https://homepages.cae.wisc.edu/~ece533/images/boat.png" , 200f),
            Item (3,"item3" , "desc3" , "https://homepages.cae.wisc.edu/~ece533/images/girl.png" , 300f),
            Item (4,"item4" , "desc5" , "https://homepages.cae.wisc.edu/~ece533/images/airplane.png" , 400f)
        )
        adapter = ItemAdapter {
            //add item to cart
        }
        binding.rvItems1.adapter = adapter
        adapter.submitList(itemList)
       // val toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        //setSupportActionBar(toolbar)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSlider()
    }

    private fun setupSlider() {
        var sliderAdapter = SliderAdapter()
        sliderAdapter.addItem(Item(10,"titr" , "" ,"https://homepages.cae.wisc.edu/~ece533/images/airplane.png",0f ))
        sliderAdapter.addItem(Item(20,"titr2" , "" ,"https://homepages.cae.wisc.edu/~ece533/images/boat.png",0f ))
        sliderAdapter.addItem(Item(30,"titr3" , "" ,"https://homepages.cae.wisc.edu/~ece533/images/girl.png" ,0f))
        imageSlider.setSliderAdapter(sliderAdapter);
        imageSlider.run{
            setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
            setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
            setIndicatorSelectedColor(Color.WHITE);
            setIndicatorUnselectedColor(Color.GRAY);
            setScrollTimeInSec(4); //set scroll delay in seconds :
            startAutoCycle();

        }
    }
}