package com.example.activitytoactivitywithdatatransferexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), MainActivity2.transferData_Listener {
    private lateinit var editText1_Activity1 : EditText
    private lateinit var editText2_Activity1 : EditText

    companion object {
        val EXTRA1 : String = "com.example.activitytoactivitywithdatatransferexample.EXTRA1"
        val EXTRA2 : String = "com.example.activitytoactivitywithdatatransferexample.EXTRA2"
        var EXTRA3 : Any? = null

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EXTRA3 = this
        editText1_Activity1 = findViewById(R.id.edittext1_activity1)
        editText2_Activity1 = findViewById(R.id.edittext2_activity1)
        val button : Button = findViewById<Button>(R.id.button_activity1)
        button.setOnClickListener {
            OpenActivity2()
        }
    }

    private fun OpenActivity2() {
        val intent : Intent = Intent(this, MainActivity2::class.java )
        intent.putExtra(EXTRA1, editText1_Activity1.text.toString())
        intent.putExtra(EXTRA2, editText2_Activity1.text.toString())
        startActivity(intent)
    }

    override fun transferData(extra1: String) {
        editText1_Activity1.setText(extra1)

    }
}