package com.nabzi.mvi.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.nabzi.mvi.databinding.FragmentHomeBinding
import com.nabzi.mvi.model.Product
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*

interface HomeFragmentHandler {
    fun onAddToCartClicked(product: Product)
    fun onCartFabClick()
}
class HomeFragment  : Fragment() , MvRxView ,
    HomeFragmentHandler {
    private lateinit var binding : FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModel()
    private val  adapter = ProductAdapter(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this


        binding.rvProducts1.adapter = adapter
       // adapter.submitList(itemList)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSlider()
    }

    private fun setupSlider() {
        var sliderAdapter = SliderAdapter()
        sliderAdapter.addItem(SlidingItem("https://homepages.cae.wisc.edu/~ece533/images/airplane.png"))
        sliderAdapter.addItem(SlidingItem("https://homepages.cae.wisc.edu/~ece533/images/boat.png"))
        sliderAdapter.addItem(SlidingItem("https://homepages.cae.wisc.edu/~ece533/images/girl.png"))
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

    override fun invalidate()  = withState(viewModel) { state ->
        binding.state = state
    }

    override fun onAddToCartClicked(product: Product) {
        viewModel.addToCart(product.id)
    }

    override fun onCartFabClick() {
        //findNavController().navigate()
    }
}