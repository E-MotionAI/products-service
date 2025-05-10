package physic.ai.application.services

import io.quarkus.logging.Log
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import physic.ai.application.dto.NewProductDto
import physic.ai.application.dto.ProductMapper
import physic.ai.application.dto.UserMapper
import physic.ai.infrastructure.persistency.entities.ProductEntity
import physic.ai.domain.ports.output.repository.IProductRepository
import physic.ai.domain.exceptions.ProductNotFoundException
import physic.ai.domain.exceptions.UserNotFoundException
import physic.ai.domain.ports.output.repository.IUserRepository
import physic.ai.domain.service.IProductsManagement

@ApplicationScoped
class ProductService {
    @Inject
    @field: Default
    lateinit var productRepository: IProductRepository

    @Inject
    @field: Default
    lateinit var userRepository: IUserRepository

    @Inject
    lateinit var productMapper: ProductMapper

    @Inject
    lateinit var userMapper: UserMapper

    fun getAllProducts(user: String, active: Boolean?): List<ProductEntity> {
        Log.info("Getting all products")
        return productRepository.getAllProducts(user, active)
    }

    fun getProductProfile(user: String, name: String): ProductEntity? {
        Log.info("Getting product by name: $name")
        return productRepository.getProductProfile(name)?: throw ProductNotFoundException(name)
    }

    fun registerProduct(user: String, newProduct: NewProductDto) {
        Log.info("User $user registering product name: ${newProduct.name}")
        val targetUserEntity = userRepository.getUser(user)
            ?: throw UserNotFoundException(user)
        val user = userMapper.toUser(targetUserEntity)
        val product = productMapper.toProduct(newProduct)
        user.addProduct(product)
        return userRepository.persistUser(userMapper.toUserEntity(user))
    }

    fun updateProductProfile(name: String, premium: Boolean?): ProductEntity? {
        Log.info("Updating product name: $name")
        return productRepository.updateProductProfile(name, premium)?: throw ProductNotFoundException(name)
    }

    fun unregisterProduct(name: String): ProductEntity? {
        Log.info("Unregistering product name: $name")
        return productRepository.unregisterProduct(name)?: throw ProductNotFoundException(name)
    }
}