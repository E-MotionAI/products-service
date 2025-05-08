package physic.ai.api

import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.Response
import physic.ai.domain.products.dto.NewProductDto
import physic.ai.domain.products.dto.ProductUpdatedDto
import physic.ai.services.ProductService

@Path("/api/v1/products")
class ProductController {
    @Inject
    @field: Default
    lateinit var productService: ProductService

    @GET
    @Path("/{user}")
    fun getAllProducts(@PathParam("user") user: String, @QueryParam("active") active: Boolean?): Response =
        Response.ok(productService.getAllProducts(user, active)).build()

    @GET
    @Path("/{name}")
    fun getProductProfile(name: String): Response =
        Response.ok(productService.getProductProfile(name)).build()

    @POST
    fun registerProduct(newProduct: NewProductDto): Response {
        productService.registerProduct(newProduct)
        return Response.status(Response.Status.CREATED.statusCode).build()
    }

    @PUT
    fun updateProduct(productUpdatedDto: ProductUpdatedDto): Response {
        val (name, premium) = productUpdatedDto
        productService.updateProductProfile(name, premium)
        return Response.noContent().build()
    }

    @DELETE
    fun unregisterProduct(username: String): Response {
        productService.unregisterProduct(username)
        return Response.noContent().build()
    }

}