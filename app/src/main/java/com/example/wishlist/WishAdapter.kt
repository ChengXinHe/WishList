package com.example.wishlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val wishes: ArrayList<Wish>) : RecyclerView.Adapter<WishAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        // TODO: Create member variables for any view that will be set
        // as you render a row.

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            nameTextView = itemView.findViewById(R.id.WishName)
            priceTextView = itemView.findViewById(R.id.WishPrice)
            urlTextView = itemView.findViewById(R.id.WishURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val wishView = inflater.inflate(R.layout.wish_item, parent, false)

        val viewHolder = ViewHolder(wishView)
        /* 最外层布局点击事件 */
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(parent.context, "you click outer item!",
                Toast.LENGTH_SHORT).show()
        }

        /**
         *  长按监听：删除item
         */
        viewHolder.itemView.setOnLongClickListener {
            val position = viewHolder.adapterPosition
            /* 将长按item对应的学生姓名发送至MainActivity */
            Log.d("jiyi", "adapter remove:${wishes[position].wName}")
//            MainActivity.mainActivityTodo(
//                MainActivity.HANDLELONGCLIECK,
//                wishes[position].wName)
            /* 在ArrayList中移除此股 */
            wishes.remove(wishes[position])
            /* 通知移除该item */
            notifyItemRemoved(position)
            /* 通知调制ArrayList顺序(此句删除也无影响) */
            notifyItemRangeChanged(position, wishes.size)
            false
        }


        // Return a new holder instance
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishes[position]
        // Set item views based on views and data model
        holder.nameTextView.text = wish.wName
        holder.priceTextView.text = wish.wPrice
        holder.urlTextView.text = wish.wURL

    }

    override fun getItemCount(): Int {
        return wishes.size
    }
}

