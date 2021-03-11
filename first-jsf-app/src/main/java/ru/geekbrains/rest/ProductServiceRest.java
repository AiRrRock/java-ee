package ru.geekbrains.rest;

import ru.geekbrains.service.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface ProductServiceRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findById(@PathParam("id") Long id);

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findByName(@PathParam("name") String name);


    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    Long countAll();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductRepr product);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductRepr product);

    @GET
    @Path("/{id}/{categoryId}")
    void addCategoryById(@PathParam("id") Long id, @PathParam("categoryId") Long id2);

    @DELETE
    @Path("/{id}")
    void deleteById(Long id);
}
