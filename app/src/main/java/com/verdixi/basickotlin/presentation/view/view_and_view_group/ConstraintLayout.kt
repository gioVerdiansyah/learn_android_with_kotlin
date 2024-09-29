package com.verdixi.basickotlin.presentation.view.view_and_view_group

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.verdixi.basickotlin.R

class ConstraintLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constraint_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val contactNewsAnchor = findViewById<Button>(R.id.contact_news_anchor)
        contactNewsAnchor.setOnClickListener {
            val toMyWa = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6287777365772?text=Hello"))
            startActivity(toMyWa)
        }
    }
}