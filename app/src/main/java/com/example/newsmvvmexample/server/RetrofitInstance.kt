package com.example.newsmvvmexample.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        @Volatile
        private var instance: Retrofit? = null

        fun getRetrofitInstance(): Retrofit {
            return instance ?: synchronized(this) {
                val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance = retrofit
                retrofit
            }
        }
    }

}