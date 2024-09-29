package com.verdixi.basickotlin.presentation.view.recycler_view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.verdixi.basickotlin.R

class ActivityRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)

        val toRecyclerView = findViewById<Button>(R.id.to_recycler_view)
        toRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerView::class.java))
        }

        val toUseLibrary = findViewById<Button>(R.id.to_use_library)
        toUseLibrary.setOnClickListener {
            startActivity(Intent(this, UseLibrary::class.java))
        }

        val toViewBinding = findViewById<Button>(R.id.to_view_binding)
        toViewBinding.setOnClickListener {
            startActivity(Intent(this, ViewBinding::class.java))
        }

        val toPracticeViewBinding = findViewById<Button>(R.id.to_practice_view_binding)
        toPracticeViewBinding.setOnClickListener {
            startActivity(Intent(this, PracticeViewBinding::class.java))
        }
    }
}