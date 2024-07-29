@file:OptIn(ExperimentalMaterial3Api::class)

package com.stephenwanjala.sqltuts.beginner.presentations

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stephenwanjala.sqltuts.Screen

@Composable
fun MYSQLBasics(navHostController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val context = LocalContext.current

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "MYSQL Basics") },
                    navigationIcon = {
                        IconButton(onClick = navHostController::navigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Mic, contentDescription = "Read Aloud")
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { paddingValues ->
            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
                    .padding(8.dp)
            ) {
                item {
                    Text(
                        text = "This MySQL basics section teaches you how to use SQL statements to manage data in MySQL. It’ll provide you with everything you need to know to work with MySQL effectively.",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }

                item {
                    // Title
                    Text(
                        text = "Section 1. Querying data",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    // List items with clickable links
                    val annotatedText=buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("• ")
                        }
                        pushStringAnnotation(tag = "URL", annotation = "MySQSelectFromScreen")
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                            append("SELECT FROM ")
                        }
                        pop()
                        append(" – show you how to use a simple ")
                        withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                            append("SELECT FROM")
                        }
                        append(" statement to query the data from a single table.\n\n")

                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("• ")
                        }
                        pushStringAnnotation(tag = "URL", annotation = "https://www.mysqltutorial.org/mysql-basics/mysql-select/")
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                            append("SELECT")
                        }
                        pop()
                        append(" – learn how to use the SELECT statement without referencing a table.")}
                    ClickableText(
                        text = annotatedText,
                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onBackground),
                        onClick = { offset ->

                            val annotations = annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                            annotations.firstOrNull()?.let { annotation ->
                                val screen= Screen.createScreenFromString(annotation.item)
                                screen?.let { route->
                                    navHostController.navigate(route)
                                }
//                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
//                                context.startActivity(intent)
                            }
                        }
                    )
                }
            }
        }
    }
}