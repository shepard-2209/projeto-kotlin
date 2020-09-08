package com.example.app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLimpar.setOnClickListener {
            resultado.text = ""
            descricao.text = ""
            idAltura.text = null
            idPeso.text = null
            Toast.makeText(this, "Preencha novamente!", Toast.LENGTH_LONG).show()
        }

        btnCalcular.setOnClickListener {

            if(idAltura.text.isNullOrEmpty() || idPeso.text.isNullOrEmpty()) {
                Toast.makeText(this, "Informações ausentes!", Toast.LENGTH_LONG).show()
                clear()

            } else {

                val a = idAltura.text.toString().toDouble() / 100
                val p = idPeso.text.toString().toDouble()
                val res:Double = p / (a * a)

                resultadoCalculo(res)

                resultado.text = "%.2f".format(res)

            }


        }


    }

    fun resultadoCalculo(r : Double) {
        if(r < 18.5) {
            descricao.setTextColor(Color.BLUE)
            descricao.text = "Baixo peso"

        } else if (r < 25) {
            descricao.setTextColor(Color.GREEN)
            descricao.text = "Peso adequado"

        } else if (r < 30) {
            descricao.setTextColor(Color.YELLOW)
            descricao.text = "Sobrepeso"
        } else {
            descricao.setTextColor(Color.RED)
            descricao.text = "Obesidade"
        }
    }

    fun clear() {
        resultado.text = ""
        descricao.text = ""
        idAltura.text = null
        idPeso.text = null
        Toast.makeText(this, "Preencha novamente!", Toast.LENGTH_LONG).show()
    }
}