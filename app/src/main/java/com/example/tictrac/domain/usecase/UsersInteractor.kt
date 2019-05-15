package com.example.tictrac.domain.usecase

import com.example.tictrac.domain.entity.User
import io.reactivex.Single

interface UsersInteractor {

    fun fetchUsers(): Single<List<User>>

    fun fetchLocalUsers(): Single<List<User>>
}