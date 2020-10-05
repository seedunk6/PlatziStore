package com.platzi.platzistore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcViewLanding.layoutManager = GridLayoutManager(this, 2)

        val itemsShop = (0..20).map {
            ItemLanding("Titulo $it", "Desc $it", 200.00 + it)
        }

        val adapter = AdapterLanding(itemsShop)
        rcViewLanding.adapter = adapter

    }
}
