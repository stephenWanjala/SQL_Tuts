package com.stephenwanjala.sqltuts.beginner

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stephenwanjala.sqltuts.ui.theme.SQLTutsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroToMysqlScreen(navHostController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "What is MYSQl")
                    },
                    navigationIcon = {
                        IconButton(onClick = navHostController::navigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                                contentDescription = "Back"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Mic, contentDescription = "ReadAloud")
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                        }
                    }
                )
            }) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                contentPadding = paddingValues
            ) {
                item {
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<strong>Summary</strong>: What is MySQL? <br\\>This tutorial will provide you with answers and reasons why MySQL is one of the world’s most popular open-source databases.</p><h2 class=\"wp-block-heading\"><br\\><strong>Introduction to databases</strong></h2><p> <br\\>You interact with data every day…</p><p>When you want to listen to your favorite songs, you open your playlist from your smartphone. In this case, the playlist is essentially a database.</p><p>When you take a photo and upload it to your account on a social network like Facebook, your photo gallery becomes a database.</p><p>When you browse an e-commerce website to buy shoes, clothes, and more, you’re using the shopping cart database.</p><p>Databases are everywhere. So what is a database?&nbsp; By definition, a database is simply a structured collection of data.</p><p>The data within a database are naturally related, for example, a product belongs<strong> </strong>to a product category and is<strong> </strong>associated with multiple tags. Hence,  we use the term <strong>relational database</strong>.</p><p>In a relational database, we model data like products, categories, tags, etc., using tables.<br\\> <br\\> A table contains columns and rows, much like a spreadsheet.</p><p>Tables can relate to one another table using various types of relationships, like one-to-one and one-to-many.</p><p>Because we handle a substantial amount of data, we need a way to efficiently define databases, tables, and process data. Moreover, we want to transform data into valuable information.</p><p>This is where SQL comes into play.</p>",
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )
                }

                item {
                    Citation(text = "ANSI/SQL defines the SQL standard and the current version of SQL is SQL:2023. When we refer to the SQL standard, we are talking about the current SQL version.")
                }

                item {
                    ClickableAnnotatedText { clickedText ->
                        when (clickedText) {
                            "views" -> {
                                // Handle click on views
                            }
                            "triggers" -> {
                                // Handle click on triggers
                            }
                            "stored procedures" -> {
                                // Handle click on stored procedures
                            }
                            "updating" -> {

                            }
                            "querying data" -> {
                                // Handle click on  querying data
                            }
                            "grant permissions" -> {
                                // Handle click on grant permissions
                            }
                        }
                    }
                }
            }

        }
    }

}


@Composable
fun Citation(
    text: String,
    modifier: Modifier = Modifier,
    lineColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    padding: PaddingValues = PaddingValues(16.dp),
    textColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    outlineColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, outlineColor, RoundedCornerShape(10.dp))
            .background(color = backgroundColor, shape = RoundedCornerShape(10.dp))
            .padding(padding)

    ) {
        Spacer(
            modifier = Modifier
                .width(4.dp)
                .height(100.dp)
                .background(color = lineColor, shape = RoundedCornerShape(2.dp))
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            BasicText(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = textColor,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}



@Composable
fun ClickableAnnotatedText(
    onClick: (String) -> Unit
) {
    val annotatedString = buildAnnotatedString {
        append("SQL is composed of three parts:\n\n")

        append("Data definition language (DDL) includes statements for defining the database and its objects such as ")
        pushStringAnnotation(tag = "TAG", annotation = "views")
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
            append("views")
        }
        pop()

        append(", ")

        pushStringAnnotation(tag = "TAG", annotation = "triggers")
        withStyle(style = SpanStyle(color = Color.Green, textDecoration = TextDecoration.Underline)) {
            append("triggers")
        }
        pop()

        append(", ")

        pushStringAnnotation(tag = "TAG", annotation = "stored procedures")
        withStyle(style = SpanStyle(color = Color.Red, textDecoration = TextDecoration.Underline)) {
            append("stored procedures")
        }
        pop()

        append(", etc.\nData manipulation language (DML) contains statements for ")

        pushStringAnnotation(tag = "TAG", annotation = "updating")
        withStyle(style = SpanStyle(color = Color.Magenta, textDecoration = TextDecoration.Underline)) {
            append("updating")
        }
        pop()
        append(" and ")
        pushStringAnnotation(tag = "TAG", annotation = " querying data")
        withStyle(style = SpanStyle(color = Color.Magenta, textDecoration = TextDecoration.Underline)) {
            append("querying data")
        }
        pop()

        append(".\nData control language (DCL) allows you to ")

        pushStringAnnotation(tag = "TAG", annotation = "grant permissions")
        withStyle(style = SpanStyle(color = Color.Cyan, textDecoration = TextDecoration.Underline)) {
            append("grant permissions")
        }
        pop()

        append(" to users to access specific data in the database.")
    }
    val baseTextStyle =MaterialTheme.typography.bodyLarge
        .copy(color = MaterialTheme.colorScheme.onSurface)

   MaterialTheme{
       ClickableText(
           text = annotatedString,
           onClick = { offset ->
               annotatedString.getStringAnnotations(tag = "TAG", start = offset, end = offset)
                   .firstOrNull()?.let { annotation ->
                       onClick(annotation.item)
                   }
           },
           modifier = Modifier.padding(16.dp),
           style = baseTextStyle
       )
   }
}

@Composable
fun MyScreen() {
   SQLTutsTheme {
       Column {
           ClickableAnnotatedText { clickedText ->
               when (clickedText) {
                   "views" -> {
                       // Handle click on views
                   }
                   "triggers" -> {
                       // Handle click on triggers
                   }
                   "stored procedures" -> {
                       // Handle click on stored procedures
                   }
                   "updating and querying data" -> {
                       // Handle click on updating and querying data
                   }
                   "grant permissions" -> {
                       // Handle click on grant permissions
                   }
               }
           }
       }
   }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true
)
@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true
)
@Composable
fun PreviewMyScreen() {
        MyScreen()

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CitationPreview() {
    Surface {
        Citation(
            text = "Showcasing my skills, projects, and experiences."
        )
    }
}