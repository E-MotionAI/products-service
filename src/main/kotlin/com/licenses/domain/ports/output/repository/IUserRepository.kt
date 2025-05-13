package com.licenses.domain.ports.output.repository

import com.licenses.domain.model.Product
import com.licenses.infrastructure.persistency.entities.ProductEntity
import com.licenses.infrastructure.persistency.entities.UserEntity

interface IUserRepository {
    fun getUser(name: String): UserEntity?
    fun persistUser(user: UserEntity)
}