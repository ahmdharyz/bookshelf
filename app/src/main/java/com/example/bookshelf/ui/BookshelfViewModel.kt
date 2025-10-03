package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.network.BooksApi
import kotlinx.coroutines.launch
import java.io.IOException

class BookshelfViewModel : ViewModel() {

    sealed interface BookshelfUiState {
        data class Success(val books: String): BookshelfUiState
        object Loading: BookshelfUiState
        object Error: BookshelfUiState
    }

    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            bookshelfUiState = try {
                val bookResults = BooksApi.retrofitService.getBooks()
                BookshelfUiState.Success("Success: ${bookResults.items.size} books received")
            } catch (e: IOException) {
                BookshelfUiState.Error
            }
        }
    }
}
