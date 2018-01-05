package com.r2brothers.blog

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.r2brothers.blog.db.entity.ArticleEntity
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var articles: MutableList<ArticleEntity> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(articles: MutableList<ArticleEntity>, context: Context) {
        this.articles = articles
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = articles.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_article_list, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById(R.id.tvTitle) as TextView
        val body = view.findViewById(R.id.tvBody) as TextView
        val cover = view.findViewById(R.id.ivCover) as ImageView

        fun bind(articleEntity: ArticleEntity, context: Context) {
            title.text = articleEntity.title
            body.text = articleEntity.body
            cover.loadUrl(articleEntity.cover)
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, articleEntity.title, Toast.LENGTH_SHORT).show() })
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }
}