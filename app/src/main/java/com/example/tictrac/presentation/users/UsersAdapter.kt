package com.example.tictrac.presentation.users

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tictrac.R
import com.example.tictrac.domain.entity.User

class UsersAdapter(private val listener: InteractionListener) : RecyclerView.Adapter<UserViewHolder>() {

    private val users = mutableListOf<User>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): UserViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_user, viewGroup, false)
        return UserViewHolder(listener, view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {
        viewHolder.bind(users[position])
    }

    fun submitList(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)
        this.notifyDataSetChanged()
    }

    fun get(adapterPosition: Int): User {
        return users[adapterPosition]
    }

    interface InteractionListener {
        fun onUserPressed(adapterPosition: Int)
    }
}
