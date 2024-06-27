package com.stephenwanjala.sqltuts

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stephenwanjala.sqltuts.home.presentation.Home
import com.stephenwanjala.sqltuts.home.presentation.components.GettingStarted
import com.stephenwanjala.sqltuts.home.presentation.components.MySqlForDevelopers

@Composable
fun NavigationHost(modifier: Modifier = Modifier, navHostController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screens.Home.route,
    ) {
        composable(Screens.Home.route){
            Home(navController = navHostController)
        }

        composable(Screens.GettingStarted.route){
            GettingStarted(navController = navHostController)
        }

        composable(Screens.MySQLTutorialForDevelopers.route){
            MySqlForDevelopers(navController = navHostController)
        }
    }
}

sealed class Screens(val route:String){
    data object Home:Screens("Home")
    data object GettingStarted:Screens("Getting Started")
    data object MySQLTutorialForDevelopers:Screens("MySQL Tutorial for Developers")
}