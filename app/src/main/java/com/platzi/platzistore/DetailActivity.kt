package com.platzi.platzistore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.content_descr.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.startActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val db = DBOpenHelper.getInstance(this)

        intent?.extras?.let {
            val titl = it.getString("title")
            val des = it.getString("desc")
            val pric = it.getDouble("price")
            txtDetailTitulo.text = it.getString("title")
            txtDetailDesc.text = it.getString("desc")
            txtDetailPrice.text = "$ ${String.format("%.2f", it.getDouble("price"))}"

            btnDetailBuy.setOnClickListener{
                db?.use {
                    val namePr = "title" to titl
                    val descPr = "desc" to des
                    val pricePr = "price" to pric
                    insert("Productos", namePr, descPr, pricePr)
                }
                startActivity<ShopCartActivity>()

            }

        }
    }
}
