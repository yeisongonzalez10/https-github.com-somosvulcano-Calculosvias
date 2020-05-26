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


        var hola: TextView? = null


        var presiona: Button = findViewById<Button>(R.id.bPresiona)
        presiona.setOnClickListener(View.OnClickListener {
            hola= findViewById(R.id.tvHolaMundo)

            hola?.text = "Hola mundo"

        }    )
    }
}
