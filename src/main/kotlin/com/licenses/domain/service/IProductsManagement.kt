package com.licenses.domain.service

import com.licenses.domain.model.Product

interface IProductsManagement {
    fun getAllProducts(user: String, active: Boolean?): List<Product>

    fun getProductProfile(user: String, productName: String): Product?

    fun registerProduct(user: String, newProduct: Product)

    fun updateProductProfile(username: String, product: Product): Product?

    fun unregisterProduct(username: String, productName: String): Product?
}