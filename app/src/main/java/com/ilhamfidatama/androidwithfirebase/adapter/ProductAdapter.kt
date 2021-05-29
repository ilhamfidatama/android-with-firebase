package com.ilhamfidatama.androidwithfirebase.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilhamfidatama.androidwithfirebase.FormProductActivity
import com.ilhamfidatama.androidwithfirebase.Utils
import com.ilhamfidatama.androidwithfirebase.databinding.ProductItemsBinding
import com.ilhamfidatama.androidwithfirebase.models.Data
import com.ilhamfidatama.androidwithfirebase.models.Product

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    var products = mutableListOf<Data<Product>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder = ProductViewHolder(
        ProductItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.viewBinding(products[position])
    }

    override fun getItemCount(): Int = products.size

    inner class ProductViewHolder(val binding: ProductItemsBinding): RecyclerView.ViewHolder(binding.root){
        fun viewBinding(product: Data<Product>){
            binding.productNameTv.text = product.data.name
            binding.productPriceTv.text = product.data.price.toString()
            if (product.data.disc > 0.0){
                binding.productDiscTv.text = product.data.disc.toString()
                binding.productDiscTv.visibility = View.VISIBLE
            }

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, FormProductActivity::class.java)
                intent.putExtra(Utils.DATA, product)
                intent.putExtra(Utils.ADD_MODE, false)

                binding.root.context.startActivity(intent)
            }
        }
    }
}