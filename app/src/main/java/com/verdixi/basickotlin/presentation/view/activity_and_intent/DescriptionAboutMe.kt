package com.verdixi.basickotlin.presentation.view.activity_and_intent

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.models.enums.Fields

class DescriptionAboutMe : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_description_about_me)

//        Get data from previous navigation
        val myText = findViewById<TextView>(R.id.description_about_me)
        val name = intent.getStringExtra(Fields.NAME.value)
        val age = intent.getIntExtra(Fields.AGE.value, 0)
        val profession = intent.getStringExtra(Fields.PROFESSION.value)

        myText.text = "Hello my name is $name, I'm $age years old, and my profession is a $profession"
    }
}