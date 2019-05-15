package com.example.tictrac.domain.boundaries.repository

import com.example.tictrac.domain.entity.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserRepository {

    fun getAll(): Single<List<User>>

    fun saveAll(users: List<User>): Completable
}