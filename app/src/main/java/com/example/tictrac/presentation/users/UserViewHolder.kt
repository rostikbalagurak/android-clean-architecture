package com.example.tictrac.presentation.users

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.tictrac.R
import com.example.tictrac.domain.entity.User
import com.squareup.picasso.Picasso

class UserViewHolder(private val listener: UsersAdapter.InteractionListener,
                     itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val ivUser = itemView.findViewById<ImageView>(R.id.ivUser)
    private val tvUserName = itemView.findViewById<TextView>(R.id.tvUserName)

    init {
        itemView.setOnClickListener { listener.onUserPressed(adapterPosition) }
    }

    fun bind(user: User) {
        Picasso.get().load(user.profilePicture).into(ivUser)
        tvUserName.text = user.name
    }
}