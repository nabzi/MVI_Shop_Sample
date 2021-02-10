package com.nabzi.mvi.model

data class Product (
    var id       : Long,
    var title    : String,
    var desc     : String,
    var type     : ProductType,
    var imageUrl : String,
    var price    : Float
)
enum class ProductType{
    PIZZA  , SUSHI , DRINK
}