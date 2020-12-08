package com.github.yuk7.chronfig.models

import com.github.yuk7.chronfig.data.repository.config.Config

interface UserConfigInterface {
    val config: Config

    fun getCommand() : String {
        return if (config.isUseCmd) {
            config.command
        } else {
            val ua = config.ua.replace("\"","\\\"")
            var command = "chrome "
            command += "--user-agent=\"${ua}\""
            command
        }
    }
}