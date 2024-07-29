package com.stephenwanjala.sqltuts.home

import androidx.annotation.DrawableRes
import com.stephenwanjala.sqltuts.Screen
import kotlinx.serialization.Serializable

@Serializable
data class HomeSectionItem(
    @DrawableRes val resId: Int,
    val tittle: String,
    val body: String,
    val route:Screen?=null
)
