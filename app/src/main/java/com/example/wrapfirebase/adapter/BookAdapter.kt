package com.example.wrapfirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wrapfirebase.R
import com.example.wrapfirebase.model.Book

class BookAdapter(val userList: MutableList<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(book: Book) {
            val textViewTitle = itemView.findViewById(R.id.textViewTitle) as TextView
            val textViewAuthor = itemView.findViewById(R.id.textViewAuthor) as TextView
            val textViewIsbn = itemView.findViewById(R.id.textViewIsbn) as TextView
            val textViewPublisher = itemView.findViewById(R.id.textViewpublisher) as TextView
            textViewTitle.text = book.title
            textViewAuthor.text = book.author
            textViewIsbn.text = book.isbn
            textViewPublisher.text = book.publisher
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.bookdata_xml, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList.get(position))
    }
}
