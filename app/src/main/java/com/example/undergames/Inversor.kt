package com.example.undergames

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class Inversor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inversor)

        val mediaPlayer = MediaPlayer.create(this, R.raw.jokenpo)
        mediaPlayer.start()

        val editTextInversor = findViewById<EditText>(R.id.editTextInversor)
        val btnInversor = findViewById<Button>(R.id.btnInversor)



        btnInversor.setOnClickListener {
            val intent = Intent(this, EndGameActivity::class.java)
            val texto = editTextInversor.text.toString()
            val textoInvertido = texto.reversed()
            mediaPlayer.stop()
            intent.putExtra("textoInvertido", "O seu texto invertido é $textoInvertido")
            startActivity(intent)
        }
    }
}