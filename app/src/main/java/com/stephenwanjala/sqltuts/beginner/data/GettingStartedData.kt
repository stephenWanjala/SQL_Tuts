package com.stephenwanjala.sqltuts.beginner.data

import com.stephenwanjala.sqltuts.Screen

object GettingStartedData {
    val introData:List<MySQLIntroData> = listOf(
        MySQLIntroData(
            title = "Introduction to MySQL",
            body = "Give a quick introduction to databases and MySQL as a Relational Database Management System (RDBMS)",
            route = Screen.Intro2MYSQL
        ),

        MySQLIntroData(
            title = "Install MySQL",
            body = "Show you step by step how to install MySQL Server on your computer for practicing with the tutorials",
            route = Screen.InstallingMYSQL
        ),

        MySQLIntroData(
            title = "Connect to MySQL Server",
            body = "Walk you through the steps of connecting to the MySQL Server using mysql client program.",
            route = Screen.ConnectToServer
        ),
        MySQLIntroData(
            title = "Download a MySQL Sample Database",
            body = "Introduce you to a sample database called classicmodels and provide you with the link to download it",
            route = Screen.DownLoadDataSample
        ),
        )

}


data class MySQLIntroData(
    val title:String,
    val body:String,
    val route:Screen
)