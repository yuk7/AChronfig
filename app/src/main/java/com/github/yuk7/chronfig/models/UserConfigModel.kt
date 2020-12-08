package com.github.yuk7.chronfig.models

import com.github.yuk7.chronfig.data.repository.config.Config

data class UserConfigModel(override val name: String = "", override val config: Config) : ItemModelInterface,UserConfigInterface