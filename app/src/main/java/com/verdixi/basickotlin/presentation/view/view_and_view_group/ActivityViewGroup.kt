package com.verdixi.basickotlin.presentation.view.view_and_view_group

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.verdixi.basickotlin.R

class ActivityViewGroup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_group)

        val toLinearLayout = findViewById<Button>(R.id.to_linear_layout)
        toLinearLayout.setOnClickListener {
            startActivity(Intent(this, LinearLayout::class.java))
        }

        val toConstraintLayout = findViewById<Button>(R.id.to_constraint_layout)
        toConstraintLayout.setOnClickListener {
            startActivity(Intent(this, ConstraintLayout::class.java))
        }
    }
}