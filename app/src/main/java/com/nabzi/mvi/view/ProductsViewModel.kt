package com.nabzi.mvi.view

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.nabzi.mvi.data.ProductRepository
import com.nabzi.mvi.di.ServiceLocator
import com.nabzi.mvi.model.ProductState

import io.reactivex.schedulers.Schedulers

class ProductsViewModel(initialState: ProductState ,val  productRepository: ProductRepository) :
    BaseMvRxViewModel<ProductState>(initialState)
{
    init {
        productRepository.getProducts().execute { copy(products = it) }
    }
    fun addToCart(productId : Long ) = withState { state ->
        val addedProduct = state.product(productId) ?: throw IllegalStateException("Product not found")
        productRepository.addToCart(addedProduct)
            .subscribeOn(Schedulers.io())
            .execute {
                copy(addToCartRequest = it ,
                     addedProductIds = if (it.complete) addedProductIds + productId else addedProductIds)
            }
    }

    companion object : MvRxViewModelFactory<ProductsViewModel, ProductState> {
        override fun create(viewModelContext: ViewModelContext, state: ProductState): ProductsViewModel? {
            val productRepository = ServiceLocator.getProductRepository()
            return ProductsViewModel(state , productRepository)
        }
    }
}