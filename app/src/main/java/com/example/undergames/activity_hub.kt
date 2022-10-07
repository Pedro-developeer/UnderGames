package com.example.undergames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class activity_hub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hub)

        val jokenpoApp = findViewById<Button>(R.id.jokenpoapp)
        val inversorApp = findViewById<Button>(R.id.invesorapp)
        val randomApp = findViewById<Button>(R.id.randomapp)
        val secretApp = findViewById<Button>(R.id.secretapp)

        jokenpoApp.setOnClickListener {
            val intent = Intent(this, activity_jokenpo::class.java)
            startActivity(intent)
        }

        inversorApp.setOnClickListener {
            val intent = Intent(this, Inversor::class.java)
            startActivity(intent)
        }

        randomApp.setOnClickListener {
            val intent = Intent(this, Random::class.java)
            startActivity(intent)
        }

        secretApp.setOnClickListener {
            val intent = Intent(this, Secret::class.java)
            startActivity(intent)
        }

    }
}