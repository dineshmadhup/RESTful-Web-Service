package org.dinesh.softarica.productService.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dinesh.softarica.productService.model.Product;
import org.dinesh.softarica.productService.service.ProductService;

@Path("/products")
/* Adding Produces and Consumes annotation on class level */
/* do not require at each individual method */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	ProductService productService = new ProductService();
	
	@GET
	//@Produces(MediaType.TEXT_PLAIN)
	public List<Product> getProduct() {
		return productService.getAllProducts();
	}
	
	@GET
	@Path("/{productId}")
	public Product getproduct(@PathParam("productId") long pid) {
		return productService.getProduct(pid);
		
	}
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Product addProduct(Product product) {
		return productService.addProduct(product);
	}
	
	@PUT
	@Path("/{productId}")
	public Product updateProduct(@PathParam("productId") long pid, Product product) {
		product.setPid(pid);
		return productService.updateProduct(product);
	}
	
	@DELETE
	@Path("/{productId}")
	public Product deleteProduct(@PathParam("productId") long pid) {
		return productService.removeProduct(pid);
	}

	


}
