package com.stephenwanjala.sqltuts.home

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class HomeSectionItem(
    @DrawableRes val resId: Int,
    val tittle: String,
    val body: String
)
