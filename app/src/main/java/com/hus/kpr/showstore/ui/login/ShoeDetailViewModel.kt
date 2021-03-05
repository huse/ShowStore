package com.hus.kpr.showstore.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hus.kpr.showstore.data.DataShoe

class ShoeDetailViewModel  : ViewModel() {

    val shoesLists = MutableLiveData<MutableList<DataShoe>>(mutableListOf())


    val shoes: LiveData<MutableList<DataShoe>>
        get() = shoesLists

    fun saveCurrentDetail(detail: DataShoe?) {
        detail?.let { shoesLists.value?.add(it) }
    }
}