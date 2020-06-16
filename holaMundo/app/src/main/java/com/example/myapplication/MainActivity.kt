package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // aporte 1 inicio
        
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.truncate


class MainActivity : AppCompatActivity() {

    var etC: EditText? = null
    var etRa: EditText? = null
    var tvT: TextView? = null
    var tvCl: TextView? = null
    var tvE: TextView? = null
    var tvO: TextView? = null
    var tvG: TextView? = null
    var tvL: TextView? = null
    var tvCu: TextView? = null
    var tvDm: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etDG = findViewById<EditText>(R.id.etDG)
        var etDM = findViewById<EditText>(R.id.etDM)
        var etDS = findViewById<EditText>(R.id.etDS)
        var etC = findViewById<EditText>(R.id.etC)
        var etRa = findViewById<EditText>(R.id.etRa)

    //aporte 1 fin

    //aporte 2 inicio

        val Calcular = findViewById<Button>(R.id.buCalcularCircular)
        Calcular.setOnClickListener(View.OnClickListener {
            if (validaDato()) {

                var intent = Intent(this, MainActivity::class.java)

                // Datos que ingresa el usuario, los convertimos en Double para poder calcular los elementos de la curva en la clase CurvaHorizontal

                var D = GradosDecimales(etDG, etDM, etDS) // Delta de la curva
                var C = etC.text.toString().toDouble() // Cuerda, linea reta de la curva
                var Ra =etRa.text.toString().toDouble() // Radio, Circuferencia que describe la curva

                // utilizamos la clase CurvaHorizontal para Calcular los elementos de la curva circular y lo dejamos en la variable c

                var c = CurvasCircular(D,C,Ra)


                tvT = findViewById(R.id.tvT)
                tvCl = findViewById(R.id.tvCl)
                tvE = findViewById(R.id.tvE)
                tvO = findViewById(R.id.tvO)
                tvG = findViewById(R.id.tvG)
                tvL = findViewById(R.id.tvL)
                tvCu = findViewById(R.id.tvCu)
                tvDm = findViewById(R.id.tvDm)


                tvT?.text = "%.3f".format(c.T).toString()
                tvCl?.text = "%.3f".format(c.CL).toString()
                tvE?.text = "%.3f".format(c.E).toString()
                tvO?.text = "%.3f".format(c.O).toString()
                tvG?.text = Grados(c.Gr).toString()
                tvL?.text = "%.3f".format(c.L).toString()
                tvCu?.text = "%.3f".format(c.Cu).toString()
                tvDm?.text = "%.3f".format(c.Dm).toString()

    //aporte 2 fin







            }
    }
}

