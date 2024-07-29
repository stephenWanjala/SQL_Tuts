@file:OptIn(ExperimentalMaterial3Api::class)

package com.stephenwanjala.sqltuts.home.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stephenwanjala.sqltuts.home.presentation.components.ListingGrid

@Composable
fun Home(navController: NavHostController) {
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {

                        Text(
                            text = "SQL Tutorials",
                            style = MaterialTheme.typography.titleMedium,
                        )
                    },
                    scrollBehavior = scrollBehaviour,
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Drawer Menu"
                            )
                        }
                    }
                )
            },
        ) { innerPadding ->
            val gridState = rememberLazyStaggeredGridState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehaviour.nestedScrollConnection)
                    .padding(innerPadding)
            ) {
//               show introduction composable only if the grid hasn't been scrolled or is scrolling back to the top
                val showIntro = remember { mutableStateOf(true) }
                LaunchedEffect(gridState) {
                    showIntro.value = gridState.firstVisibleItemIndex == 0
                }
                AnimatedVisibility(visible = showIntro.value) {
                    Introduction()
                }

                ListingGrid(
                    navController = navController,
                    listState = gridState
                )

            }


        }

    }

}