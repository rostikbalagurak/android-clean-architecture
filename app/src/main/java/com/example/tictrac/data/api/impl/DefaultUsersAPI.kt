package com.example.tictrac.data.api.impl

import com.example.tictrac.data.api.client.UsersClient
import com.example.tictrac.domain.boundaries.api.UsersAPI
import com.example.tictrac.domain.entity.User
import io.reactivex.Single

class DefaultUsersAPI(private val usersClient: UsersClient) : UsersAPI {

    override fun getAll(): Single<List<User>> {
        return usersClient.users()
    }
}