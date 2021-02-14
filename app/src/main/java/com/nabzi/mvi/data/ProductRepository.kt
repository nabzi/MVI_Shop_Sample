package com.nabzi.mvi.data

import com.example.google_map_sample.network.ApiService
import com.nabzi.mvi.model.Product
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ProductRepository(val apiService : ApiService) {
    fun getProducts() = Observable.fromCallable<List<Product>> {
        fetchFakeProducts()
        //Unfortunately I didn't have enough time to debug my FakeInterceptor, and it doesn't work yet
//        apiService.getProductList().body()
    }.subscribeOn(Schedulers.io())

    fun addToCart(product: Product) = Single.just(product)
        .delaySubscription(2, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.io())

    fun fetchFakeProducts() : List<Product>{
        Thread.sleep(1000)
        return arrayListOf<Product>(
            Product(
                1,
                "item1",
                "desc1",
                "pizza",
                "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_413/https://www.foodiesfeed.com/wp-content/uploads/2019/02/pizza-ready-for-baking-413x275.jpg",
                100f
            ),
            Product(
                2,
                "item2",
                "desc2",
                "pizza",
                    "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_413/https://www.foodiesfeed.com/wp-content/uploads/2019/06/beautiful-vibrant-shot-of-traditional-korean-meals-413x275.jpg",
                200f
            ),
            Product(
                3,
                "item3",
                "desc3",
                "pizza",
                "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_413/https://www.foodiesfeed.com/wp-content/uploads/2019/04/mae-mu-fried-rice-413x330.jpg",
                300f
            ),
            Product(
                4,
                "item4",
                "desc5",
                "pizza",
                "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_413/https://www.foodiesfeed.com/wp-content/uploads/2019/07/neapolitan-pizza-margherita-413x275.jpg",
                400f
            )
        )
    }
}
