package com.example.wrapfirebase.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wrapfirebase.R
import com.example.wrapfirebase.activities.Booketail
import com.example.wrapfirebase.model.Book
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.bookdata_xml.view.*

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
        holder.itemView.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, Booketail::class.java)
            intent.putExtra(Booketail.ARG_ITEM_ID,holder.itemView.textViewIsbn.text)
            intent.putExtra(Booketail.AUTHOR,holder.itemView.textViewAuthor.text)
            intent.putExtra(Booketail.TITLE,holder.itemView.textViewIsbn.text)
            intent.putExtra(Booketail.PUB,holder.itemView.textViewpublisher.text)
            context.startActivity(intent)
        }
    }
}
