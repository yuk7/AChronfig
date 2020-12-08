package com.github.yuk7.chronfig.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yuk7.chronfig.models.ItemModelInterface

class MainViewModel : ViewModel() {
    val list = MutableLiveData<List<ItemModelInterface>>(emptyList())

    fun add(item: ItemModelInterface) {
        list.apply {
            this.value?.let {
                val list = it.toMutableList()
                list.add(item)
                this.value = list
            }
        }
    }
}