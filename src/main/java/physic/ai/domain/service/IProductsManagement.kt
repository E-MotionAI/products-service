package physic.ai.domain.service

import physic.ai.domain.model.Product
import physic.ai.infrastructure.persistency.entities.ProductEntity

interface IProductsManagement {
    fun getAllProducts(user: String, active: Boolean?): List<Product>

    fun getProductProfile(user: String, productName: String): Product?

    fun registerProduct(user: String, newProduct: Product)

    fun updateProductProfile(username: String, product: Product): Product?

    fun unregisterProduct(username: String, productName: String): Product?
}