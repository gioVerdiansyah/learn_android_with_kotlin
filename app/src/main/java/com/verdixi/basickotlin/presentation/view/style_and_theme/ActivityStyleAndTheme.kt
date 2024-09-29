package com.verdixi.basickotlin.presentation.view.style_and_theme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.verdixi.basickotlin.R

class ActivityStyleAndTheme : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_style_and_theme)

        val toStyleAndTheme = findViewById<Button>(R.id.to_styleing)
        toStyleAndTheme.setOnClickListener {
            startActivity(Intent(this, Styleing::class.java))
        }

        val toPractice = findViewById<Button>(R.id.to_practice)
        toPractice.setOnClickListener {
            startActivity(Intent(this, PracticeStyleAndTheme::class.java))
        }

//        To see theme, see at AndroidManifest and res/values/themes.xml
    }
}