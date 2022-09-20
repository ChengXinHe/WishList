package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var wishes: ArrayList<Wish>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        val nameTextView = findViewById<EditText>(R.id.textName)
        val priceTextView = findViewById<EditText>(R.id.textPrice)
        val uRLTextView = findViewById<EditText>(R.id.textURL)


        val wishesRv = findViewById<RecyclerView>(R.id.wishesRv)
        // Fetch the list of emails
        //wishes = WishFetcher.getEmails()
        // Create adapter passing in the list of emails
        wishes = WishFetcher.getEmails()
        val adapter = WishAdapter(wishes)
        // Attach the adapter to the RecyclerView to populate items
        wishesRv.adapter = adapter
        // Set layout manager to position the items
        wishesRv.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            // Add a new contact
            val curSize = adapter.getItemCount()

            // replace this line with wherever you get new records
            val newItems = Wish(nameTextView.text.toString(), priceTextView.text.toString(),uRLTextView.text.toString())
            // update the existing list
            wishes.add(newItems)
            // curSize should represent the first element that got added

            // Notify the adapter that an item was inserted at position 0
            adapter.notifyItemInserted(curSize)
            nameTextView.text.clear()
            priceTextView.text.clear()
            uRLTextView.text.clear()
        }
    }
//    fun mainActivityTodo(studentName: String):{
//        wishes.remove()
//    }
}


