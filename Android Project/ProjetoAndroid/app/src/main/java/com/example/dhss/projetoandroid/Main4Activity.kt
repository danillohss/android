package com.example.neto.projetoandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Main4Activity : AppCompatActivity() {

    private var textViewCidade: TextView? = null
    private var textViewTemperatura: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var buttonNext = findViewById<Button>(R.id.button4)

        val gravata:Double = intent.getDoubleExtra("temperatura" , 0.0)

        textViewCidade = findViewById<TextView>(R.id.textViewCidade)
        textViewTemperatura = findViewById<TextView>(R.id.textViewTemp)

        Thread{
            var cidade = CidadeClimaGravata.getClimaCidade()
            runOnUiThread {
                textViewCidade?.text = cidade?.name.toString()
                textViewTemperatura?.text = cidade?.main?.temp.toString()
            }
        }.start()

        buttonNext.setOnClickListener {
            var bezerros = 0
            val intent = Intent(this, Main5Activity::class.java)
            intent.putExtra("temperatura", bezerros)
            startActivity(intent)
        }
    }
}
