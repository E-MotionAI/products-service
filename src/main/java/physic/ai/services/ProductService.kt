package physic.ai.services

import io.quarkus.logging.Log
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import physic.ai.domain.products.dto.NewProductDto
import physic.ai.domain.products.dto.ProductMapper
import physic.ai.domain.products.ProductEntity
import physic.ai.domain.products.contracts.IProductDao
import physic.ai.services.exceptions.ProductNotFoundException

@ApplicationScoped
class ProductService {

    @Inject
    @field: Default
    lateinit var productDao: IProductDao

    @Inject
    lateinit var productMapper: ProductMapper

    fun getAllProducts(user: String, active: Boolean?): List<ProductEntity> {
        Log.info("Getting all products")
        return productDao.getAllProducts(user, active)
    }

    fun getProductProfile(name: String): ProductEntity? {
        Log.info("Getting product by name: $name")
        return productDao.getProductProfile(name)?: throw ProductNotFoundException(name)
    }

    @Transactional
    fun registerProduct(newProduct: NewProductDto) {
        Log.info("Registering product name: ${newProduct.name}")
        val productEntity = productMapper.toProductEntity(newProduct)
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