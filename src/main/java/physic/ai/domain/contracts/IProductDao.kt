package physic.ai.domain.contracts

import physic.ai.domain.ProductEntity

interface IProductDao {
    fun getAllProducts(): List<ProductEntity>
    fun getProductProfile(name: String): ProductEntity?
    fun registerProduct(user: ProductEntity)
    fun unregisterProduct(name: String): ProductEntity?
    fun updateProductProfile(name: String, premium: Boolean?): ProductEntity?
}