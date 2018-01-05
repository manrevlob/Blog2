package com.r2brothers.blog.db.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.r2brothers.blog.db.dao.ArticleDao
import com.r2brothers.blog.db.entity.ArticleEntity

@Database(entities = arrayOf(ArticleEntity::class), version = 1)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}