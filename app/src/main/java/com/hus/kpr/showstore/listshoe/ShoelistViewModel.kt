package com.hus.kpr.showstore.listshoe

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hus.kpr.showstore.data.DataShoe
import com.hus.kpr.showstore.*


class ShoelistViewModel : ViewModel(), Observable {
    private val propertyChangeRegistry = PropertyChangeRegistry()

    private val shoes = MutableLiveData<MutableList<DataShoe>>(mutableListOf())


    var shoe = DataShoe()
        set(value) {
            if(value != field) {
                field = value
                propertyChangeRegistry.notifyChange(this, 6)
            }
        }

    fun getShoesLiveDatas(): LiveData<MutableList<DataShoe>> = shoes

    fun addShoes(item: DataShoe?) {
        item?.let {
            shoes.value?.add(item)


/*            DataShoe(
                "1",
                binding.shoeModelEdit.text.toString(),
                binding.shoeSizeEdit.text.toString(),
                binding.shoeColorEdit.text.toString(),
                binding.shoeDescriptionEdit.text.toString()
            ).also { binding.dataShoeInxmlfile = it }*/
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

    val shoesLists = MutableLiveData<MutableList<DataShoe>>(mutableListOf())


    val shoes2: LiveData<MutableList<DataShoe>>
        get() = shoesLists

    fun saveCurrentDetail(detail: DataShoe?) {
        detail?.let { shoesLists.value?.add(it) }
    }
}