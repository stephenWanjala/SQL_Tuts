package com.stephenwanjala.sqltuts.home.presentation.components

import android.app.UiModeManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stephenwanjala.sqltuts.R
import com.stephenwanjala.sqltuts.home.HomeSectionItem

@Composable
fun HomeItem(
    modifier: Modifier = Modifier,
    homeSectionItem: HomeSectionItem,
    onItemClick: (HomeSectionItem) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(homeSectionItem) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = homeSectionItem.resId),
            contentDescription = homeSectionItem.tittle,
            modifier = Modifier
                .padding(4.dp)
                .size(80.dp)
                .aspectRatio(50 / 50f)
//                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = homeSectionItem.tittle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(text = homeSectionItem.body, style = MaterialTheme.typography.bodyMedium)
        }

    }

}


@Preview(showBackground = true, showSystemUi = true, uiMode = UiModeManager.MODE_NIGHT_AUTO)
@Composable
private fun HomeItemPrev() {
    HomeItem(
        homeSectionItem = HomeSectionItem(
            resId = R.drawable.mysql_getting_started,
            tittle = " Getting Started with MySQL",
            body = "This section helps you get started with the MySQL quickly if you have never worked with MySQL before."
        )
    ) {

    }
}