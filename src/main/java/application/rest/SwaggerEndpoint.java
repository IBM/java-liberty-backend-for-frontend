package application.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("swagger")
public class SwaggerEndpoint {

    @Path("api")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSwaggerAPI() {
		String swagger = getStringResource("/swagger.yaml");
		if(swagger.isEmpty()) {
			return Response.serverError().build();
		}
		return Response.ok(swagger).build();
    }
	
    //read the description contained in the specified file
    private String getStringResource(String path) {
        InputStream in = getClass().getResourceAsStream(path);

        StringBuilder contents = new StringBuilder();
        char[] buffer = new char[1024];
        int read = 0;
        try (InputStreamReader reader = new InputStreamReader(in)) {
            while ((read = reader.read(buffer)) != -1) {
            	contents.append(buffer, 0, read);
            }
        } catch (IOException e) {
            //just return what we've got
            return contents.toString();
        }
        return contents.toString();
    }

}
