package com.example.thenewsapp.api

import com.example.thenewsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        // the api property simplifies the process of making network requests by encapsulating the configuration details of the Retrofit instance and providing a pre-configured implementation of the NewsAPI interface. Its main job is to act as a convenient entry point for interacting with a specific web API in your code.
        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }

}