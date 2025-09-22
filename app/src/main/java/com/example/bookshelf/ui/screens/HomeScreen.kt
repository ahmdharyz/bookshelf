package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    marsUiState: String,
    modifier: Modifier = Modifier
) {
    BooksScreen(marsUiState, modifier)
}

@Composable
fun BooksScreen(
    books: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = books)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier.fillMaxSize(),
        marsUiState = "Success: Books retrieved"
    )
}