package com.example.tictrac.data.database

import com.example.tictrac.domain.boundaries.repository.UserRepository
import com.example.tictrac.domain.entity.User
import io.reactivex.Completable
import io.reactivex.Single

// TODO implement
class DefaultUsersRepository : UserRepository {

    override fun getAll(): Single<List<User>> {
        return Single.just(listOf())
    }

    override fun saveAll(users: List<User>): Completable {
        return Completable.complete()
    }

}