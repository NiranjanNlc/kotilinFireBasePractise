package com.example.wrapfirebase.service

import android.content.ContentValues.TAG
import android.util.Log
import com.example.wrapfirebase.model.Book
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FireBaseConnect
{
    val db = FirebaseDatabase.getInstance("https://wrapfirebase-default-rtdb.firebaseio.com/")

    fun insertData(book:Book)
    {
        val ref = db.getReference("/Book/${book.isbn}");
        ref.setValue(book)
    }
    fun getData(id:String): Book {
        val myRef =db.getReference("Book").child(id)
        var book=Book();
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                 book= dataSnapshot.value as Book

            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        return book ;
    }
    fun updateData(book:Book)
    {
        val myRef =db.getReference("Book").child(book.isbn)
        myRef.child("isbn").setValue(book.isbn)
        myRef.child("author").setValue(book.author)
        myRef.child("publisher").setValue(book.publisher)
        myRef.child("title").setValue(book.title)
    }
    fun deleteData(id:String)
    {
        val myRef =db.getReference("Book").child(id)
       myRef.removeValue()
    }

    fun getData(): MutableList<Book> {
        val books = mutableListOf<Book>()
        val myRef =db.getReference("/Book")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                 if(dataSnapshot.exists())
                 {
                     for(book in dataSnapshot.children)
                     {

                         books.add(book.getValue(Book::class.java)!!)
                     }
                 }
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        return books;
    }
    fun updateData() {}
    fun deleteData() {}
}