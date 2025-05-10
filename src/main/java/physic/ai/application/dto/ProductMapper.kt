package physic.ai.application.dto

import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import physic.ai.domain.model.Product
import physic.ai.infrastructure.persistency.entities.ProductEntity


@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProductMapper {
    fun toProductEntity(newProduct: NewProductDto): ProductEntity
    fun toProduct(newProduct: NewProductDto): Product
}
