package physic.ai.infrastructure.persistency.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import physic.ai.domain.ports.output.repository.IUserRepository
import physic.ai.infrastructure.persistency.entities.UserEntity

class UserRepository: PanacheRepository<UserEntity>,IUserRepository {
    override fun getUser(name: String): UserEntity? =
            find("name", name).firstResultOptional<UserEntity>().orElse(null)

    override fun persistUser(user: UserEntity) = persist(user)

}