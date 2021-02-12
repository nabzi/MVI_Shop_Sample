package com.nabzi.mvi.view
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Uninitialized
import com.nabzi.mvi.model.Product

data class ProductState(
    val products: Async<List<Product>> = Uninitialized,
    val addedProductIds: List<Long> = arrayListOf(),
    val addToCartRequest: Async<Product> = Uninitialized
) :  MavericksState{
    val addedProducts = addedProductIds.map { id -> product(id) }
    fun product(productId: Long?): Product? = products()?.firstOrNull { it.id == productId }
}
