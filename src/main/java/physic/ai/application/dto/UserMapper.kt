package physic.ai.application.dto

import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import physic.ai.domain.model.User
import physic.ai.infrastructure.persistency.entities.UserEntity

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper {
    fun toUser(user: UserEntity): User
    fun toUserEntity(user: User): UserEntity
}
