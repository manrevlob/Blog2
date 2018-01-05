package com.r2brothers.blog.db.entity

import android.arch.persistence.room.*

@Entity(tableName = "article_entity")
data class ArticleEntity(
        @PrimaryKey(autoGenerate = true)
        var id:Int = 0,
        var title:String = "",
        var body:String = "",
        var cover:String = ""
)