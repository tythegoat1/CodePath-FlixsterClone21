package com.example.codepath_flixsterclone

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition


class MainActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        detailCardView()
        loadPostImage()

        val backButton = findViewById<Button>(R.id.backBTN)

        backButton.setOnClickListener { finish() }
    }

    private fun detailCardView() {
        val titleTV = findViewById<TextView>(R.id.movieDetailTitle)
        val descriptionTV = findViewById<TextView>(R.id.movieDetailDescription)
        val releaseDate = findViewById<TextView>(R.id.releaseDate)
        val voteAverage = findViewById<TextView>(R.id.voteAverage)
        val voteCount = findViewById<TextView>(R.id.voteCount)


        val detailTitle = intent.getStringExtra("title").toString()
        val detailDescription = intent.getStringExtra("description").toString()
        val rDate = intent.getStringExtra("releaseDate").toString()
        val voteAvg = intent.getStringExtra("voteAvg").toString()
        val voteCnt = intent.getStringExtra("voteCount").toString()


        titleTV.text = detailTitle
        descriptionTV.text = detailDescription

        //Setting string for TextViews
        "Release Date:\n$rDate".also { releaseDate.text = it }
        "$voteAvg Rating".also { voteAverage.text = it }
        "Out of $voteCnt votes.".also { voteCount.text = it }
    }

    private fun loadPostImage() {
        //Adding Poster Image
        val detailIV : ImageView = findViewById(R.id.movieDetailImage)
        val posterID = intent.getStringExtra("posterID")

        Glide.with(this).asBitmap()
            .load("https://image.tmdb.org/t/p/w500$posterID")
            .into(object : BitmapImageViewTarget(detailIV) {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    super.onResourceReady(resource, transition)
                }
            })
    }

}

