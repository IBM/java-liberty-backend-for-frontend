package application.openapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import application.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/product")

@Api(description = "the product API")
@Consumes({ "text/plain" })
@Produces({ "application/json" })
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2017-03-12T23:51:45.548Z")

public class ProductApi  {

    @DELETE
    @Path("/{id}")
    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "Delete product by ID", response = Product.class, tags={ "products",  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "One product", response = Product.class) })
    public Response delete(@PathParam("id") Long id) {
    	return Response.ok().entity("{}").build();
    }

    @GET
    @Path("/{id}")
    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "Get product by ID", response = Product.class, tags={ "products",  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "One product", response = Product.class) })
    public Response get(@PathParam("id") Long id) {
    	return Response.ok().entity("{}").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "Update product by ID", response = Product.class, tags={ "products" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "One product", response = Product.class) })
    public Response update(@PathParam("id") Long id,String productName) {
    	return Response.ok().entity("{}").build();
    }
}
