package physic.ai.domain

import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import physic.ai.domain.contracts.IProductDao


@ApplicationScoped
class ProductRepository: PanacheRepository<ProductEntity>, IProductDao {
    override fun getAllProducts(): List<ProductEntity>  = findAll().list()

    override fun getProductProfile(name: String): ProductEntity? {
        return find("name", name).firstResultOptional<ProductEntity>().orElse(null)
    }

    override fun registerProduct(user: ProductEntity) {
        persist(user)
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
}