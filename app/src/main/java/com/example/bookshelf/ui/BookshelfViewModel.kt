package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BookshelfViewModel : ViewModel() {

    var bookshelfUiState: String by mutableStateOf("")

    init {
        getBooks()
    }

    private fun getBooks() {
        bookshelfUiState = "Success: Books retrieved"
    }
}
