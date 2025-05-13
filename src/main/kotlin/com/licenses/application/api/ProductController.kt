package com.licenses.application.api

import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.Response
import com.licenses.application.dto.NewProductDto
import com.licenses.application.dto.NewUserDto
import com.licenses.application.dto.ProductUpdatedDto
import com.licenses.application.services.ProductService

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
    @Path("/{user}/{name}")
    fun getProductProfile(@PathParam("user") user: String, @PathParam("name") name: String): Response =
        Response.ok(productService.getProductProfileByUser(user, name)).build()

    @POST
    @Path("/{user}")
    @Transactional
    fun registerProduct(@PathParam("user") user: String, newProduct: NewProductDto): Response {
        productService.registerProduct(user, newProduct)
        return Response.status(Response.Status.CREATED.statusCode).build()
    }

    @POST
    @Transactional
    fun registerUser(newUser: NewUserDto): Response {
        productService.registerUser(newUser)
        return Response.status(Response.Status.CREATED.statusCode).build()
    }

    @PUT
    @Transactional
    fun updateProduct(productUpdatedDto: ProductUpdatedDto): Response {
        val (name, premium) = productUpdatedDto
        productService.updateProductProfile(name, premium)
        return Response.noContent().build()
    }

    @DELETE
    @Path("/{user}/{productName}")
    @Transactional
    fun unregisterProduct(@PathParam("user") user: String, @PathParam("productName") productName: String): Response {
        productService.unregisterProduct(user, productName)
        return Response.noContent().build()
    }

}