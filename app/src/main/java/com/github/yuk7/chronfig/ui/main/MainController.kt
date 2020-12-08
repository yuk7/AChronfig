package com.github.yuk7.chronfig.ui.main

import com.airbnb.epoxy.TypedEpoxyController
import com.github.yuk7.chronfig.models.ItemModelInterface
import com.github.yuk7.chronfig.uaItem

class MainController(
        private val listener: Listener
) : TypedEpoxyController<List<ItemModelInterface>>() {
    override fun buildModels(data: List<ItemModelInterface>?) {
        requireNotNull(data)

        data.forEachIndexed { index, specialItemModel ->
            uaItem {
                id(index)
                title(specialItemModel.name)
                listener { _ -> listener.onClickItem(index, specialItemModel) }
            }
        }
    }

    interface Listener {
        fun onClickItem(index: Int, item: ItemModelInterface)
    }
}