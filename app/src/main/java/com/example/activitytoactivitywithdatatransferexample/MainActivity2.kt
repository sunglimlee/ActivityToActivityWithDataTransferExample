package com.example.activitytoactivitywithdatatransferexample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

//ActivityResult를 이용하면 되는데 정말 꼭 인터페이스를 사용하기 위해서 이런짓까지 해야 하나???
//MainActivity1에서 companion object를 사용해서 onCreate에다가 this를 할당하는 짓까지해서 인터페이스를 사용해본다.
class MainActivity2 : AppCompatActivity() {
    private lateinit var editText1_Activity2: EditText
    private lateinit var editText2_Activity2: EditText
    private lateinit var button : Button
    private lateinit var listener : transferData_Listener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //야.. 이건뭐.. 이런 멍청한 짓을 하니깐 문제가 되지...
        //그냥 막 복사하니깐 안되잖아... 기가찬다.
        setContentView(R.layout.activity2_main)
        if (parent is Activity) {
            Log.e("miah", "Yes. it is Activity")
        }
        listener = MainActivity.EXTRA3 as transferData_Listener
        val e = Log.e("steve", "yes")
        editText1_Activity2 = findViewById(R.id.edittext1_activity2)
        editText2_Activity2 = findViewById(R.id.edittext2_activity2)
        findViewById<Button>(R.id.button_activity2).apply { button = this }.also { it.setOnClickListener{onBackPressed()} }
        loadData()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (intent.getStringExtra(MainActivity.EXTRA1).toString() != editText1_Activity2.text.toString()) {
            listener.transferData(editText1_Activity2.text.toString())
        }
    }

    private fun loadData() {
        val intent : Intent = intent
        Log.e("lsl", "data is ${intent.getStringExtra(MainActivity.EXTRA1)}")
        intent.getStringExtra(MainActivity.EXTRA1).toString().also { editText1_Activity2.setText(" $it")}
        intent.getStringExtra(MainActivity.EXTRA2).toString().also { editText2_Activity2.setText(" $it")}
    }

    interface transferData_Listener {
        fun transferData(extra1 : String) {

        }
    }
}