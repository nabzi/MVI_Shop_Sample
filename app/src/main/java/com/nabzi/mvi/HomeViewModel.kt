package com.nabzi.mvi

import androidx.lifecycle.ViewModel
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import io.reactivex.Observable

import com.nabzi.mvi.model.Product
import com.nabzi.mvi.model.ProductType
import com.nabzi.mvi.view.ProductState
import io.reactivex.schedulers.Schedulers

class ProductRepository {
    fun getProducts() = Observable.fromCallable<List<Product>> {
        Thread.sleep(2000)
        arrayListOf<Product>(
            Product(
                1,
                "item1",
                "desc1",
                ProductType.PIZZA,
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
                100f
            ),
            Product(
                2,
                "item2",
                "desc2",
                ProductType.PIZZA,
                "https://homepages.cae.wisc.edu/~ece533/images/boat.png",
                200f
            ),
            Product(
                3,
                "item3",
                "desc3",
                ProductType.PIZZA,
                "https://homepages.cae.wisc.edu/~ece533/images/girl.png",
                300f
            ),
            Product(
                4,
                "item4",
                "desc5",
                ProductType.PIZZA,
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
                400f
            )
        )
    }.subscribeOn(Schedulers.io())

}

class HomeViewModel(initialState: ProductState, private val productRepository: ProductRepository) :
    BaseMvRxViewModel<ProductState>(initialState) {
    init {
        productRepository.getProducts().execute { copy(products = it) }
    }
    companion object : MvRxViewModelFactory<HomeViewModel, ProductState> {
        override fun create(viewModelContext: ViewModelContext, state: ProductState): HomeViewModel? {
            val repository = ProductRepository()
            return HomeViewModel(state, repository)
        }
    }
}