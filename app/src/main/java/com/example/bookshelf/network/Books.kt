package com.example.bookshelf.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResults(
    val items: List<Books>
)

@Serializable
data class Books(
    val id: String,
    @SerialName("volumeInfo")
    val bookInfo: BookInfo,
)

@Serializable
data class BookInfo(
    val title: String,
    val authors: List<String>? = null,
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = null
)