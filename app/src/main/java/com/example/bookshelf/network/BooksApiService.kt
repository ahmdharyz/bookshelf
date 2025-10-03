package com.example.bookshelf.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
        "https://www.googleapis.com/books/v1/volumes/"

val json = Json { ignoreUnknownKeys = true }
val contentType = "application/json".toMediaType()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory(contentType))
    .baseUrl(BASE_URL)
    .build()

interface BooksApiService {
    @GET("?q=maldives+history")
    suspend fun getBooks(): BookResults
}

object BooksApi {
    val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}