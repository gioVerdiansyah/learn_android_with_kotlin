package com.verdixi.basickotlin.presentation.view.activity_and_intent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.models.data.Person
import com.verdixi.basickotlin.models.enums.Fields

class ActivityAndIntent : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_and_intent)

        //        Basic navigation
        val btnToCubeCalculation = findViewById<Button>(R.id.to_cube_calculation)
        btnToCubeCalculation.setOnClickListener {
            startActivity(Intent(this, CubeCalculation::class.java))
        }

//        Explicit Intent
//        Navigation with data
        val btnToMyDescription = findViewById<Button>(R.id.description_about_me)
        btnToMyDescription.setOnClickListener {
            val descriptionIntent = Intent(this, DescriptionAboutMe::class.java)
            descriptionIntent.putExtra(Fields.NAME.value, "Verdi")
            descriptionIntent.putExtra(Fields.AGE.value, 21)
            descriptionIntent.putExtra(Fields.PROFESSION.value, "Android Developer")
            startActivity(descriptionIntent)
        }

//        Navigation with data with parcelable
        val btnToMyAboutMe = findViewById<Button>(R.id.about_me)
        btnToMyAboutMe.setOnClickListener {
            val aboutMeIntent = Intent(this, AboutMe::class.java)
            val person: Person = Person(
                "Verdi",
                21,
                true,
                "Android Developer",
                arrayListOf("Coding", "Gaming")
            )

            aboutMeIntent.putExtra(Fields.PERSON.value, person)
            startActivity(aboutMeIntent)
        }

//        Implicit Intent
        val myWhatsApp = findViewById<Button>(R.id.my_whatsapp)
        myWhatsApp.setOnClickListener {
            val toWa = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6287777365772?text=Hello"))
            startActivity(toWa)
        }

//        Catch return value from navigation back Intent
        val catchAndFill = findViewById<Button>(R.id.catch_fill_data)
        catchAndFill.setOnClickListener {
            startActivity(Intent(this, CatchData::class.java))
        }

//        Debugging and Logging
        val debugAndLog = findViewById<Button>(R.id.to_debug_and_log)
        debugAndLog.setOnClickListener {
            startActivity(Intent(this, DebugAndLog::class.java))
        }
    }
}