package physic.ai.infrastructure.persistency.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "users")
open class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var userId: Long? = null,
    private var name: String = "",
    @OneToMany(mappedBy = "product",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY)
    private var products: MutableList<ProductEntity> = mutableListOf()
)