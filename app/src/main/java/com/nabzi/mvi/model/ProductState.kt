package com.nabzi.mvi.model
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Uninitialized

data class ProductState(
    val products: Async<List<Product>> = Uninitialized,
    val addedProductIds: List<Long> = emptyList(),
    val addToCartRequest: Async<Product> = Uninitialized
) :  MavericksState{
    val addedProducts = addedProductIds.map { id -> product(id) }
    val sum = addedProducts.sumByDouble { it?.price!!.toDouble() }
    fun product(productId: Long?): Product? = products()?.firstOrNull { it.id == productId }
}
