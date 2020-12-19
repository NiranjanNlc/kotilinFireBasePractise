package com.example.wrapfirebase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wrapfirebase.R
import com.example.wrapfirebase.adapter.BookAdapter
import com.example.wrapfirebase.model.Book
import com.example.wrapfirebase.service.FireBaseConnect
import kotlinx.android.synthetic.main.activity_book_list.*


class BookList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
//        setSupportActionBar(toolbar as Toolbar?)
//        (toolbar as Toolbar?)?.title ?: title

        fab.setOnClickListener {
            val intent = Intent(this@BookList, MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()

        loadDestinations()
    }

    private fun loadDestinations()
    {
        val recyclerView = findViewById(R.id.destiny_recycler_view) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val  userAdapter = BookAdapter(getData())
        recyclerView.adapter=userAdapter
    }
    private fun getData(): MutableList<Book> {
        val connect = FireBaseConnect()
        return connect.getData()

    }
}
