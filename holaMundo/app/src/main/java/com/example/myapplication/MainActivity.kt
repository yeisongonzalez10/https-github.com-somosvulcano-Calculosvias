package com.example.myapplication

import CurvasHorizontales.CurvasCircular
import androidx.appcompat.app.AppCompatActivity

       // aporte 1 inicio
        
import android.content.Intent
import android.os.Bundle
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

    //aporte 3 inicio

            } else {
                Toast.makeText(this, "ingresar datos para Calcular", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun validaDato(): Boolean {
        val etDG = findViewById<EditText>(R.id.etDG)
        val DG = etDG.text
        val etDM = findViewById<EditText>(R.id.etDM)
        val DM = etDM.text
        val etDS = findViewById<EditText>(R.id.etDS)
        val DS = etDS.text
        val etC = findViewById<EditText>(R.id.etC)
        val C = etC.text
        val etRa = findViewById<EditText>(R.id.etRa)
        val Ra = etRa.text

        if (DG.isNullOrEmpty() || DM.isNullOrEmpty() || DS.isNullOrEmpty() || C.isNullOrEmpty() || Ra.isNullOrEmpty()) {
            return false
        }
        return true
    }
       //aporte 3 fin

// Aporte 4 incio

    // funcion para pasar los datos del angulos que ingresa grado, minuto y segundos, se vuelve grados decimales, para poder calcular
    fun GradosDecimales(GrD: EditText, GrM: EditText, GrS: EditText): Double {

        var DG = GrD.text.toString().toDouble()
        var DM = (GrM.text.toString().toDouble()) / 60
        var DS = (GrS.text.toString().toDouble()) / 3600
        return DG + DM + DS
    }


// funcion para pasar los datos del angulos decimales a grados en Grado, minutos y segundo, en String para mostrar al usuario

    fun Grados(GraDec: Double): String {

        var DG = "%.0f".format(truncate(GraDec)).toString() + "° "
        var DM = "%.0f".format((truncate(((GraDec - truncate(GraDec)) * 60)))).toString() + " ' "
        var DS = "%.2f".format(((((GraDec - truncate(GraDec)) * 60)) - (truncate(((GraDec - truncate(GraDec)) * 60)))) * 60).toString() + " ' '"

        return DG + DM + DS

    }

}

    // aporte 4 fin


}
    }
}

