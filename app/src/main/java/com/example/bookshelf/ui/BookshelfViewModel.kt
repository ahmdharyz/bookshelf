package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.network.BooksApi
import kotlinx.coroutines.launch

class BookshelfViewModel : ViewModel() {

    var bookshelfUiState: String by mutableStateOf("")

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            val book = BooksApi.retrofitService.getBooks()
            bookshelfUiState = book
        }
    }
}
