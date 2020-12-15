package com.github.yuk7.chronfig.ui.main

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yuk7.chronfig.data.repository.config.Config
import com.github.yuk7.chronfig.models.ItemModelInterface
import com.github.yuk7.chronfig.models.SpecialItemModel
import com.github.yuk7.chronfig.models.UserConfigModel
import com.github.yuk7.chronfig.ui.NewConfigActivity

class MainViewModel : ViewModel() {
    val list = MutableLiveData<List<ItemModelInterface>>(emptyList())
    val onStartActivity = MutableLiveData<Pair<Activity, Bundle?>>()

    fun fabOnClick() {
        onStartActivity.value = Pair(NewConfigActivity(), null)
    }

    fun add(item: ItemModelInterface) {
        list.apply {
            this.value?.let {
                val list = it.toMutableList()
                list.add(item)
                this.value = list
            }
        }
    }

    fun removeAll() {
        list.apply {
            this.value = emptyList()
        }
    }
}