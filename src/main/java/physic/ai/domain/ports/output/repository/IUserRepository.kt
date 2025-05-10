package physic.ai.domain.ports.output.repository

import physic.ai.infrastructure.persistency.entities.UserEntity

interface IUserRepository {
    fun getUser(name: String): UserEntity?
    fun persistUser(user: UserEntity)
}