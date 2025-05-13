package com.licenses.application.dto

import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import com.licenses.domain.model.Product
import com.licenses.infrastructure.persistency.entities.ProductEntity

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProductMapper {
    fun toProductEntity(newProduct: NewProductDto): ProductEntity
    fun toProductEntity(product: Product): ProductEntity
    fun toProduct(newProduct: NewProductDto): Product
    fun toProductResponseDto(productEntity: ProductEntity): ProductResponseDto
    fun toProductResponseListDto(productEntities: List<ProductEntity>): List<ProductResponseDto>
}
