package com.ihsan.thewatcher

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ihsan.thewatcher.models.Movie
import com.ihsan.thewatcher.models.TV
import kotlinx.android.synthetic.main.activity_detail_tvactivity.*
import kotlinx.android.synthetic.main.tv_item.*
import kotlinx.android.synthetic.main.tv_item.tv_average
import kotlinx.android.synthetic.main.tv_item.tv_release


class DetailTVActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TvS = "extra_tvs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tvactivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        img_item_photo.clipToOutline = true

        val detailTvs = intent.getParcelableExtra<TV>(DetailTVActivity.EXTRA_TvS)

        if (detailTvs != null){
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this).load(IMAGE_BASE + detailTvs.poster).into(img_item_photo)
            tv_item_name.text = detailTvs.name
            tv_item_description.text = detailTvs.overview
            tv_release.text = detailTvs.firstAir
            tv_average.text =detailTvs.voteAverage
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}