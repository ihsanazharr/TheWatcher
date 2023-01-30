package com.ihsan.thewatcher


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ihsan.thewatcher.models.Movie
import kotlinx.android.synthetic.main.activity_detail_movie.*


class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        img_item_photo.clipToOutline = true

        val detailMovies = intent.getParcelableExtra<Movie>(EXTRA_MOVIES)

        if (detailMovies != null){
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this).load(IMAGE_BASE + detailMovies.poster).into(img_item_photo)
            tv_item_name.text = detailMovies.title
            tv_item_description.text = detailMovies.overview
            movie_release.text = detailMovies.releaseDate
            movie_average.text = detailMovies.voteAverage
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun back(view: View) {
        onBackPressed()
    }
}