package com.stephenwanjala.sqltuts.home

import androidx.annotation.DrawableRes

data class HomeSectionItem(
    @DrawableRes val resId: Int,
    val tittle: String,
    val body: String
)
