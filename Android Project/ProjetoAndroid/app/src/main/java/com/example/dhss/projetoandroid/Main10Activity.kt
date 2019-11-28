package com.example.neto.projetoandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Main10Activity : AppCompatActivity() {

    private var textViewCidade: TextView? = null
    private var textViewTemperatura: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        val ottawa:Double = intent.getDoubleExtra("temperatura" , 0.0)

        textViewCidade = findViewById<TextView>(R.id.textViewCidade)
        textViewTemperatura = findViewById<TextView>(R.id.textViewTemp)

        Thread{
            var cidade = CidadeClimaServiceOttawa.getClimaCidade()
            runOnUiThread {
                textViewCidade?.text = cidade?.name.toString()
                textViewTemperatura?.text = cidade?.main?.temp.toString()
            }
        }.start()
    }
}
