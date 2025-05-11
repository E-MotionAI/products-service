package com.licenses.infrastructure.persistency.entities

import com.licenses.domain.model.User
import com.licenses.domain.model.UserStatus
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "users")
open class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var userId: Long? = null,
    private var name: String = "",
    @Enumerated(EnumType.STRING)
    private var status: UserStatus = UserStatus.CREATED,
    @OneToMany(mappedBy = "user",
        cascade = [CascadeType.PERSIST],
        orphanRemoval = true,
        fetch = FetchType.LAZY)
    private var products: MutableList<ProductEntity> = mutableListOf()
){
    fun setName(name: String) {
        this.name = name
    }

    fun getName() = name

    fun getStatus() = status

    fun setStatus(status: UserStatus) {
        this.status = status
    }

    fun getProducts(): MutableList<ProductEntity> {
        return products
    }

    fun getId(): Long? {
        return userId
    }

    fun setId(userId: Long?) {
        this.userId = userId
    }

}