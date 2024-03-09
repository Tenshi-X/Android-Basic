package com.example.submissionandroidbasic

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ANIME = "extra_anime"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val imgAnime: ImageView = findViewById(R.id.gambar_anime)
        val tvJudul: TextView = findViewById(R.id.tv_judul)
        val tvDesc: TextView = findViewById(R.id.tv_desc)


        val anime = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Anime>(EXTRA_ANIME, Anime::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Anime>(EXTRA_ANIME)
        }
        if (anime != null) {
            val foto = anime.photo
            val judul = "${anime.name}"
            val desc = "${anime.desc}"
            imgAnime.setImageResource(foto)
            tvJudul.text = judul
            tvDesc.text = desc
        }
    }
}