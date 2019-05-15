package com.example.tictrac.domain.entity

import java.io.Serializable

data class User(
    val profilePicture: String,
    val email: String,
    val name: String,
    val infos: String
) : Serializable