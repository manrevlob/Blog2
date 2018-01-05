package com.r2brothers.blog.db.dao

import android.arch.persistence.room.*
import com.r2brothers.blog.db.entity.ArticleEntity

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article_entity")
    fun getAllArticles(): MutableList<ArticleEntity>

    @Query("SELECT * FROM article_entity where id like :arg0")
    fun getArticleById(id: Long): ArticleEntity

    @Insert
    fun addArticle(articleEntity: ArticleEntity): Long

    @Update
    fun updateArticle(articleEntity: ArticleEntity): Int

    @Delete
    fun deleteArticle(articleEntity: ArticleEntity): Int
}