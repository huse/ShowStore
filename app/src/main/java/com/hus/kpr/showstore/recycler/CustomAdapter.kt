package com.hus.kpr.showstore.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hus.kpr.showstore.R
import java.util.*

class CustomAdapter(private val localDataSet: ArrayList<Int>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = localDataSet[position]
        viewHolder.textView.text = item.toString()
    }

    override fun getItemCount(): Int {
        return localDataSet.size
    }
}