package com.github.yuk7.chronfig.ui.main

import com.airbnb.epoxy.TypedEpoxyController
import com.github.yuk7.chronfig.models.UserAgentModel
import com.github.yuk7.chronfig.uaItem

class MainController() : TypedEpoxyController<List<UserAgentModel>>() {
    override fun buildModels(data: List<UserAgentModel>?) {
        requireNotNull(data)

        data.forEachIndexed { index, userAgentModel ->
            uaItem {
                id(index)
                title(userAgentModel.name)
            }
        }
    }
}