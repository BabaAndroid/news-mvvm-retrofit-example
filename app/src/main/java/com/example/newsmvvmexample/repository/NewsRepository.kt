package com.example.newsmvvmexample.repository

import androidx.lifecycle.MutableLiveData
import com.example.newsmvvmexample.localdb.ArticleDao
import com.example.newsmvvmexample.model.Article
import com.example.newsmvvmexample.model.NewsList
import com.example.newsmvvmexample.server.ApiService
import retrofit2.Response

class NewsRepository(private val apiService: ApiService, private val articleDao: ArticleDao) {

    //making server calls
    suspend fun getNewsFromServer(): Response<NewsList> {
        return apiService.getNewsFromServer(
            "in", 1
        );
    }

    //making local DB calls
    suspend fun saveData(article: Article) {
        articleDao.insertArticleToDb(article)
    }

    suspend fun deleteArticle(article: Article) {
        articleDao.insertArticleToDb(article)
    }

    suspend fun deleteAllArticle() {
        articleDao.deleteAllArticle()
    }

}