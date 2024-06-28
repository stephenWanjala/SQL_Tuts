package com.stephenwanjala.sqltuts.beginner.presentations

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stephenwanjala.sqltuts.home.HomeSectionItem

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MYSQLGettingStarted(navController: NavHostController, homeSectionItem: HomeSectionItem) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val toolbarSize = remember { mutableStateOf(IntSize.Zero) }
    val collapsedHeight = TopAppBarDefaults.MediumAppBarCollapsedHeight

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
                        toolbarSize.value = layoutCoordinates.size
                    },
                    title = {
                        FlowColumn (
                            horizontalArrangement = Arrangement.Center,
                            verticalArrangement = Arrangement.Center,
                            overflow = FlowColumnOverflow.Visible
                        ){
                            Image(
                                painter = painterResource(id = homeSectionItem.resId),
                                contentDescription = homeSectionItem.tittle,
                                modifier = Modifier
                                    .size(80.dp)
                                    .collapsed(
                                        toolBarHeight = with(LocalDensity.current) { toolbarSize.value.height.toDp() },
                                        collapsedHeight = collapsedHeight
                                    )
                            )
                            Spacer(modifier = Modifier.heightIn(6.dp))
                            Text(
                                text = "Getting Started with MySQL",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                    navigationIcon = {
                        IconButton(onClick = navController::navigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                                contentDescription = "Back"
                            )
                        }
                    },
                    expandedHeight =200.dp
                )
            }
        ) { innerPadding ->
            LazyColumn(
                Modifier
                    .padding(paddingValues = innerPadding)
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
            ) {
                items(100) {

                }
            }
        }
    }
}

fun Modifier.collapsed(toolBarHeight: Dp, collapsedHeight: Dp): Modifier = composed {
    return@composed if (toolBarHeight <= collapsedHeight) {
        this.clip(CircleShape)
            .size(40.dp)
    } else this
}

fun Int.toDp(): Dp {
    return (this / Resources.getSystem().displayMetrics.density).dp
}
