package com.stephenwanjala.sqltuts.beginner.presentations

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
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
                            "<p>We’ll use the MySQL Installer 8.0.34 to install the MySQL Server and related products such as MySQL Workbench and MySQL Shell.</p><br\\><strong><p class=\\\"wp-block-heading\\\">Install MySQL Server &amp; related products using MySQL Installer</p></strong><p>To install MySQL using the MySQL installer, double-click on the MySQL Installer file and follow the steps below:</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_step_1, contentDescription = "Step 1",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                        alignment = Alignment.Center,
                    )
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<strong><br>Step 1:&nbsp;Choosing a setup type </strong></h3><p>In this step, you need to choose the setup type that suits your use case. For tutorial purposes, you can select the last option which is <strong>Custom</strong> setup type:</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_1, contentDescription = "Step 1",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                        alignment = Alignment.Center,
                    )
                }
                item {
                    val annotatedString = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 16.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )
                        ) {
                            append("Step 2. Selecting products ")

                        }

                        append("Since we chose the")
                        withStyle(
                            style = SpanStyle(
                                fontSize = 16.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )
                        ) {
                            append(" Custom ")
                        }
                        append("setup type, the MySQL Installer displays available products for us to select to install.\n\n")
                        append("We’ll install the following products:\n\n")
                        append("• MySQL Server – This is the MySQL Database Server.\n")
                        append("• MySQL Workbench – This is the client tool for interacting with the MySQL Database Server via GUI.\n")
                        append("• MySQL Shell – This is an interactive Javascript, Python, or SQL interface supporting development and administration for the MySQL Server.\n\n")
                        append("To select these products, you click the + icon on the left pane, select the product, and click the right arrow button.\n\n")
                        append("Here are the paths to the selected products:\n\n")
                        append("• MySQL Servers > MySQL Server > MySQL Server 8.0 > MySQL Server 8.0.34 – x64\n")
                        append("• Applications > MySQL Workbench > MySQL Workbench 8.0 > MySQL Workbench 8.0.34 – X64\n")
                        append("• Applications > MySQL Shell > MySQL Shell 8.0 > MySQL Shell 8.0.34 – X64\n\n")
                        append("Once you select the products, you click the")
                        withStyle(
                            style = SpanStyle(
                                fontSize = 16.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )
                        ) {
                            append(" Next ")
                        }
                        append("button to continue.")

                    }
                    Text(
                        text = annotatedString,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Justify
                        ),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_2, contentDescription = "Step 2",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                        alignment = Alignment.Center,
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h3 class=\"wp-block-heading\">Step 3. Downloading the selected products</h3><p>The MySQL Installer will download the selected products from the internet. Please ensure you have an active internet connection and wait for a few minutes for the download to complete.</p>"
                        )
                    )
                    AsyncImage(
                        model = R.drawable.install_msql_8_step_3,
                        contentDescription = "step 3",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_4,
                        contentDescription = "step 4",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                    )
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<p>After the download is complete, click the <strong>Execute</strong> button to start the installation.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_5,
                        contentDescription = "step 5",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                    )
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h5 class=\"wp-block-heading\">Step 4. Installing the selected products</h5><p>The MySQL Installer will install the selected products and this process may some time.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )
                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_6,
                        contentDescription = "step 6",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                    )
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<p>After the installation is complete, click the Next button to proceed to the Product Configuration.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_7,
                        contentDescription = "step 7",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h3 class=\"wp-block-heading\">Step 5. Configuring the MySQL Server</h3>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )
                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_8,
                        contentDescription = "Step 8",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                    )
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<p>In this step, configure the MySQL Server. Choose the <strong>Development Computer</strong> for the server configuration type, leave the other options as they are, and click the <strong>Next</strong> button.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_9,
                        contentDescription = "Step 9",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h5 class=\"wp-block-heading\">Step 6. Choosing an authentication method</h5><p>It’s recommended to use strong password encryption for authentication, which is the first option.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_10,
                        contentDescription = "Step 10 image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp),
                    )

                    val anAnnotatedString = buildAnnotatedString {
                        append("Step 7. Entering a password for the root account\n\n")
                        append("Enter a secure password for the root account, which has full administrative privileges.\n\n")
                        append("Be sure to store it safely and use it for ")
                        pushStringAnnotation(
                            tag = "URL",
                            annotation = "https://www.mysqltutorial.org/getting-started-with-mysql/connect-to-mysql-server/"
                        )
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 16.sp
                            )
                        ) {
                            append("connecting to the MySQL Server")
                        }
                        pop()
                        append(" in the future.")
                    }
                    ClickableText(
                        text = anAnnotatedString,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Justify
                        ),
                        onClick = { offset ->
                            anAnnotatedString.getStringAnnotations(
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

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_11,
                        contentDescription = "Step 11 Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp)
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h5 class=\"wp-block-heading\">Step 8. Configuring MySQL Server as a Windows Service</h5><p>In this step, you can configure the MySQL Server as a Windows service, specify a service name, and choose whether to start the MySQL Server during the operating system startup.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_12,
                        contentDescription = "Step 12 Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp)
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h3 class=\"wp-block-heading\">Step 9. Granting file permissions</h3><p>In this step, you grant permission to MySQL to access the data directory.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_13,
                        contentDescription = "step 13 Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp)
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h3 class=\"wp-block-heading\">Step 10. Displaying the selected configuration</h3><p>The MySQL Installer displays a window with the configuration steps. Click the <strong>Execute</strong> button to apply the configuration.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_14,
                        contentDescription = "Step 14 Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp)
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h5>Step 11.Completing configuration<br\\></h5><p>After applying the configuration, the MySQL Installer displays the following window to indicate whether the MySQL Server has been configured successfully.</p>"
                        ), modifier = Modifier.padding(8.dp), textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_15,
                        contentDescription = "Step 15 Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp)
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<p>After completing the configuration, click the <strong>Next</strong> button to confirm and finish.</p>"
                        ), modifier = Modifier.padding(8.dp), textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_16,
                        contentDescription = "Step 16 Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = AnnotatedString.fromHtml(
                            "<h3 class=\"wp-block-heading\">Step 12. Completing installation</h3><p>The MySQL Installer displays a window to notify you that the installation is complete. Click the <strong>Finish</strong> button to close the installer.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )

                    AsyncImage(
                        model = R.drawable.install_mysql_8_step_17,
                        contentDescription = "Step 17 Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(8.dp)
                    )

                    Text(
                        text = AnnotatedString.fromHtml(
                            "<p>In this tutorial, you have learned how to install MySQL on your Windows using the MySQL installer.</p>"
                        ),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )


                }

                item {

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