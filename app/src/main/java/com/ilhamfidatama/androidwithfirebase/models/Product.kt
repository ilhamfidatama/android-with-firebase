package com.ilhamfidatama.androidwithfirebase.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    var name: String = "",
    var price: Double = 0.0,
    var disc: Double = 0.0,
    var discPrice: Double = 0.0
): Parcelable