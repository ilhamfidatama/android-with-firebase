package com.ilhamfidatama.androidwithfirebase.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data<T>(
    var data: T,
    var key: String
): Parcelable