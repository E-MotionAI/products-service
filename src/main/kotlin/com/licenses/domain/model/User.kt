package com.licenses.domain.model

enum class UserStatus {
    CREATED,
    AWAITING_CONFIRMATION,
    CONFIRMED,
    DEACTIVATED
}

data class User(val userId: Long = 0, val name: String = "", var products: MutableList<Product> = mutableListOf(), var status: UserStatus) {
    init {
        status = UserStatus.CREATED
    }

    fun registerNewProduct(product: Product) {
        if(validateNewProduct(product)){
            products.add(product)
        }
    }

    fun validateNewProduct(newProduct: Product): Boolean {
        return true
    }
}