package com.verdixi.basickotlin.presentation.view.activity_and_intent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.verdixi.basickotlin.R
import com.verdixi.basickotlin.models.enums.Fields
import com.verdixi.basickotlin.models.enums.NumberCode

class FillData : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fill_data)

        val chooseAndBack = findViewById<Button>(R.id.choose_and_back)
        val rgNum = findViewById<RadioGroup>(R.id.rg_numbers)

        chooseAndBack.setOnClickListener {
            if (rgNum.checkedRadioButtonId > 0) {
                var num: Int = 0
                when (rgNum.checkedRadioButtonId) {
                    R.id.rb_100 -> num = 100
                    R.id.rb_150 -> num = 150
                    R.id.rb_200 -> num = 200
                    R.id.rb_250 -> num = 250
                    R.id.rb_300 -> num = 300
                }

                val resultIntent = Intent()
                resultIntent.putExtra(Fields.SELECTED_NUM.value, num)
                setResult(NumberCode.RESULT_CODE.value, resultIntent)
                finish()
            }
        }
    }
}