package com.mobcom.finalexamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_url = findViewById<EditText>(R.id.url_input)
        val button = findViewById<Button>(R.id.get_source)
        val tv_result = findViewById<TextView>(R.id.tv_result)

        button.setOnClickListener {
            tv_result.text = et_url.text.toString()
        }
    }


}