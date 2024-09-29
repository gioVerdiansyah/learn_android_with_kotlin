package com.verdixi.basickotlin.presentation.view.recycler_view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.databinding.ActivityMainBinding
import com.verdixi.basickotlin.databinding.ActivityViewBindingBinding

// To use view binding must activate this script
//    buildFeatures {
//        viewBinding = true
//    }
// in build.gradle.kts
// To ignore view binding ID use
// tools:viewBindingIgnore="true"

class ViewBinding : AppCompatActivity() {
    private lateinit var binding: ActivityViewBindingBinding
    // ActivityViewBindingBinding is actually activity_view_binding.xml

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Now we can use like that on specific ID in XML
        binding.mainText.text = "Hello Kotlin :)"
    }
}