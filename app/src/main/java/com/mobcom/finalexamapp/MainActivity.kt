package com.mobcom.finalexamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_url = findViewById<EditText>(R.id.url_input)
        val button = findViewById<Button>(R.id.get_source)
        val tv_result = findViewById<TextView>(R.id.tv_result)

        button.setOnClickListener {
            loading(et_url.text.toString(), tv_result)
        }
    }

    private fun loading(url: String, tv_result: TextView) {
        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET, "http://$url",
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    tv_result.text = "Response is: ${response.substring(0, 500)}"
                },
                Response.ErrorListener { tv_result.text = "That didn't work!" })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}