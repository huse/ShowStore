package com.hus.kpr.showstore.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hus.kpr.showstore.R
import com.hus.kpr.showstore.data.DataShoe
import java.util.*

class CustomAdapter(private var listOfShoes: MutableList<DataShoe>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val shoe = listOfShoes[position]
/*        viewHolder.shoeNumber.text = shoe.number
        viewHolder.shoeModel.text = shoe.model
        viewHolder.shoeSize.text = shoe.size
        viewHolder.shoeColor.text = shoe.color
        viewHolder.shoeDescription.text = shoe.description*/
    }

    override fun getItemCount(): Int {
        return listOfShoes.size
    }

}