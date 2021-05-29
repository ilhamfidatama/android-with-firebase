package com.ilhamfidatama.androidwithfirebase.models


data class Store(
    var name: String = "",
    var address: String = "",
    var products: MutableList<Product> = mutableListOf()
)
