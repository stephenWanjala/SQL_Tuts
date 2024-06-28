package com.stephenwanjala.sqltuts.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stephenwanjala.sqltuts.Screen

@Composable
fun ListingGrid(modifier: Modifier = Modifier, navController: NavController) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2), modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        val listingGridItems: List<ListingGridItem> = listOf(
            ListingGridItem(
                tittle = "Getting Started",
                description = "In this section, you’ll get started with MySQL by following five easy steps. After completing the getting started section, you’ll have a local MySQL database on your computer with a sample database to practice.",
                route = Screen.GettingStartedDestination
            ),
            ListingGridItem(
                tittle = "MySQL Tutorial for Developers",
                description = "Are you a developer looking to learn MySQL fast? After completing this section, you’ll know how to work with MySQL more effectively as a developer. You’ll learn various techniques to manipulate database objects and interact with the data.",
                route = Screen.MySQLTutorialForDevelopersDestination
            )
        )
        items(listingGridItems) { item ->
            GridItem(gridItem = item, onItemClick = {
                navController.navigate(item.route) {
                    popUpTo(item.route) {
                        inclusive = true
                    }
                }
            })
        }

    }
}

@Composable
fun GridItem(
    gridItem: ListingGridItem,
    modifier: Modifier = Modifier,
    onItemClick: (ListingGridItem) -> Unit
) {
    ElevatedCard(
        modifier = modifier
            .heightIn(150.dp, 200.dp)
            .clip(RoundedCornerShape(8.dp))
            .padding(8.dp),
        onClick = { onItemClick(gridItem) },
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = gridItem.tittle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = gridItem.description,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


data class ListingGridItem(
    val route: Screen,
    val tittle: String,
    val description: String
)