package com.example2.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example2.test1.R.*
import com.example2.test1.R.id.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val greetingTextView = findViewById<TextView>(tbHello)
        val inputField = findViewById<EditText>(etName)
        val submitButton = findViewById<Button>(btnSubmit)
        val offersButton = findViewById<Button>(btnOffers)

        submitButton.setOnClickListener {
            val enterName = inputField.text.toString()
            if (enterName == "") {
                offersButton.visibility = INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(
                    applicationContext,
                    "Please type name",
                    Toast.LENGTH_LONG
                ).show()
            } else {

                val message = "Hello $enterName !!! Welcome to my Project"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = VISIBLE
            }
        }
        //Offer Button to next page connection code
        offersButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}