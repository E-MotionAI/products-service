package com.licenses.domain.ports.output.repository

import com.licenses.infrastructure.persistency.entities.UserEntity

interface IUserRepository {
    fun getUser(name: String): UserEntity?
    fun persistUser(user: UserEntity)
}