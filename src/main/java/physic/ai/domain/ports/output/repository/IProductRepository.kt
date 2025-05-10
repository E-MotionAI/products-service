package physic.ai.domain.ports.output.repository

import physic.ai.infrastructure.persistency.entities.ProductEntity

interface IProductRepository {
    fun getAllProducts(user: String, active: Boolean?): List<ProductEntity>
    fun getAllProductsByUser(user: String): List<ProductEntity>
    fun getProductProfile(name: String): ProductEntity?
    fun registerProduct(user: ProductEntity)
    fun unregisterProduct(name: String): ProductEntity?
    fun updateProductProfile(name: String, premium: Boolean?): ProductEntity?
}