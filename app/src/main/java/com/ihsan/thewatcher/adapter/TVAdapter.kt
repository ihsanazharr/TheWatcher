package com.ihsan.thewatcher.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ihsan.thewatcher.DetailTVActivity
import com.ihsan.thewatcher.R
import com.ihsan.thewatcher.models.TV
import kotlinx.android.synthetic.main.activity_detail_tvactivity.view.*
import kotlinx.android.synthetic.main.tv_item.view.*
import kotlinx.android.synthetic.main.tv_item.view.tv_average
import kotlinx.android.synthetic.main.tv_item.view.tv_poster
import kotlinx.android.synthetic.main.tv_item.view.tv_release


class TVAdapter(
    private val  tvs : List<TV>
) : RecyclerView.Adapter<TVAdapter.TVViewHolder>(){

    class TVViewHolder (view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindTV(tv: TV){
            itemView.tv_title.text = tv.name
            itemView.tv_release.text = tv.firstAir
            itemView.tv_average.text = tv.voteAverage
            itemView.tv_popularity.text = tv.popularity
            Glide.with(itemView).load(IMAGE_BASE + tv.poster).into(itemView.tv_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {
        return TVViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        val tv = tvs[position]
        holder.bindTV(tvs.get(position))

        holder.itemView.setOnClickListener {
            moveToTvSDetail(tv, it)
        }
    }

    private fun moveToTvSDetail(tv: TV, it: View) {
        val detailTvsIntent = Intent(it.context, DetailTVActivity::class.java)
        detailTvsIntent.putExtra(DetailTVActivity.EXTRA_TvS, tv)
        it.context.startActivity(detailTvsIntent)
    }

    override fun getItemCount(): Int = tvs.size

    
}