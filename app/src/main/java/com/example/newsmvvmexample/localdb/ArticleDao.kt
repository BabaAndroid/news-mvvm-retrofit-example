package com.example.newsmvvmexample.localdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsmvvmexample.model.Article


//this interface in responsible to perform operations in Room persistence library
@Dao
interface ArticleDao {

    //inserting data to room
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticleToDb(article: Article)

    //delete specific data
    @Delete
    suspend fun deleteArticleToDb(article: Article)

    //delete all article
    @Query("DELETE from article_table")
    suspend fun deleteAllArticle()

    //get article detail from room DB
    @Query("SELECT * from article_table order by id desc")
    fun getAllArticle(): LiveData<List<Article>>


}