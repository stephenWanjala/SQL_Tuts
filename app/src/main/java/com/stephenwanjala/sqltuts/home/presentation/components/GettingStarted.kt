package com.stephenwanjala.sqltuts.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stephenwanjala.sqltuts.R
import com.stephenwanjala.sqltuts.Screen
import com.stephenwanjala.sqltuts.home.HomeSectionItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GettingStarted(navController: NavController) {
    val scrollBehaviour = TopAppBarDefaults.pinnedScrollBehavior()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Getting Started",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = navController::navigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                                contentDescription = "Navigate Back"
                            )
                        }
                    }, scrollBehavior = scrollBehaviour
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .nestedScroll(scrollBehaviour.nestedScrollConnection)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    item {
                        Text(
                            text = "In this section, you’ll get started with MySQL by following five easy steps. After completing the getting started section, you’ll have a local MySQL database on your computer with a sample database to practice.",
                            style = MaterialTheme.typography.bodyMedium
                        )

                    }

                    item {
                        val homeSectionItem = HomeSectionItem(
                            resId = R.drawable.mysql_getting_started,
                            tittle = " Getting Started with MySQL",
                            body = "This section helps you get started with the MySQL quickly if you have never worked with MySQL before.",

                            )
                        HomeItem(
                            homeSectionItem = homeSectionItem,
                            onItemClick = {
                                navController.navigate(Screen.MyQSLGettingStartedDestination(resId = it.resId, tittle = it.tittle, body = it.body))
                            })
                    }


                }
            }

        }
    }
}