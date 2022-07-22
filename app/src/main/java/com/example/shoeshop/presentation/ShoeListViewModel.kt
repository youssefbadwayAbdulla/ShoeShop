package com.example.shoeshop.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeshop.domain.model.ShoeModel

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<ShoeModel>>()
    val shoeList: LiveData<MutableList<ShoeModel>>
        get() = _shoeList

    fun addItemShoe(shoeItem: ShoeModel) {
        if (_shoeList.value == null) {
            _shoeList.value = mutableListOf(shoeItem)
        } else {
            _shoeList.value?.add(shoeItem)
        }

    }

}