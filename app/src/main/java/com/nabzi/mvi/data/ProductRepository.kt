package com.nabzi.mvi.data

import com.nabzi.mvi.model.Product
import com.nabzi.mvi.model.ProductType
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ProductRepository {
    fun getProducts() = Observable.fromCallable<List<Product>> {
        fetchProductsFromServer()
    }.subscribeOn(Schedulers.io())

    fun addToCart(product: Product) = Single.just(product)
        .delaySubscription(2, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.io())

    fun fetchProductsFromServer() : List<Product>{
        Thread.sleep(2000)
        return arrayListOf<Product>(
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
    }
}
