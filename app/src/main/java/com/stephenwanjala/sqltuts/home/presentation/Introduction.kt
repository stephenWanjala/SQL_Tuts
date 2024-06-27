package com.stephenwanjala.sqltuts.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Introduction(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = AnnotatedString.fromHtml("<p>Welcome to the <strong>MySQL Tutorials</strong> , your go-to resource for mastering MySQL in a fast, easy, and enjoyable way.</p><p>Whether you’re a developer or a database enthusiast, our tutorials are designed to make learning MySQL a breeze.</p><p>Our tutorials are packed with clear explanations and practical examples to help you find everything you need to become proficient in MySQL.</p>"))
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun IntroPreview() {
    Introduction()
}