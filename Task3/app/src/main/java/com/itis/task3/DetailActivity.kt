package com.itis.task3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var descriptoinTextView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        val list = AlbumRepository.list
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail)

        var album: Album = Album()

        val message = intent.getIntExtra("ARG_ID", 0)

        titleTextView = findViewById(R.id.tv_title)

        for (item in list)
            if (item.id == message)
            {
                album = item
            }

        titleTextView = findViewById(R.id.tv_title)
        descriptoinTextView = findViewById(R.id.tv_desc)
        imageView = findViewById(R.id.iv_image)

        titleTextView.text = "ID: ${album.id} and Name: ${album.name}"
        descriptoinTextView.text = "Year: ${album.year}"
        Glide.with(this).load(album.url).into(imageView)


    }
}