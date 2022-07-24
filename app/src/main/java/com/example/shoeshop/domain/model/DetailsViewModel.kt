package com.example.shoeshop.domain.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()


    fun makeShoe(): ShoeModel {
        return ShoeModel(
            shoeName.value ?: "",
            shoeCompany.value ?: "", shoeSize.value?.toDouble(), shoeDescription.value ?: ""
        )
    }
}