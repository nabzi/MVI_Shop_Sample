package com.example.google_map_sample.network
import com.nabzi.mvi.model.Product
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/")
    fun getProductList() : Response<List<Product>>

}
