package com.licenses.application.dto

data class ProductUpdatedDto(var name: String = "", var premium: Boolean? = false )
data class NewProductDto(var name: String = "")
data class ProductResponseDto(var productId: Long, var name: String = "", var isPremium: Boolean = false)