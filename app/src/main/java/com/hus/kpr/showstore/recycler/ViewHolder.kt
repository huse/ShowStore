package com.hus.kpr.showstore.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hus.kpr.showstore.R

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val shoeNumber: TextView = itemView.findViewById(R.id.number_text)
    val shoeModel: TextView = itemView.findViewById(R.id.model_text_row)
    val shoeSize: TextView = itemView.findViewById(R.id.size_text_row)
    val shoeColor: TextView = itemView.findViewById(R.id.color_text_row)
    val shoeDescription: TextView = itemView.findViewById(R.id.desc_text_row)

    override fun onClick(v: View) {}

}