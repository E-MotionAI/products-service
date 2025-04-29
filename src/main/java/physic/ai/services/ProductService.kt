package physic.ai.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import physic.ai.domain.ProductEntity
import physic.ai.domain.contracts.IProductDao
import physic.ai.services.exceptions.ProductNotFoundException

@ApplicationScoped
class ProductService {

    @Inject
    @field: Default
    lateinit var productDao: IProductDao

    fun getAllProducts(): List<ProductEntity> {
        return productDao.getAllProducts()
    }

    fun getProductProfile(name: String): ProductEntity? {
         return productDao.getProductProfile(name)?: throw ProductNotFoundException(name)
    }

    fun registerProduct(productEntity: ProductEntity) {
        return productDao.registerProduct(productEntity)
    }

    fun updateProductProfile(name: String, premium: Boolean?): ProductEntity? {
        return productDao.updateProductProfile(name, premium)?: throw ProductNotFoundException(name)
    }

    fun unregisterProduct(name: String): ProductEntity? {
        return productDao.unregisterProduct(name)?: throw ProductNotFoundException(name)
    }
}