package com.example.wrapfirebase.activities

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wrapfirebase.R
import com.example.wrapfirebase.model.Book
import com.example.wrapfirebase.service.FireBaseConnect


class MainActivity : AppCompatActivity() {

   lateinit var title: EditText
   lateinit var author:EditText
   lateinit var publisher:EditText
   lateinit var isbn:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addData(v:View)
    {
        val connect = FireBaseConnect()
        title= findViewById(R.id.bookTitle)
        author= findViewById(R.id.bookAuthor)
        publisher=findViewById(R.id.bookPublisher)
        isbn=findViewById(R.id.bookIsbn)
        val book = Book(title.text.toString(),author.text.toString(),publisher.text.toString(),isbn.text.toString())
        connect.insertData(book)
        title.setText("")
        author.setText("")
        publisher.setText("")
        isbn.setText("")
        Toast.makeText(this,"Data inserted",Toast.LENGTH_LONG)
    }

    fun clearData(view: View)
    {
        title= findViewById(R.id.bookTitle)
        author= findViewById(R.id.bookAuthor)
        publisher=findViewById(R.id.bookPublisher)
        isbn=findViewById(R.id.bookIsbn)
        title.setText("")
        author.setText("")
        publisher.setText("")
        isbn.setText("")
        Toast.makeText(this,"Data cleared",Toast.LENGTH_LONG)
    }

}
