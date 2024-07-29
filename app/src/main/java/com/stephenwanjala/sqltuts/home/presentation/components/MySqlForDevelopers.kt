package com.stephenwanjala.sqltuts.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stephenwanjala.sqltuts.home.HomeSectionItem
import com.stephenwanjala.sqltuts.home.data.HomeItemsData
import com.stephenwanjala.sqltuts.home.presentation.Introduction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySqlForDevelopers(navController: NavController) {
    val scrollBehavior =TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold (modifier = Modifier.fillMaxSize(),
        topBar = {
           TopAppBar(title = {

                Text(
                    text = "MySQL Tutorial for Developers",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            },
                navigationIcon = {
                    IconButton(onClick = navController::navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                            contentDescription = "Back"
                        )
                    }
                },
                scrollBehavior = scrollBehavior)
        }){paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
            , verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(minSize = 480.dp),
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                item {

                    Text(
                        text = "Are you a developer looking to learn MySQL fast? After completing this section, you’ll know how to work with MySQL more effectively as a developer. You’ll learn various techniques to manipulate database objects and interact with the data.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                items(items=HomeItemsData.homeSectionItems) { item: HomeSectionItem ->
                    HomeItem(homeSectionItem = item, onItemClick = {
                        item.route?.let { route->
                            navController.navigate(route)
                        }
                    })
                }
            }
        }
    }

}