package com.stephenwanjala.sqltuts

import androidx.annotation.DrawableRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.stephenwanjala.sqltuts.beginner.IntroToMysqlScreen
import com.stephenwanjala.sqltuts.beginner.presentations.InstallMYSQLScreen
import com.stephenwanjala.sqltuts.beginner.presentations.MYSQLBasics
import com.stephenwanjala.sqltuts.beginner.presentations.MYSQLGettingStarted
import com.stephenwanjala.sqltuts.beginner.presentations.MYSQLSelectFrom
import com.stephenwanjala.sqltuts.home.HomeSectionItem
import com.stephenwanjala.sqltuts.home.presentation.Home
import com.stephenwanjala.sqltuts.home.presentation.components.GettingStarted
import com.stephenwanjala.sqltuts.home.presentation.components.MySqlForDevelopers
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class)
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

        composable<Screen.MyQSLGettingStartedDestination> { backStackEntry ->
//            val homeSectionItem: HomeSectionItem
            val (resId,tittle,body) =backStackEntry.toRoute<Screen.MyQSLGettingStartedDestination>()
            MYSQLGettingStarted(
                navController = navHostController,
                homeSectionItem = HomeSectionItem(resId,tittle,body)
            )
        }

        composable<Screen.Intro2MYSQL> {
            IntroToMysqlScreen(navHostController = navHostController)
        }
        composable<Screen.InstallingMYSQL>{
            InstallMYSQLScreen(navHostController = navHostController)
        }

        composable< Screen.MYSQLBasicsScreen>{
            MYSQLBasics(navHostController=navHostController)
        }

        composable<Screen.MySQSelectFromScreen>{
            MYSQLSelectFrom(navHostController = navHostController)
        }
    }
}


sealed interface Screen {
    @Serializable
    data object HomeDestination : Screen

    @Serializable
    data object GettingStartedDestination : Screen

    @Serializable
    data object MySQLTutorialForDevelopersDestination : Screen

    @Serializable
    data class MyQSLGettingStartedDestination(
        @DrawableRes val resId: Int,
        val tittle: String,
        val body: String
    ) : Screen
    @Serializable
    data object Intro2MYSQL:Screen

    @Serializable
    data object InstallingMYSQL:Screen

    @Serializable
    data object ConnectToServer:Screen

    @Serializable
    data object DownLoadDataSample:Screen

    @Serializable
    data object LoadSampleData:Screen
    @Serializable
    data object  MYSQLBasicsScreen:Screen

    @Serializable
    data object MySQSelectFromScreen:Screen

   companion object{
       fun createScreenFromString(screenName: String): Screen?{
           return when(screenName){
               "MySQSelectFromScreen" -> MySQSelectFromScreen
               else -> {null}
           }
       }
   }
}