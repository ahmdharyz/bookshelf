package com.example.bookshelf.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Books(
    val id: String,
    @SerialName(value = "thumbnail")
    val imgSrc: String
)
