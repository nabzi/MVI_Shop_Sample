package com.nabzi.mvi.model

data class Item (
    var id       : Long,
    var title    : String,
    var desc     : String,
    var imageUrl : String,
    var price    : Float
)