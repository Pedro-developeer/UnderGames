package com.example.undergames

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class Secret : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret)
        val listaDeNumeros = arrayListOf<Int>()


        val editTextCode1 = findViewById<EditText>(R.id.editCode1)
        val editTextCode2 = findViewById<EditText>(R.id.editCode2)
        val editTextCode3 = findViewById<EditText>(R.id.editCode3)
        val editTextCode4 = findViewById<EditText>(R.id.editCode4)
        val listViewSecretTentatives = findViewById<ListView>(R.id.listViewSecretTentative)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val adapter  = ArrayAdapter(this, R.layout.row, listaDeNumeros)
        listViewSecretTentatives.adapter = adapter
        val numerSorteado = (1000..9999).shuffled().last()
        val mediaPlayer = MediaPlayer.create(this, R.raw.jokenpo)
        mediaPlayer.start()


        btnSubmit.setOnClickListener {
            val scoreSecreteGame:Int = 0
            val numeroDeTentativas = listaDeNumeros.size
            val code1 = editTextCode1.text.toString().toInt()
            val code2 = editTextCode2.text.toString().toInt()
            val code3 = editTextCode3.text.toString().toInt()
            val code4 = editTextCode4.text.toString().toInt()
            val code = "$code1$code2$code3$code4".toInt()
            listaDeNumeros.add(code)
            if(code == numerSorteado){
                editTextCode1.text.clear()
                editTextCode2.text.clear()
                editTextCode3.text.clear()
                editTextCode4.text.clear()
                Toast.makeText(this, "Parabéns, você acertou o número!", Toast.LENGTH_SHORT).show()
                intent = intent.setClass(this, EndGameActivity::class.java)
                intent.putExtra("textoInvertido", "Você acertou o número em $numeroDeTentativas tentativas")
                startActivity(intent)
                mediaPlayer.stop()
            }else{
                for (i in 0..3){
                    if(code.toString()[i] == numerSorteado.toString()[i]){
                        scoreSecreteGame + 1
                        Toast.makeText(this, "Você acertou um número na posição ${i+1}", Toast.LENGTH_SHORT).show()
                    }else if(code.toString()[i] == numerSorteado.toString()[0] || code.toString()[i] == numerSorteado.toString()[1] || code.toString()[i] == numerSorteado.toString()[2] || code.toString()[i] == numerSorteado.toString()[3]){
                        scoreSecreteGame + 1
                        Toast.makeText(this, "Você acertou um número, mas não na posição correta!", Toast.LENGTH_SHORT).show()
                    }else if(code.toString()[i] != numerSorteado.toString()[i]){
                        scoreSecreteGame + 1
                        Toast.makeText(this, "Você errou o número posição ${i+1}", Toast.LENGTH_SHORT).show()
                    }

                }
//               Toast.makeText(this, "$numerSorteado", Toast.LENGTH_LONG).show()
            }
            editTextCode1.text.clear()
            editTextCode2.text.clear()
            editTextCode3.text.clear()
            editTextCode4.text.clear()
            adapter.notifyDataSetChanged()
        }

    }
}