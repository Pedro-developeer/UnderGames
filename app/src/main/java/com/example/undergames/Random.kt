package com.example.undergames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class Random : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)



        val listaRandom:ListView = findViewById<ListView>(R.id.listViewRandom)
        val arrayRandom = arrayListOf<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayRandom)
        listaRandom.adapter = adapter
        val editTextRandom:EditText = findViewById<EditText>(R.id.editTextRandom)
        val btnAddtoList = findViewById<Button>(R.id.btnAdd)
        val btnRandom = findViewById<Button>(R.id.btnRandom)


        btnAddtoList.setOnClickListener {

            arrayRandom.add(editTextRandom.text.toString())
            adapter.notifyDataSetChanged()
        }

        btnRandom.setOnClickListener {
            arrayRandom.shuffle()
            adapter.notifyDataSetChanged()

        }

    }
}