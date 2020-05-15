package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.adapter.ProductItemListAdapter
import com.ibuild.getac.databinding.ActivityStoreBinding
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.activity_store.*

class StoreActivity : AppCompatActivity() {

    lateinit var binding : ActivityStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_store)

        txtNameAdressStore.text = getIntent().getStringExtra("STORENAME")
        txtAdressStore.text = getIntent().getStringExtra("STOREADRESS")

        productList.adapter = ProductItemListAdapter(products(), this) {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("PRODUCT", it)
            startActivity(intent)
        }
        productList.layoutManager = LinearLayoutManager(this)
    }

    private fun products(): List<Product> {
        return listOf(
            Product("Nome do produto 1", 3.50, "un", "Tok\u0026Stok"),
            Product("Nome do produto 2", 9.99, "kg", "Leroy Merlin"),
            Product("Nome do produto 3", 5.75, "litro", "C\u0026C"),
            Product("Nome do produto 4", 7.50, "un", "Telhanorte"),
            Product("Nome do produto 5", 2.30, "metro", "Dicico"),
            Product("Nome do produto 6", 2.30, "metro", "Dicico"),
            Product("Nome do produto 7", 2.30, "metro", "Dicico"),
            Product("Nome do produto 8", 2.30, "metro", "Dicico"),
            Product("Nome do produto 9", 2.30, "metro", "Dicico"),
            Product("Nome do produto 10", 2.30, "metro", "Dicico"),
            Product("Nome do produto 11", 2.30, "metro", "Dicico"),
            Product("Nome do produto 12", 2.30, "metro", "Dicico"),
            Product("Nome do produto 13", 2.30, "metro", "Dicico")
        )
    }
}