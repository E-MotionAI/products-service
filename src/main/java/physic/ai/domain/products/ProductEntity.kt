package physic.ai.domain.products

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
open class ProductEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private var productId: Integer? = null,
    private var name: String = "",
    private var isPremium: Boolean = false,
    private var isActive: Boolean = false
){
    fun setPremium(premium: Boolean) {
        this.isPremium = premium
    }

    fun setActive(active: Boolean) {
        this.isActive = active
    }

    fun isActive() = isActive
    fun isPremium() = isPremium
    fun getName() = name

    fun setName(name: String) {
        this.name = name
    }
}
