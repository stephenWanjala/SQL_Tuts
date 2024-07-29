package com.stephenwanjala.sqltuts.presentation.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stephenwanjala.sqltuts.utils.highlightSQLSyntax

@Composable
fun CodeBlock(code: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF2D2D2D)) // Background color for the code block
            .padding(16.dp)
    ) {
        Text(
            text = code,
            color = Color(0xFFE6E6E6), // Text color for the code block
            fontFamily = FontFamily.Monospace, // Monospace font for code
            fontSize = 14.sp // Font size
        )
    }
}


@Composable
fun SqlCodeBlock(
    code: String,
    modifier: Modifier = Modifier,
    customHighlight: Boolean = true
) {
    val clipboardManager: androidx.compose.ui.platform.ClipboardManager =
        LocalClipboardManager.current
    val context = LocalContext.current
    val isDark = isSystemInDarkTheme()
    val color = if (isDark) Color(0xFF2E7D32) else Color(0xFF2E7D32)
    val bgColor = if (isDark) Color(0x75CFC0D2) else Color(0xfeFFFFFF)

    Surface(
        shape = MaterialTheme.shapes.medium,
//        shadowElevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(8.dp)
        ) {
            SelectionContainer {
                if (customHighlight) {

                    Text(
                        text = highlightSQLSyntax(code = code),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 14.sp,
                            color = Color.Unspecified, // SQL keyword color
                        ),
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .background(bgColor)
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                } else {
                    Text(
                        text = code,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 14.sp,
                            color = color, // SQL keyword color
                        ),
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .background(bgColor)
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }

            }
            IconButton(
                onClick = {
                    clipboardManager.setText(AnnotatedString(code))
                    Toast.makeText(context, "Code copied to clipboard", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = "Copy to clipboard",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CodeBlockPreview() {
    MaterialTheme {
        SqlCodeBlock(
            code =
            """
            SELECT select_list
            FROM coo where id = 1 and user_name = 'Stephen';
        """.trimIndent(),
            customHighlight = true
        )
    }
}
