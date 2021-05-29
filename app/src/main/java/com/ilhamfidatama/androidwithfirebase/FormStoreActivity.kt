package com.ilhamfidatama.androidwithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.ilhamfidatama.androidwithfirebase.databinding.ActivityFormStoreBinding
import com.ilhamfidatama.androidwithfirebase.models.Data
import com.ilhamfidatama.androidwithfirebase.models.Store

class FormStoreActivity : AppCompatActivity(), ButtonListener<Store> {
    private lateinit var binding: ActivityFormStoreBinding
    private lateinit var key: String
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mode = intent.getBooleanExtra(Utils.ADD_MODE, false)

//        if (!mode){
//            val data = intent.getParcelableExtra<Data<Store>>(Utils.DATA)
//            data?.let {
//                key = it.key
//                setupStore(it.data)
//            }
//        }

        binding.storeSaveBtn.setOnClickListener {
            val store = Store()
            store.name = binding.storeNameEdt.text.toString()
            store.address = binding.storeAddressEdt.text.toString()

            if (mode){
                simpanData(store)
            }else{
                updateData(key, store)
            }
        }
    }

    override fun simpanData(data: Store) {
        db.collection("store").add(data)
            .addOnSuccessListener {
                Toast.makeText(this, "sukses di tambahkan ${it.path}", Toast.LENGTH_SHORT).show()
                Log.d("add-store", "sukses di tambahkan ${it.path}, ${it.get()}")
            }
            .addOnFailureListener {
                Toast.makeText(this, "gagal di tambahakan ${it.message}", Toast.LENGTH_LONG).show()
                Log.e("add-store", "gagal di tambahakan ${it.message}")
            }
    }

    override fun updateData(key: String?, data: Store) {
        TODO("Not yet implemented")
    }

    private fun setupStore(store: Store){
        binding.storeAddressEdt.setText(store.address)
        binding.storeNameEdt.setText(store.name)
    }
}