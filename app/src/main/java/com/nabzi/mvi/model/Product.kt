package com.nabzi.mvi.model

data class Product (
    var id       : Long,
    var title    : String,
    var desc     : String,
    var type     : String,
    var imageUrl : String,
    var price    : Float
)