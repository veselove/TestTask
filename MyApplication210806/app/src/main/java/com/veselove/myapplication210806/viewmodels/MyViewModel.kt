package com.veselove.myapplication210806.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    val idImageList = mutableListOf<Int>()
    val observableIdImageList = MutableLiveData(mutableListOf<Int>())

    fun addImage(){
        idImageList.add(getRandomInt())
        observableIdImageList.postValue(idImageList)
    }

    fun reloadAll(){
        idImageList.clear()
        for (i in 0..139) {
            idImageList.add(getRandomInt())
        }
        observableIdImageList.postValue(idImageList)
    }

    private fun getRandomInt(): Int{
        return (0..1000).random()
    }
}