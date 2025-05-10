package physic.ai.infrastructure.persistency.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import physic.ai.infrastructure.persistency.entities.ProductEntity
import physic.ai.domain.ports.output.repository.IProductRepository

@ApplicationScoped
class ProductRepository: PanacheRepository<ProductEntity>, IProductRepository {
    override fun getAllProducts(user: String, active: Boolean?): List<ProductEntity>  = find("user = ?1 and active = ?2", user, active).list()

    override fun getProductProfile(name: String): ProductEntity? =
        find("name", name).firstResultOptional<ProductEntity>().orElse(null)

    override fun registerProduct(product: ProductEntity) {
        persist(product)
    }

    override fun unregisterProduct(name: String): ProductEntity? {
        val productProfile = getProductProfile(name) ?: return null
        productProfile.setActive(false)
        persist(productProfile)
        return productProfile
    }

    override fun updateProductProfile(name: String, premium: Boolean?): ProductEntity? {
        val targetProduct = getProductProfile(name) ?: return null
        premium?.let { targetProduct.setPremium(it) }
        persist(targetProduct)
        return targetProduct
    }

    override fun getAllProductsByUser(user: String): List<ProductEntity>  = findAll().list()

}