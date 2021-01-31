package com.example.wrapfirebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.wrapfirebase.R
import com.example.wrapfirebase.model.Book
import com.example.wrapfirebase.service.FireBaseConnect
import kotlinx.android.synthetic.main.activity_main.*

class Booketail : AppCompatActivity() {

//    lateinit var book:Book;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSubmit.text="Update"
        btnCancel.text="Delete"
        //        setSupportActionBar(detail_toolbar as Toolbar?)
        // Show the Up  button in the action bar.
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle: Bundle? = intent.extras

        if (bundle?.containsKey(ARG_ITEM_ID)!!) {

            val id = intent.getStringExtra(ARG_ITEM_ID )

            bookTitle.setText( intent.getStringExtra(TITLE ))
            bookAuthor.setText( intent.getStringExtra(AUTHOR))
            bookPublisher.setText( intent.getStringExtra(PUB))
            bookIsbn.setText(id)
           // loadDetails(id.toString())

            initUpdateButton(id.toString()
            )

            initDeleteButton(id.toString())
        }
    }

    private fun initDeleteButton(id: String)
    {
        val connect =FireBaseConnect()
        btnCancel.setOnClickListener{v ->
           connect.deleteData(id)
        }
    }

    private fun initUpdateButton(id: String)
    {
        val connect =FireBaseConnect()
        btnSubmit.setOnClickListener{v ->
            val book=Book();
            book.author=bookAuthor.text.toString();
            book.isbn=bookIsbn.text.toString()
            book.publisher=bookPublisher.text.toString()
            book.title=bookTitle.text.toString()
            connect.updateData(book)
        }

    }

    private fun loadDetails(id: String)
    {
        val connect = FireBaseConnect()
        val book = connect.getData(id)
        bookTitle.setText(book.author)
        bookAuthor.setText(book.author)
        bookPublisher.setText(book.publisher)
        bookIsbn.setText(book.isbn)
    }

    companion object
    {
        const val ARG_ITEM_ID = "item_id"
        const val AUTHOR = "author"
        const val TITLE = "title"
        const val PUB = "publisher"
    }

}

