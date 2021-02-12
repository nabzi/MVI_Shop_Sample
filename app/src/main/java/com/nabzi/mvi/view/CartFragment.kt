package com.nabzi.mvi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.nabzi.mvi.databinding.FragmentCartBinding
import com.nabzi.mvi.view.adapter.ProductInCartAdapter

interface CartFragmentHandler {
    fun onFabMenuClick()
}
class CartFragment  : Fragment() , MvRxView ,
    CartFragmentHandler {
    private lateinit var binding : FragmentCartBinding
    private val viewModel: ProductsViewModel by activityViewModel()
    private val  adapter = ProductInCartAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        binding.rvProducts.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun invalidate()  = withState(viewModel) { state ->
        binding.state = state
    }

    override fun onFabMenuClick() {
        TODO("Not yet implemented")
    }
}