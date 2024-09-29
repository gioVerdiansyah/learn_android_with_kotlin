package com.verdixi.basickotlin.presentation.view.activity_and_intent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.models.enums.Fields
import com.verdixi.basickotlin.models.enums.NumberCode

class CatchData : AppCompatActivity() {
    //   Catch data from FillData
    private lateinit var crText: TextView
    @SuppressLint("SetTextI18n")
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == NumberCode.RESULT_CODE.value && result.data != null){
            val selectedNum = result.data?.getIntExtra(Fields.SELECTED_NUM.value, 0)
            crText.text = "Result: $selectedNum"
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_catch_data)

        val btnFillData = findViewById<Button>(R.id.to_fill_data)
        crText = findViewById(R.id.result_catch_data)
        btnFillData.setOnClickListener {
            val toFillData = Intent(this, FillData::class.java)
            resultLauncher.launch(toFillData)
        }
    }
}