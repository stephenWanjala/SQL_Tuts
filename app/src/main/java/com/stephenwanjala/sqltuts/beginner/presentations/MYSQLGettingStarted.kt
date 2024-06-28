package com.stephenwanjala.sqltuts.beginner.presentations

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowColumnOverflow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.stephenwanjala.sqltuts.beginner.data.GettingStartedData
import com.stephenwanjala.sqltuts.beginner.data.MySQLIntroData
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
                        FlowColumn(
                            horizontalArrangement = Arrangement.Center,
                            verticalArrangement = Arrangement.Center,
                            overflow = FlowColumnOverflow.Visible
                        ) {
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
                            Spacer(modifier = Modifier.heightIn(8.dp))
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
                    expandedHeight = 150.dp
                )
            }
        ) { innerPadding ->
            LazyColumn(
                Modifier
                    .padding(paddingValues = innerPadding)
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
            ) {
                item {
                    Text(
                        text = "This section helps you get started with MySQL quickly if you have never worked with MySQL before.",
                        modifier = Modifier.padding(8.dp),
//                        textAlign = TextAlign.Center
                    )
                }
                items(GettingStartedData.introData) { item ->
                    IntroItem(item, onClickItem = {})

                }
            }
        }
    }
}

@Composable
fun IntroItem(mySQLIntroData: MySQLIntroData, onClickItem: (MySQLIntroData) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        onClick = { onClickItem(mySQLIntroData) }) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = mySQLIntroData.title, style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = mySQLIntroData.body)
        }
    }
}

fun Modifier.collapsed(toolBarHeight: Dp, collapsedHeight: Dp): Modifier = composed {
    return@composed if (toolBarHeight <= collapsedHeight) {
        this
            .size(20.dp)
            .aspectRatio(1f)
            .clip(CircleShape)
    } else this
}

fun Int.toDp(): Dp {
    return (this / Resources.getSystem().displayMetrics.density).dp
}
