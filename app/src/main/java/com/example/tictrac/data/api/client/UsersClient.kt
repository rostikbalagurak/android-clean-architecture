package com.example.tictrac.data.api.client

import com.example.tictrac.domain.entity.User
import io.reactivex.Single
import retrofit2.http.GET

interface UsersClient {

    @GET("/tmp/users.json")
    fun users(): Single<List<User>>
}