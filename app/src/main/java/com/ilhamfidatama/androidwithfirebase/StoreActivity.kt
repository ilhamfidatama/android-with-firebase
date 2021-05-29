package com.ilhamfidatama.androidwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.ilhamfidatama.androidwithfirebase.adapter.ProductAdapter
import com.ilhamfidatama.androidwithfirebase.databinding.ActivityStoreBinding
import com.ilhamfidatama.androidwithfirebase.models.Data
import com.ilhamfidatama.androidwithfirebase.models.Product

class StoreActivity : AppCompatActivity(), ValueEventListener {
    private lateinit var binding: ActivityStoreBinding
    private val adapter = ProductAdapter()
    private val realtimeDB = FirebaseDatabase.getInstance().getReference("products")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        realtimeDB.addValueEventListener(this)

        binding.productRv.adapter = adapter
        binding.productRv.layoutManager = LinearLayoutManager(this)
        binding.productRv.setHasFixedSize(true)

        binding.productAddFab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            intent.putExtra(Utils.ADD_MODE, true)

            startActivity(intent)
        }
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        val products = mutableListOf<Data<Product>>()
        snapshot.children.forEach {
            val key = it.key.toString()
            val product = it.getValue(Product::class.java)
            product?.let { data ->
                products.add(Data(data, key))
            }
        }
        adapter.products.addAll(products)
        adapter.notifyDataSetChanged()
    }

    override fun onCancelled(error: DatabaseError) {
        Toast.makeText(this, "realtime calcelled : ${error.message}", Toast.LENGTH_LONG).show()
    }
}