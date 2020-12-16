package com.example.wrapfirebase

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    var mButton: Button? = null
    var mEdit: EditText? = null
    var mText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mButton = findViewById<View>(R.id.button1) as Button

        mButton!!.setOnClickListener {
            mEdit = findViewById(R.id.editText1) as EditText
            mText = findViewById(R.id.textView1) as TextView
            mText!!.text = "Welcome " + mEdit!!.text.toString() + "!"
            val db = FirebaseDatabase.getInstance("https://wrapfirebase-default-rtdb.firebaseio.com/")
            val ref = db.getReference();
            ref.setValue(mEdit.toString())
            mEdit!!.setText("")
            Toast.makeText(getApplicationContext(),"Hello World",Toast.LENGTH_SHORT).show();
        }
    }
}
