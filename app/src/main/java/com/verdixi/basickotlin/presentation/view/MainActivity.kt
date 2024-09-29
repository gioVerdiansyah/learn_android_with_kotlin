package com.verdixi.basickotlin.presentation.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.presentation.view.activity_and_intent.ActivityAndIntent
import com.verdixi.basickotlin.presentation.view.recycler_view.ActivityRecyclerView
import com.verdixi.basickotlin.presentation.view.style_and_theme.ActivityStyleAndTheme
import com.verdixi.basickotlin.presentation.view.view_and_view_group.ActivityViewGroup

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val activityAndIntent = findViewById<Button>(R.id.to_activity_and_intent)
        activityAndIntent.setOnClickListener {
            startActivity(Intent(this, ActivityAndIntent::class.java))
        }

        val toViewNViewGroup = findViewById<Button>(R.id.to_view_and_view_group)
        toViewNViewGroup.setOnClickListener {
            startActivity(Intent(this, ActivityViewGroup::class.java))
        }

        val toStyleAndTheme = findViewById<Button>(R.id.to_style_and_theme)
        toStyleAndTheme.setOnClickListener {
            startActivity(Intent(this, ActivityStyleAndTheme::class.java))
        }

        val toRecyclerView = findViewById<Button>(R.id.to_recycler_view)
        toRecyclerView.setOnClickListener {
            startActivity(Intent(this, ActivityRecyclerView::class.java))
        }
    }
}