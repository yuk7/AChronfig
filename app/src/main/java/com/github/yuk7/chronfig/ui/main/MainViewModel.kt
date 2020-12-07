package com.github.yuk7.chronfig.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yuk7.chronfig.models.UserAgentModel
import com.topjohnwu.superuser.io.SuFile

class MainViewModel : ViewModel() {
    val list = MutableLiveData<List<UserAgentModel>>(emptyList())

    fun add(item: UserAgentModel) {
        list.apply {
            this.value?.let {
                val list = it.toMutableList()
                list.add(item)
                this.value = list
            }
        }
    }
}