package com.r2brothers.blog

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.r2brothers.blog.db.entity.ArticleEntity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUpRecyclerView()

        fab.setOnClickListener { createArticle() }
    }

    fun createArticle(){
        val intent = Intent(this, CreateActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.rvArticleList) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getArticlesTest(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun getArticlesTest(): MutableList<ArticleEntity>{
        var articles:MutableList<ArticleEntity> = ArrayList()
        articles.add(ArticleEntity(0, "Articulo 1", "Cuerpo del articulo 1", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        articles.add(ArticleEntity(0, "Articulo 2", "Cuerpo del articulo 2", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        return articles
    }
}
