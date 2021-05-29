package com.ilhamfidatama.androidwithfirebase

interface ButtonListener<T> {
    fun simpanData(data: T)
    fun updateData(key: String?, data: T)
}