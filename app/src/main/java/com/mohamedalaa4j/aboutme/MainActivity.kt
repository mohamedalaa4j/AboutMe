package com.mohamedalaa4j.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnDone).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val etNickName = findViewById<EditText>(R.id.etNickName)
        val tvNickname = findViewById<TextView>(R.id.tvNickname)

        tvNickname.text = etNickName.text
        tvNickname.visibility = View.VISIBLE

        etNickName.visibility = View.INVISIBLE
        view.visibility = View.GONE

        hideKeyboard(view)
    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}