package com.licenses.domain.ports.output.repository

import com.licenses.infrastructure.persistency.entities.ProductEntity

interface IProductRepository {
    fun getAllProducts(user: String, active: Boolean?): List<ProductEntity>
    fun getAllProductsByUser(user: String): List<ProductEntity>
    fun getProductProfile(name: String): ProductEntity?
    fun persistProduct(user: ProductEntity)
    fun unregisterProduct(name: String): ProductEntity?
    fun updateProductProfile(name: String, premium: Boolean?): ProductEntity?
}