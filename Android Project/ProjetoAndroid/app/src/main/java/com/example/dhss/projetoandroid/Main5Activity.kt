package com.example.neto.projetoandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Main5Activity : AppCompatActivity() {

    private var textViewCidade: TextView? = null
    private var textViewTemperatura: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var buttonNext = findViewById<Button>(R.id.button5)

        val bezerros:Double = intent.getDoubleExtra("temperatura" , 0.0)

        textViewCidade = findViewById<TextView>(R.id.textViewCidade)
        textViewTemperatura = findViewById<TextView>(R.id.textViewTemp)

        Thread{
            var cidade = CidadeClimaServiceBezerros.getClimaCidade()
            runOnUiThread {
                textViewCidade?.text = cidade?.name.toString()
                textViewTemperatura?.text = cidade?.main?.temp.toString()
            }
        }.start()

        buttonNext.setOnClickListener {
            var london = 0
            val intent = Intent(this, Main6Activity::class.java)
            intent.putExtra("temperatura", london)
            startActivity(intent)
        }
    }
}
