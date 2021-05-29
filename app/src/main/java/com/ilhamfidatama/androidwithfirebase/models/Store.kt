package com.ilhamfidatama.androidwithfirebase.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Store(
    var name: String = "",
    var address: String = "",
    var products: MutableList<Product> = mutableListOf()
): Parcelable
