package com.example.bookshelf

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookshelf.ui.screens.HomeScreen

@Composable
fun BookshelfApp(modifier: Modifier = Modifier) {
    HomeScreen(modifier = modifier)
}