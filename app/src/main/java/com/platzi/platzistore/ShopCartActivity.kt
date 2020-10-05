package com.platzi.platzistore

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_shop_cart.*
import org.jetbrains.anko.db.select

class ShopCartActivity : AppCompatActivity() {

    val items = arrayListOf<ItemLanding>()
    lateinit var adapter: AdapterCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_cart)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rcCart.layoutManager = layoutManager
        rcCart.setHasFixedSize(true)

        adapter = AdapterCart(items)

        rcCart.adapter = AdapterCart(items)

    }

    override fun onResume() {
        super.onResume()
        val db = DBOpenHelper.getInstance(this)
        db?.use {
            select("Productos").exec {
                Log.e("Columnas:", "${this.columnCount}")
                Log.e("Columnas:", "${this.columnNames.size}")

                (this.columnNames).map {
                    Log.e("Columna: ", "$it")
                    Log.e("Columna: ", "${this.getColumnIndex(it)}")
                    Log.e("Columna: ", "${this.getColumnName(this.getColumnIndex(it))}")
                }

                this.moveToFirst()
                do {
                    Log.e("VALUE", this.getString(1) ?: "")
                    Log.e("VALUE", this.getString(2) ?: "")
                    Log.e("VALUE", "${this.getDouble(3)}")

                    items.add(
                        ItemLanding(
                            this.getString(1) ?: "",
                            this.getString(2) ?: "",
                            this.getDouble(3)
                        )
                    )
                    adapter.notifyDataSetChanged()


                } while (this.moveToNext())

            }
        }
    }
}