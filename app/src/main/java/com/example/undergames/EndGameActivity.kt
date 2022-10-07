package com.example.undergames

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EndGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)
        val mediaPlayer = MediaPlayer.create(this, R.raw.endgameinverse)
        mediaPlayer.start()
        val invertida = findViewById<TextView>(R.id.palavraInvertida)
        val btnHome = findViewById<Button>(R.id.btnHome)
        invertida.text = intent.getStringExtra("textoInvertido")

        btnHome.setOnClickListener {
            mediaPlayer.stop()
            finish()
            intent = intent.setClass(this, activity_hub::class.java)
            startActivity(intent)
        }

    }
}