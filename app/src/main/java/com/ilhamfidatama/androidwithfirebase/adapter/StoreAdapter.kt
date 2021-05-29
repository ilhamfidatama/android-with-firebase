package com.ilhamfidatama.androidwithfirebase.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilhamfidatama.androidwithfirebase.StoreActivity
import com.ilhamfidatama.androidwithfirebase.Utils
import com.ilhamfidatama.androidwithfirebase.databinding.StoreItemsBinding
import com.ilhamfidatama.androidwithfirebase.models.Data
import com.ilhamfidatama.androidwithfirebase.models.Store

class StoreAdapter: RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {
    var stores = mutableListOf<Data<Store>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder = StoreViewHolder(
        StoreItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = stores.size

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.viewBinding(stores[position])
    }

    inner class StoreViewHolder(val binding: StoreItemsBinding): RecyclerView.ViewHolder(binding.root){
        fun viewBinding(store: Data<Store>){
            binding.storeNameTv.text = store.data.name
            binding.storeAddressTv.text = store.data.address
            binding.storeProductsTv.text = store.data.products.size.toString()

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, StoreActivity::class.java)
                intent.putExtra(Utils.DATA, store)

                binding.root.context.startActivity(intent)
            }
        }
    }
}