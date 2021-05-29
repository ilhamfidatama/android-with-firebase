package com.ilhamfidatama.androidwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilhamfidatama.androidwithfirebase.adapter.ProductAdapter
import com.ilhamfidatama.androidwithfirebase.databinding.ActivityStoreBinding

class StoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoreBinding
    private val adapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productRv.adapter = adapter
        binding.productRv.layoutManager = LinearLayoutManager(this)
        binding.productRv.setHasFixedSize(true)

        binding.productAddFab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            intent.putExtra(Utils.ADD_MODE, true)

            startActivity(intent)
        }
    }
}