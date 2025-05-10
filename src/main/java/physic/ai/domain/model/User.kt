package physic.ai.domain.model

data class User(val name: String = "", val products: MutableList<Product>) {

    fun addProduct(product: Product) {
        if(validateNewProduct(product)){
            products.add(product)
        }
    }

    fun validateNewProduct(newProduct: Product): Boolean {
        return true
    }
}