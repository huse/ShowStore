package com.hus.kpr.showstore.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hus.kpr.showstore.R

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    val textView: TextView
    override fun onClick(v: View) {}

    init {
        textView = itemView.findViewById<View>(R.id.textView) as TextView
    }
}