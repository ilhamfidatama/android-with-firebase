package com.ilhamfidatama.androidwithfirebase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilhamfidatama.androidwithfirebase.adapter.StoreAdapter
import com.ilhamfidatama.androidwithfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = StoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storeRv.adapter = adapter
        binding.storeRv.layoutManager = LinearLayoutManager(this)
        binding.storeRv.setHasFixedSize(true)

        binding.storeAddFab.setOnClickListener {
            val intent = Intent(this, FormStoreActivity::class.java)
            intent.putExtra(Utils.ADD_MODE, true)

            startActivity(intent)
        }
    }
}