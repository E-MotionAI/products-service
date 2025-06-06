package com.licenses.application.dto

import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import com.licenses.domain.model.User
import com.licenses.infrastructure.persistency.entities.UserEntity
import org.mapstruct.Mapping

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper {

    @Mapping(target = "userId", source = "id")
    fun toUser(user: UserEntity): User

    @Mapping(target = "products", expression = "java(new java.util.ArrayList<>())")
    @Mapping(target = "status", constant = "CREATED")
    fun toUser(user: NewUserDto): User

    @Mapping(target = "id", source = "userId")
    fun toUserEntity(user: User): UserEntity
}
