package physic.ai.services.exceptions

open class ApiException(message: String, val status: Int) : RuntimeException(message)

class ProductNotFoundException(name: String) :
    ApiException("Product '$name' not found", 404)

class InvalidProductStateException(reason: String) :
    ApiException("Invalid product state: $reason", 400)