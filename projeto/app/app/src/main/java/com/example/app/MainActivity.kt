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
            clear()
        }

        btnCalcular.setOnClickListener {

            if(nome.text.isNullOrEmpty() || anoNascimento.text.isNullOrEmpty() || anoAtual.text.isNullOrEmpty()) {
                Toast.makeText(this, "Informações ausentes!", Toast.LENGTH_LONG).show()
                clear()
            } else {
                if(anoNascimento.text.equals(0) || anoAtual.text.equals(0) ||
                    anoNascimento.text.toString().toInt() < 1900 || anoAtual.text.toString().toInt() < 1900) {
                    Toast.makeText(this, "Tenta de novo!", Toast.LENGTH_LONG).show()
                    clear()
                } else {
                    if(anoAtual.text.toString().toInt() < anoNascimento.text.toString().toInt()) {
                        Toast.makeText(this, "Tenta de novo!", Toast.LENGTH_LONG).show()
                        clear()
                    } else {
                        val a = anoNascimento.text.toString().toInt()
                        val b = anoAtual.text.toString().toInt()

                        val idade:Int = b - a

                        resultadoCalculo(idade)
                    }


                }
            }

        }
}
    fun resultadoCalculo(r : Int) {

        resultado.setText("Olá, " + nome.text + "!")

        if(r <= 14) {
            descricao.setTextColor(Color.RED)
            descricao.text = "Você com certeza bebe toddynho, continue assim!"

        } else if (r < 18) {
            descricao.setTextColor(Color.YELLOW)
            descricao.text = "Talvez você beba álcool, isso é feio : ("

        } else if (r <= 30) {
            descricao.setTextColor(Color.GREEN)
            descricao.text = "Você é adulto, você pode beber!"
        } else {
            descricao.setTextColor(Color.BLUE)
            descricao.text = "Você ainda tá vivo! Então, tudo certo"
        }
    }

    fun clear() {
        nome.text = null
        anoAtual.text = null
        anoNascimento.text = null
        resultado.text = ""
        descricao.text = ""

        Toast.makeText(this, "Preencha novamente!", Toast.LENGTH_LONG).show()
    }
}