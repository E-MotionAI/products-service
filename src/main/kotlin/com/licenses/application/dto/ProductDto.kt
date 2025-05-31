package com.licenses.application.dto

data class ProductUpdatedDto(var name: String = "", var premium: Boolean? = false )
data class NewProductDto(var name: String = "")
data class ProductResponseDto(var id: Long,
                              var name: String = "",
                              var avatarLabel: String,
                              var description: String,
                              var subscribers: Int,
                              var trend: String,
                              var trendPercentage: Double,
                              var isPremium: Boolean = false)