package com.licenses.infrastructure.persistency.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import com.licenses.domain.ports.output.repository.IUserRepository
import com.licenses.infrastructure.persistency.entities.UserEntity

@ApplicationScoped
class UserRepository: PanacheRepository<UserEntity>,IUserRepository {
    override fun getUser(name: String): UserEntity? =
            find("name", name).firstResultOptional<UserEntity>().orElse(null)

    override fun persistUser(user: UserEntity) = persist(user)

}