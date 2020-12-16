package com.example.wrapfirebase.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wrapfirebase.R
import com.example.wrapfirebase.adapter.BookAdapter
import com.example.wrapfirebase.model.Book
import com.example.wrapfirebase.service.FireBaseConnect


class DisplayData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)
        val recyclerView = findViewById(R.id.recycler) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val  userAdapter = BookAdapter(getData())
        recyclerView.adapter=userAdapter
    }

    private fun getData(): MutableList<Book> {
        val connect = FireBaseConnect()
        return connect.getData()

    }
}
