package com.ilhamfidatama.androidwithfirebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.ilhamfidatama.androidwithfirebase.adapter.StoreAdapter
import com.ilhamfidatama.androidwithfirebase.databinding.ActivityMainBinding
import com.ilhamfidatama.androidwithfirebase.models.Data
import com.ilhamfidatama.androidwithfirebase.models.Store

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = StoreAdapter()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storeRv.adapter = adapter
        binding.storeRv.layoutManager = LinearLayoutManager(this)
        binding.storeRv.setHasFixedSize(true)

        fetchStoreData()

        binding.storeAddFab.setOnClickListener {
            val intent = Intent(this, FormStoreActivity::class.java)
            intent.putExtra(Utils.ADD_MODE, true)

            startActivity(intent)
        }
    }

    fun fetchStoreData(){
        db.collection("store").get()
            .addOnSuccessListener {
                val storesData = mutableListOf<Data<Store>>()
                it.forEach { store ->
                    val data = Data<Store>(
                        data = store.toObject(Store::class.java),
                        key = store.id
                    )
                    storesData.add(data)
                }

                //update recyclerView
                adapter.stores = storesData
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Log.e("fetch-store", "fail : ${it.message}")
            }
    }
}