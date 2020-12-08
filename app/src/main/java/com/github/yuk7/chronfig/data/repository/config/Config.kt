package com.github.yuk7.chronfig.data.repository.config

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Config(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var name: String = "",
        var isUseCmd: Boolean = false,
        var ua: String? = "",
        var command: String? = ""
)