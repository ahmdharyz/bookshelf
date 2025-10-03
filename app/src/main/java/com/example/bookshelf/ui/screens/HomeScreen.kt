package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import com.example.bookshelf.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookshelf.ui.BookshelfViewModel
import com.example.bookshelf.ui.BookshelfViewModel.BookshelfUiState

@Composable
fun HomeScreen(
    bookshelfUiState: BookshelfUiState,
    modifier: Modifier = Modifier,
) {
    when (bookshelfUiState) {
        is BookshelfUiState.Loading -> LoadingScreen(modifier = modifier)
        is BookshelfUiState.Error -> ErrorScreen(modifier = modifier)
        is BookshelfUiState.Success -> Bookshelf(books = bookshelfUiState.books, modifier = modifier)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.ic_connection_error),
            contentDescription = stringResource(R.string.loading_failed)
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun Bookshelf(
    books: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = books)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        bookshelfUiState = BookshelfViewModel.BookshelfUiState.Success(books = "Success"),
        modifier = Modifier.fillMaxSize()
    )
}