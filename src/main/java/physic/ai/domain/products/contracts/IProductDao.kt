package physic.ai.domain.products.contracts

import physic.ai.domain.products.ProductEntity

interface IProductDao {
    fun getAllProducts(user: String, active: Boolean?): List<ProductEntity>
    fun getAllProductsByUser(user: String): List<ProductEntity>
    fun getProductProfile(name: String): ProductEntity?
    fun registerProduct(user: ProductEntity)
    fun unregisterProduct(name: String): ProductEntity?
    fun updateProductProfile(name: String, premium: Boolean?): ProductEntity?
}