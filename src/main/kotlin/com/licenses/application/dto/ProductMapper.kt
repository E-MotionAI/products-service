package com.licenses.application.dto

import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import com.licenses.domain.model.Product
import com.licenses.infrastructure.persistency.entities.ProductEntity
import org.mapstruct.Mapping

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProductMapper {
    fun toProductEntity(newProduct: NewProductDto): ProductEntity
    fun toProductEntity(product: Product): ProductEntity
    fun toProduct(newProduct: NewProductDto): Product

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "avatarLabel", constant = "PO")
    @Mapping(target = "description", constant = "Plugin for google chrome.")
    @Mapping(target = "subscribers", constant = "100")
    @Mapping(target = "trend", constant = "up")
    @Mapping(target = "trendPercentage", constant = "0.12")
    fun toProductResponseDto(productEntity: ProductEntity): ProductResponseDto
    fun toProductResponseListDto(productEntities: List<ProductEntity>): List<ProductResponseDto>
}
