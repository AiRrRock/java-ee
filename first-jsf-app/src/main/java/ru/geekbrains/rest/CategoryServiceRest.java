package ru.geekbrains.rest;

import ru.geekbrains.service.CategoryRepr;
import ru.geekbrains.service.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface CategoryServiceRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<CategoryRepr> findAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    CategoryRepr findById(@PathParam("id") Long id);

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    Long countAll();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(CategoryRepr category);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(CategoryRepr category);

    @DELETE
    @Path("/{id}")
    void deleteById(Long id);
}
