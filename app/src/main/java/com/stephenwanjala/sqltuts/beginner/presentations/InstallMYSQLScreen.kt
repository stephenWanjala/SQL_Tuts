package com.stephenwanjala.sqltuts.beginner.presentations

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.stephenwanjala.sqltuts.R

@ExperimentalMaterial3Api
@Composable
fun InstallMYSQLScreen(navHostController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        val context = LocalContext.current
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Installing MYSQL")
                    },
                    navigationIcon = {
                        IconButton(onClick = navHostController::navigateUp) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Mic, contentDescription = "ReadAloud")
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { paddingValues: PaddingValues ->

            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                contentPadding = paddingValues
            ) {

                item {
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<strong>Summary</strong>: in this tutorial, you will learn how to install MySQL server and its related products on Windows using the MySQL Installer.</p><p>After the tutorial, you will have a MySQL server and its tools up and running on your system for learning and practicing.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )
                }
                item {
                    val annotatedString = buildAnnotatedString {
                        append("Note that for other operating systems like Linux and Ubuntu, refer to the following tutorials:\n\n")
                        append("• ")
                        pushStringAnnotation(
                            tag = "URL",
                            annotation = "https://www.mysqltutorial.org/getting-started-with-mysql/install-mysql-centos/"
                        )
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 16.sp
                            )
                        ) {
                            append("Install MySQL 8 on CentOS 7")
                        }
                        pop()
                        append("\n• ")
                        pushStringAnnotation(
                            tag = "URL",
                            annotation = "https://www.mysqltutorial.org/getting-started-with-mysql/install-mysql-ubuntu/"
                        )
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 16.sp
                            )
                        ) {
                            append("Install MySQL 8 on Ubuntu")
                        }
                        pop()
                        append("\n\nDownload MySQL Installer\n\n")
                        append("If you want to install MySQL on Windows, you can use the MySQL Installer. The MySQL Installer provides you with an easy-to-use wizard that helps you to install MySQL with the following main products:\n\n")
                        append("• MySQL Server\n")
                        append("• MySQL Workbench\n")
                        append("• MySQL Shell\n")
                        append("• MySQL Documentation\n")
                        append("• All Available Connectors\n\n")
                        append("To download the MySQL installer, go to the following link:\n")
                        pushStringAnnotation(
                            tag = "URL",
                            annotation = "http://dev.mysql.com/downloads/installer/"
                        )
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 16.sp
                            )
                        ) {
                            append("http://dev.mysql.com/downloads/installer/")
                        }
                        pop()
                    }

                    ClickableText(
                        text = annotatedString,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Justify
                        ),
                        onClick = { offset ->
                            annotatedString.getStringAnnotations(
                                tag = "URL",
                                start = offset,
                                end = offset
                            )
                                .firstOrNull()?.let { annotation ->
                                    val intent =
                                        Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                                    context.startActivity(intent)
                                }
                        }
                    )

                }

                item {
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<p>We’ll use the MySQL Installer 8.0.34 to install the MySQL Server and related products such as MySQL Workbench and MySQL Shell.</p><strong><p class=\\\"wp-block-heading\\\">Install MySQL Server &amp; related products using MySQL Installer</p></strong><p>To install MySQL using the MySQL installer, double-click on the MySQL Installer file and follow the steps below:</p><strong><br>Step 1:&nbsp;Choosing a setup type </strong></h3><p>In this step, you need to choose the setup type that suits your use case. For tutorial purposes, you can select the last option which is <strong>Custom</strong> setup type:"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_step_1, contentDescription = "Step 1",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(8.dp),
                        alignment = Alignment.Center,
                    )
                }


            }
        }
    }

}


fun onClickExternalUrl(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PrevInstallingMysql() {
    InstallMYSQLScreen(navHostController = rememberNavController())
}