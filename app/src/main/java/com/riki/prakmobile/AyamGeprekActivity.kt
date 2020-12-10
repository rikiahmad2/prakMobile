package com.riki.prakmobile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AyamGeprekActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayam_geprek)

        val titles = intent.getStringExtra("AYAM_KATSU")
        val tv: TextView = findViewById(R.id.textViewGeprek)
        tv.setText(titles).toString()

        val tt = intent.getStringExtra("TITLE")
        val tv2: TextView = findViewById(R.id.textTitle)
        tv2.setText(tt).toString()

        val ttt = intent.getStringExtra("GAMBAR")
        val img: ImageView = findViewById(R.id.Image)

        if(ttt == "1" ) {
            img.setImageResource(R.drawable.ayam_geprek)
        }
        if(ttt == "2" ) {
            img.setImageResource(R.drawable.ayam_katsu)
        }
        if(ttt == "3" ) {
            img.setImageResource(R.drawable.seblak_bandung)
        }
    }
}