package com.example.newsmvvmexample.server

import com.example.newsmvvmexample.model.NewsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

public interface ApiService {

    @GET("/v2/top-headlines?apikey=e23eb52f8710467d9028d335eaceda78")
    suspend fun getNewsFromServer(
        @Query("country") country_code: String,
        @Query("page") page: Int
    ): Response<NewsList>

}