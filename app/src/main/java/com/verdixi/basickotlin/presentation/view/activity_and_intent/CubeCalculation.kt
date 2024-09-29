package com.verdixi.basickotlin.presentation.view.activity_and_intent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.verdixi.basickotlin.R

class CubeCalculation : AppCompatActivity(), View.OnClickListener {
    private lateinit var heightTxt: EditText
    private lateinit var widthTxt: EditText
    private lateinit var lengthTxt: EditText
    private lateinit var resultTxt: TextView
    private lateinit var calculateBtn: Button

        companion object {
        private const val STATE_RESULT = "state_result"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cube_calculation)

        heightTxt = findViewById(R.id.height_input)
        widthTxt = findViewById(R.id.width_input)
        lengthTxt = findViewById(R.id.length_input)
        resultTxt = findViewById(R.id.result_txt)
        calculateBtn = findViewById(R.id.btn_calc)
        calculateBtn.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            resultTxt.text = result
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_calc){
            val height = heightTxt.text.toString().trim()
            val width = widthTxt.text.toString().trim()
            val length = lengthTxt.text.toString().trim()
            var err: Boolean = false

            if (height.isEmpty()){
                heightTxt.error = "Field can't be empty"
                err = true
            }

            if (width.isEmpty()){
                widthTxt.error = "Field can't be empty"
                err = true
            }

            if (length.isEmpty()){
                lengthTxt.error = "Field can't be empty"
                err = true
            }

            if (!err){
                val volume = height.toFloat() * width.toFloat() * length.toFloat()
                resultTxt.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, resultTxt.text.toString())
    }
}