package com.verdixi.basickotlin.presentation.view.activity_and_intent

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.models.data.Person
import com.verdixi.basickotlin.models.enums.Fields

class AboutMe : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about_me)

        val aboutMe = findViewById<TextView>(R.id.about_me)

        val person = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Fields.PERSON.value, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Fields.PERSON.value)
        }

        if (person != null) {
            aboutMe.text = """
                    Name: ${person.name}
                    Age: ${person.age}
                    Married: ${if (person.married) "Yes" else "No"}
                    Profession: ${person.profession}
                    Hobbies: ${person.hobbies.toString().replace("[", "").replace("]", "")}
            """.trimIndent()
        }
    }
}