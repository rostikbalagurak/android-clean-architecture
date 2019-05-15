package com.example.tictrac.domain.usecase.impl

import com.example.tictrac.domain.boundaries.api.UsersAPI
import com.example.tictrac.domain.boundaries.repository.UserRepository
import com.example.tictrac.domain.entity.User
import com.example.tictrac.domain.usecase.UsersInteractor
import io.reactivex.Single

class DefaultUsersInteractor(
    private val userRepository: UserRepository,
    private val usersAPI: UsersAPI
) : UsersInteractor {

    override fun fetchLocalUsers(): Single<List<User>> {
        return userRepository.getAll()
    }

    override fun fetchUsers(): Single<List<User>> {
        return usersAPI.getAll().flatMap {
            userRepository
                .saveAll(it)
                .toSingleDefault(it)
        }
    }
}