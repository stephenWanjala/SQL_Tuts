package com.stephenwanjala.sqltuts.home.data

import com.stephenwanjala.sqltuts.R
import com.stephenwanjala.sqltuts.home.HomeSectionItem

object HomeItemsData {
    val homeSectionItems:List<HomeSectionItem> =
        listOf(
            HomeSectionItem(
                resId = R.drawable.mysql_basics,
                tittle = "MySQL Basics",
                body = "This MySQL basics section provides you with everything you need to know to manage data in MySQL effectively"
            ),
            HomeSectionItem(
                resId = R.drawable.mysql_stored_procedure,
                tittle = "MySQL Stored Procedures",
                body = "In this section, you will learn how to create stored procedures and stored functions in MySQL with clear explanation and practical examples."
            ),
            HomeSectionItem(
                resId = R.drawable.mysql_views,
                tittle = " MySQL Views",
                body = "This tutorial introduces you to MySQL Views, which are named query stored in the database, and shows you step by step on how to manage views effectively."
            ),
            HomeSectionItem(
                resId = R.drawable.mysql_index,
                tittle = "MySQL Index",
                body = "This section introduces you to the MySQL index concept and shows you how to manage indexes in MySQL to optimize your queries."
            )
        )
}