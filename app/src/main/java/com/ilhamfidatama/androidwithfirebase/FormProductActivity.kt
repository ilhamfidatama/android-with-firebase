package com.ilhamfidatama.androidwithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilhamfidatama.androidwithfirebase.databinding.ActivityFormProductBinding
import com.ilhamfidatama.androidwithfirebase.databinding.ActivityFormStoreBinding
import com.ilhamfidatama.androidwithfirebase.models.Data
import com.ilhamfidatama.androidwithfirebase.models.Product

class FormProductActivity : AppCompatActivity(), ButtonListener<Product> {
    private lateinit var binding: ActivityFormProductBinding
    private lateinit var key: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mode = intent.getBooleanExtra(Utils.ADD_MODE, false)

        if (!mode){
            val data = intent.getParcelableExtra<Data<Product>>(Utils.DATA)
            data?.let {
                key = it.key
                setupProduct(it.data)
            }
        }

        binding.productSaveBtn.setOnClickListener {
            val product = Product()
            product.name = binding.productNameEdt.text.toString()
            product.disc = binding.productDiscEdt.text.toString().toDouble()
            product.price = binding.productPriceEdt.text.toString().toDouble()

            if (mode){
                simpanData(product)
            }else{
                updateData(key, product)
            }
        }
    }

    override fun simpanData(data: Product) {
        TODO("Not yet implemented")
    }

    override fun updateData(key: String?, data: Product) {
        TODO("Not yet implemented")
    }

    private fun setupProduct(product: Product){
        binding.productNameEdt.setText(product.name)
        binding.productDiscEdt.setText("${product.disc}%")
        binding.productPriceEdt.setText(product.price.toString())
    }
}