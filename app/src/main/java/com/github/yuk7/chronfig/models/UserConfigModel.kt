package com.github.yuk7.chronfig.models

data class UserConfigModel(val id: Int, override val name: String, val isUseCmd: Boolean, val ua: String?, val command: String?) : ItemModelInterface