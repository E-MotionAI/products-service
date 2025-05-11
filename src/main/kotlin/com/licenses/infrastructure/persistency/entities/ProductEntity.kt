package com.licenses.infrastructure.persistency.entities

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "products")
open class ProductEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private var productId: Long? = null,
    private var name: String = "",
    private var isPremium: Boolean = false,
    private var isActive: Boolean = false,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private var user: UserEntity? = null
){
    fun setPremium(premium: Boolean) {
        this.isPremium = premium
    }

    fun setActive(active: Boolean) {
        this.isActive = active
    }

    fun isActive() = isActive
    fun isPremium() = isPremium
    fun getName() = name

    fun setName(name: String) {
        this.name = name
    }

    fun setUser(user: UserEntity) {
        this.user = user
    }
}