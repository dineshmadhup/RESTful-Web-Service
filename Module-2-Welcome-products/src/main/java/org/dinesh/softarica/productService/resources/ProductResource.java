package org.dinesh.softarica.productService.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/products")
public class ProductResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProducts() {
		return "Welcome Products";
	}

}
