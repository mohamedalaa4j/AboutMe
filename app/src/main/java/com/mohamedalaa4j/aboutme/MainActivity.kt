package com.mohamedalaa4j.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mohamedalaa4j.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private val myNameObj = MyName("Mohamed")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Assign object to the data variable
        binding?.myName = myNameObj

        binding?.btnDone?.setOnClickListener {
            addNickname(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun addNickname(view: View) {

        binding?.apply {
            myName?.nickname = etNickName.text.toString()
            tvNickname.visibility = View.VISIBLE

            invalidateAll()
            etNickName.visibility = View.GONE
            btnDone.visibility=View.GONE
        }

        hideKeyboard(view)
    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}