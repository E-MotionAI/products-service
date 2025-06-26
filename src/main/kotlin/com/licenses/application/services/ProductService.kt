package com.licenses.application.services

import io.quarkus.logging.Log
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import com.licenses.application.dto.NewProductDto
import com.licenses.application.dto.NewUserDto
import com.licenses.application.dto.ProductMapper
import com.licenses.application.dto.ProductResponseDto
import com.licenses.application.dto.UserMapper
import com.licenses.infrastructure.persistency.entities.ProductEntity
import com.licenses.domain.ports.output.repository.IProductRepository
import com.licenses.domain.exceptions.ProductNotFoundException
import com.licenses.domain.exceptions.UserNotFoundException
import com.licenses.domain.ports.output.repository.IUserRepository

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

    fun getAllProducts(user: String, product: String?, active: Boolean?): List<ProductResponseDto> {
        var productEntities: List<ProductEntity>

        if(product == null) {
            Log.info("Getting all products")
            productEntities = userRepository.getUser(user)?.getProducts() ?: throw UserNotFoundException(user)
        }else {
            Log.info("Getting product by name: $product")
            val userEntity = userRepository.getUser(user) ?: throw UserNotFoundException(user)
            val productEntity = userEntity.getProducts().find { it.getName() == product } ?: throw ProductNotFoundException(product)
            productEntities = listOf(productEntity)
        }
        return productMapper.toProductResponseListDto(productEntities)
    }

    fun registerProduct(user: String, newProduct: NewProductDto) {
        Log.info("User $user registering product name: ${newProduct.name}")
        val targetUserEntity = userRepository.getUser(user)
            ?: throw UserNotFoundException(user)
        val user = userMapper.toUser(targetUserEntity)
        val product = productMapper.toProduct(newProduct)
        user.registerNewProduct(product)
        val productEntity = productMapper.toProductEntity(product)
        productEntity.setUser(targetUserEntity)
        return productRepository.persistProduct(productEntity)
    }

    fun registerUser(newUser: NewUserDto) {
        Log.info("Registering user name: ${newUser.name}")
        val user = userMapper.toUser(newUser)
        return userRepository.persistUser(userMapper.toUserEntity(user))
    }

    fun unregisterProduct(user: String, productName: String) {
        Log.info("Unregistering product name: $user")
        val userEntity = userRepository.getUser(user) ?: throw UserNotFoundException(user)
        val productEntity = userEntity.getProducts().find { it.getName() == productName } ?: throw ProductNotFoundException(productName)
        if (productEntity.isActive())
            throw IllegalStateException("Product $productName is already inactive")
        productEntity.setActive(false)
        return productRepository.persistProduct(productEntity)
    }

    fun updateProductProfile(name: String, premium: Boolean?): ProductEntity? {
        Log.info("Updating product name: $name")
        return productRepository.updateProductProfile(name, premium)?: throw ProductNotFoundException(name)
    }
}