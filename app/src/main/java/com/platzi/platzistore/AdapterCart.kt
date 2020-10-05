package com.platzi.platzistore

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_landing.view.*


class AdapterCart (val data: List<ItemLanding>) : RecyclerView.Adapter<AdapterCart.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder =
        Holder(p0.inflate(R.layout.item_landing))

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.bindView(data[p1])
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(itemLanding: ItemLanding) {
            with(itemLanding) {
                itemView.txtTitleItem.text = title
                itemView.txtDescItem.text = desc
                itemView.txtPriceItem.text = "$ ${String.format("%.2f", price)}"
            }
        }
    }
}