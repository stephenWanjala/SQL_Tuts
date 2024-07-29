package com.stephenwanjala.sqltuts.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import java.util.Locale


fun highlightSQLSyntax(code: String): AnnotatedString {
    val dmlKeywords =
        listOf("SELECT", "INSERT", "UPDATE", "DELETE", "MERGE", "CALL", "EXPLAIN", "LOCK")
    val ddlKeywords = listOf("CREATE", "ALTER", "DROP", "TRUNCATE", "RENAME")
    val dclKeywords = listOf("GRANT", "REVOKE", "DENY")
    val transactionKeywords = listOf("COMMIT", "ROLLBACK", "SAVEPOINT", "SET TRANSACTION")
    val clauses = listOf(
        "FROM",
        "WHERE",
        "GROUP BY",
        "HAVING",
        "ORDER BY",
        "LIMIT",
        "OFFSET",
        "JOIN",
        "UNION",
        "INTERSECT",
        "EXCEPT"
    )
    val dataTypes = listOf(
        "INT",
        "VARCHAR",
        "CHAR",
        "DATE",
        "DATETIME",
        "DECIMAL",
        "FLOAT",
        "DOUBLE",
        "BOOLEAN",
        "BLOB",
        "TEXT"
    )
    val functions = listOf(
        "COUNT",
        "SUM",
        "AVG",
        "MAX",
        "MIN",
        "COALESCE",
        "IFNULL",
        "CASE",
        "WHEN",
        "THEN",
        "ELSE",
        "END"
    )
    val operators =
        listOf("AND", "OR", "NOT", "IN", "BETWEEN", "LIKE", "IS NULL", "IS NOT NULL", "EXISTS")
    val tableConstraints = listOf("PRIMARY KEY", "FOREIGN KEY", "UNIQUE", "CHECK", "DEFAULT")
    val otherKeywords =
        listOf("AS", "DISTINCT", "ALL", "ANY", "SOME", "INTO", "VALUES", "SET", "ON", "USING")

    return buildAnnotatedString {
        val tokens = code.split(Regex("\\s+"))

        tokens.forEach { token ->
            val upperToken = token.uppercase(Locale.ROOT)
            when {
                dmlKeywords.contains(upperToken) -> withStyle(
                    style = SpanStyle(
                        color = Color(
                            0xF20000FF
                        ), fontWeight = FontWeight.Bold
                    )
                ) { append("$token ") }

                ddlKeywords.contains(upperToken) -> withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontWeight = FontWeight.Bold
                    )
                ) { append("$token ") }

                dclKeywords.contains(upperToken) -> withStyle(
                    style = SpanStyle(
                        color = Color(
                            0xFF800080
                        ), fontWeight = FontWeight.Bold
                    )
                ) { append("$token ") }

                transactionKeywords.contains(upperToken) -> withStyle(
                    style = SpanStyle(
                        color = Color(
                            0x636F4B0B
                        ), fontWeight = FontWeight.Bold
                    )
                ) { append("$token ") }

                clauses.contains(upperToken) -> withStyle(style = SpanStyle(color = Color.Cyan)) {
                    append(
                        "$token "
                    )
                }

                dataTypes.contains(upperToken) -> withStyle(style = SpanStyle(color = Color.Red)) {
                    append(
                        "$token "
                    )
                }

                functions.contains(upperToken) -> withStyle(style = SpanStyle(color = Color.Magenta)) {
                    append(
                        "$token "
                    )
                }

                operators.contains(upperToken) -> withStyle(
                    style = SpanStyle(
                        color = Color(
                            0xA6FFFF00
                        )
                    )
                ) { append("$token ") }

                tableConstraints.contains(upperToken) -> withStyle(
                    style = SpanStyle(
                        color = Color(
                            0xFF008080
                        )
                    )
                ) { append("$token ") }

                otherKeywords.contains(upperToken) -> withStyle(style = SpanStyle(color = Color.Gray)) {
                    append(
                        "$token "
                    )
                }

                token.matches(Regex("\\d+")) -> withStyle(style = SpanStyle(color = Color.Red)) {
                    append(
                        "$token "
                    )
                }

                else -> append("$token ")
            }
        }
    }
}