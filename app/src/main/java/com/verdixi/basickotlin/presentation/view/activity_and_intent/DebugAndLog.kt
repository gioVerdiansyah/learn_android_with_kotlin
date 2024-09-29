package com.verdixi.basickotlin.presentation.view.activity_and_intent

import android.annotation.SuppressLint
import com.verdixi.basickotlin.R
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DebugAndLog : AppCompatActivity() {
    private lateinit var tvHello: TextView
    private var btnSetValue: Button? = null
    private var names = ArrayList<String>()

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_debug_and_log)

        tvHello = findViewById(R.id.tv_hello)
        btnSetValue = findViewById(R.id.btn_set_value) // remove to get error NullPointer

        names.add("Verdi")
        names.add("Adi")
        names.add("Niam")

        btnSetValue!!.setOnClickListener {
            Log.d("names variable", names.toString())
            val name = StringBuilder()
            for (i in 0..2){ // change 2 to 3 to get error IndexOutOfBoundsException
                name.append(names[i]).append("\n")
            }

            tvHello.text = name.toString()
        }
    }
}

//Log.e() for log error.
//Log.w() for log warning.
//Log.i() for log information.
//Log.d() for log debug.
//Log.v() for log verbose.

// How to use 'Debug mode'?
// Run with Debug mode
// and click number line until one line colored red