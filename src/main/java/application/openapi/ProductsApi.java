package application.openapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import application.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/products")

@Api(description = "the products API")
@Consumes({ "text/plain" })
@Produces({ "application/json" })
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2017-03-12T23:51:45.548Z")

public class ProductsApi  {

    @POST

    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "Add new product", response = Product.class, tags={ "products",  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "One product", response = Product.class) })
    public Response add(String productName) {
    	return Response.ok().entity("{}").build();
    }

    @GET

    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "Get all products", response = Product.class, responseContainer = "List", tags={ "products" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "List of all products", response = Product.class, responseContainer = "List") })
    public Response getAll() {
    	return Response.ok().entity("{}").build();
    }
}
