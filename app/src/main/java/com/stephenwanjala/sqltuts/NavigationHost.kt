package com.stephenwanjala.sqltuts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stephenwanjala.sqltuts.home.presentation.Home
import com.stephenwanjala.sqltuts.home.presentation.components.GettingStarted
import com.stephenwanjala.sqltuts.home.presentation.components.MySqlForDevelopers
import kotlinx.serialization.Serializable

@Composable
fun NavigationHost(modifier: Modifier = Modifier, navHostController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.HomeDestination,
    ) {
        composable<Screen.HomeDestination> {
            Home(navController = navHostController)
        }
        composable<Screen.GettingStartedDestination> {
            GettingStarted(navController = navHostController)
        }

        composable<Screen.MySQLTutorialForDevelopersDestination> {
            MySqlForDevelopers(navController = navHostController)
        }
    }
}


sealed interface Screen{
    @Serializable
    data object HomeDestination :Screen

    @Serializable
    data object GettingStartedDestination:Screen

    @Serializable
    data object MySQLTutorialForDevelopersDestination:Screen
}