package com.example.undergames

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class activity_jokenpo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokenpo)
        
        val rock: ImageView = findViewById(R.id.small_rock)
        val paper: ImageView = findViewById(R.id.small_paper)
        val scissors: ImageView = findViewById(R.id.small_scissors)
        val escolhaDoApp: ImageView = findViewById(R.id.escolha_do_app)
        val youPoints = findViewById<TextView>(R.id.youPoints)
        val underPoints = findViewById<TextView>(R.id.underPoints)
        var scoreUnder:Int = 0
        var scoreYou:Int = 0
        var totalPoints:Int = 0

        val btnBackTohub = findViewById<Button>(R.id.btnEndGame)



        val mediaPlayer = MediaPlayer.create(this, R.raw.jokenpo)
        mediaPlayer.start()

        btnBackTohub.setOnClickListener {
            val intent = Intent(this, activity_hub::class.java)
            startActivity(intent)
            mediaPlayer.stop()
        }




        rock.setOnClickListener {
            val opcoes = listOf("pedra", "papel", "tesoura")
            val numeroAleatorio = (0..2).random()

            when (opcoes[numeroAleatorio]) {
                "pedra" -> escolhaDoApp.setImageResource(R.drawable.big_rock)
                "papel" -> escolhaDoApp.setImageResource(R.drawable.big_paper)
                "tesoura" -> escolhaDoApp.setImageResource(R.drawable.big_scissors)
            }

            if (opcoes[numeroAleatorio] == "pedra") {
                Toast.makeText(this, "Empate", LENGTH_SHORT).show()
            } else if (opcoes[numeroAleatorio] == "papel") {
                Toast.makeText(this, "Você perdeu", LENGTH_SHORT).show()
                scoreUnder++
                underPoints.text = scoreUnder.toString()
                totalPoints = scoreYou + scoreUnder
            } else {
                Toast.makeText(this, "Você ganhou", LENGTH_SHORT).show()
                scoreYou++
                youPoints.text = scoreYou.toString()
            }
        }

        paper.setOnClickListener {
            val opcoes = listOf("pedra", "papel", "tesoura")
            val numeroAleatorio = (0..2).random()

            when (opcoes[numeroAleatorio]) {
                "pedra" -> escolhaDoApp.setImageResource(R.drawable.big_rock)
                "papel" -> escolhaDoApp.setImageResource(R.drawable.big_paper)
                "tesoura" -> escolhaDoApp.setImageResource(R.drawable.big_scissors)
            }
            if (opcoes[numeroAleatorio] == "pedra") {
                Toast.makeText(this, "Você ganhou!", LENGTH_SHORT).show()
                scoreYou++
                youPoints.text = scoreYou.toString()
            } else if (opcoes[numeroAleatorio] == "papel") {
                Toast.makeText(this, "Empate!", LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Você perdeu!", LENGTH_SHORT).show()
                scoreUnder++
                underPoints.text = scoreUnder.toString()
            }
        }

        scissors.setOnClickListener {
            val opcoes = listOf("pedra", "papel", "tesoura")
            val numeroAleatorio = (0..2).random()
            when (opcoes[numeroAleatorio]) {
                "pedra" -> escolhaDoApp.setImageResource(R.drawable.big_rock)
                "papel" -> escolhaDoApp.setImageResource(R.drawable.big_paper)
                "tesoura" -> escolhaDoApp.setImageResource(R.drawable.big_scissors)
            }

            if (opcoes[numeroAleatorio] == "pedra") {
                Toast.makeText(this, "Você perdeu!", LENGTH_SHORT).show()
                scoreUnder++
                underPoints.text = scoreUnder.toString()
            } else if (opcoes[numeroAleatorio] == "papel") {
                Toast.makeText(this, "Você ganhou!", LENGTH_SHORT).show()
                scoreYou++
                youPoints.text = scoreYou.toString()
            } else {
                Toast.makeText(this, "Empate!", LENGTH_SHORT).show()
            }
        }
    }
}