package physic.ai.services

import io.quarkus.logging.Log
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
        Log.info("Getting all products")
        return productDao.getAllProducts()
    }

    fun getProductProfile(name: String): ProductEntity? {
        Log.info("Getting product by name: $name")
        return productDao.getProductProfile(name)?: throw ProductNotFoundException(name)
    }

    fun registerProduct(productEntity: ProductEntity) {
        Log.info("Registering product name: ${productEntity.getName()}")
        return productDao.registerProduct(productEntity)
    }

    fun updateProductProfile(name: String, premium: Boolean?): ProductEntity? {
        Log.info("Updating product name: $name")
        return productDao.updateProductProfile(name, premium)?: throw ProductNotFoundException(name)
    }

    fun unregisterProduct(name: String): ProductEntity? {
        Log.info("Unregistering product name: $name")
        return productDao.unregisterProduct(name)?: throw ProductNotFoundException(name)
    }
}