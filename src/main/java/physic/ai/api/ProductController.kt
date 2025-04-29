package physic.ai.api

import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response
import physic.ai.api.dto.ProductUpdatedDto
import physic.ai.domain.ProductEntity
import physic.ai.services.ProductService

@Path("/api/v1/products")
class ProductController {
    @Inject
    @field: Default
    lateinit var productService: ProductService

    @GET
    fun getAllProducts(): Response =
        Response.ok(productService.getAllProducts()).build()

    @GET
    @Path("/{name}")
    fun getProductProfile(name: String): Response =
        Response.ok(productService.getProductProfile(name)).build()

    @POST
    fun registerProduct(productEntity: ProductEntity): Response {
        productService.registerProduct(productEntity)
        return Response.status(Response.Status.CREATED.statusCode).build()
    }

    @PUT
    fun updateProduct(productUpdatedDto: ProductUpdatedDto): Response {
        val (username, email, premium) = productUpdatedDto
        productService.updateProductProfile(username, premium)
        return Response.noContent().build()
    }

    @DELETE
    fun unregisterProduct(username: String): Response {
        productService.unregisterProduct(username)
        return Response.noContent().build()
    }

}