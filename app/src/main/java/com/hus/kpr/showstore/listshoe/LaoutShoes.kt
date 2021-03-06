package com.hus.kpr.showstore.listshoe

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.hus.kpr.showstore.R
import com.hus.kpr.showstore.data.DataShoe
import com.hus.kpr.showstore.databinding.TextRowItemBinding

import android.widget.LinearLayout
import com.hus.kpr.showstore.databinding.FragmentShoeListListBinding

class LaoutShoes: LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    val binding: TextRowItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.text_row_item, this, false)


    fun loadingShoeToList(shoe: DataShoe) {
        binding.apply {
            addView(this.root)
            numberText.text  = shoe.number
            modelTextRow.text = shoe.model
            colorTextRow.text = shoe.color
            sizeTextRow.text = shoe.size
            descTextRow.text = shoe.description
        }
    }


}