package com.example.textmodifierapp233

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var fontSize: Button
    private lateinit var fontColor: Button
    private lateinit var bgColor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        fontSize = findViewById(R.id.fontSize)
        fontColor = findViewById(R.id.fontColor)
        bgColor = findViewById(R.id.bgColor)

        fontSize.setOnClickListener{
            textView.textSize= 30f
        }

        fontColor.setOnClickListener{
            textView.setTextColor(resources.getColor(android.R.color.holo_purple))
        }

        bgColor.setOnClickListener{
            textView.setBackgroundColor(resources.getColor(android.R.color.holo_blue_light))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
