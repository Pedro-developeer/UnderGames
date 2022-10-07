package com.example.undergames

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mediaPlayer = MediaPlayer.create(this, R.raw.startgame)
        val btnStart = findViewById<ImageView>(R.id.btnStartGame)
        mediaPlayer.start()


        btnStart.setOnClickListener {
            mediaPlayer.stop()
            val intent:Intent = Intent(this, activity_hub::class.java)
            startActivity(intent)
        }

    }
}