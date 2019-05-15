package com.example.tictrac.domain.boundaries.api

import com.example.tictrac.domain.entity.User
import io.reactivex.Single

interface UsersAPI {
    fun getAll(): Single<List<User>>
}