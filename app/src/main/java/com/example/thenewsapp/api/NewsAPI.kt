package com.example.thenewsapp.api

import com.example.thenewsapp.models.NewsResponse
import com.example.thenewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apikey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apikey: String = API_KEY
    ): Response<NewsResponse>


}