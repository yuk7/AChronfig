package com.github.yuk7.chronfig.data.repository.config

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Config {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "is_use_cmd")
    var isUseCmd: Boolean = false

    @ColumnInfo(name = "ua")
    var ua: String? = ""

    @ColumnInfo(name = "command")
    var command: String? = ""
}