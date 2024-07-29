@file:OptIn(ExperimentalMaterial3Api::class)

package com.stephenwanjala.sqltuts.beginner.presentations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stephenwanjala.sqltuts.presentation.components.SqlCodeBlock

@Composable
fun MYSQLSelectFrom(navHostController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "MYSQL Select From")
                    },
                    scrollBehavior = scrollBehavior,
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
                    navigationIcon = {
                        IconButton(onClick = navHostController::navigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                                contentDescription = "back"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
                    .padding(8.dp)
            ) {
                item {
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<strong>Summary</strong>: in this tutorial, you will learn how to use the basic form of the MySQL <code>SELECT FROM</code> statement to query data from a table.</p> <br\\><strong>Introduction to MySQL `SELECT FROM` </strong> <br\\><p>The <code>SELECT</code> statement allows you to select data from one or more tables. To write a <code>SELECT</code> statement in MySQL, you use this syntax:</p>"
                        ),
                        textAlign = TextAlign.Justify,
                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onBackground)
                    )
                }

                item {
                    SqlCodeBlock(
                        code = """
                        SELECT select_list
                        FROM table_name;
                    """.trimIndent()
                    )
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        Text(
                            "In this syntax:",
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        BulletPoint(
                            "First, specify one or more columns from which you want to select data after the ",
                            "SELECT",
                            " keyword. If the ",
                            "select_list",
                            " has multiple columns, you need to separate them by a comma ( ",
                            ",",
                            " )."
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        BulletPoint(
                            "Second, specify the name of the table from which you want to select data after the ",
                            "FROM",
                            " keyword."
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            "The semicolon ( ; ) is optional, which denotes the end of a statement. If you have two or more statements, you need to use the semicolon( ; ) to separate them so that MySQL will execute each statement individually.",
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            buildAnnotatedString {
                                append("The ")
                                withStyle(style = SpanStyle(background = MaterialTheme.colorScheme.inversePrimary)) {
                                    append("SELECT")
                                }
                                append(" and ")
                                withStyle(style = SpanStyle(background = MaterialTheme.colorScheme.inversePrimary)) {
                                    append("FROM")
                                }
                                append(" are the keywords. By convention, you write the SQL keywords in uppercase. However, it's not mandatory. Because SQL is case-insensitive, you can write the SQL statement in lowercase, uppercase, etc. For example:")
                            },
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
        }

    }
}


@Composable
fun BulletPoint(vararg texts: String) {
    Row(
        modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
    ) {
        Text("•", color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.padding(end = 8.dp))
        Text(
            buildAnnotatedString {
                texts.forEachIndexed { index, text ->
                    if (index % 2 == 0) {
                        append(text)
                    } else {
                        withStyle(style = SpanStyle(background = MaterialTheme.colorScheme.inversePrimary)) {
                            append(text)
                        }
                    }
                }
            },
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}