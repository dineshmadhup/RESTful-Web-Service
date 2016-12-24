package org.dinesh.softarica.productService.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
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
import org.dinesh.softarica.productService.resources.bean.ProductFilterBean;
import org.dinesh.softarica.productService.service.ProductService;

@Path("/products")
/* Adding Produces and Consumes annotation on class level */
/* do not require at each individual method */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	ProductService productService = new ProductService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getJsonProduct(@BeanParam ProductFilterBean filterBean) {
		System.out.println("Json method is called");
		if(filterBean.getYear() > 0) {
			return productService.getAllProductsForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >=0 && filterBean.getSize() > 0) {
			return productService.getAllProductsPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return productService.getAllProducts();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Product> getXmlProduct(@BeanParam ProductFilterBean filterBean) {
		System.out.println("Json method is called");
		if(filterBean.getYear() > 0) {
			return productService.getAllProductsForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >=0 && filterBean.getSize() > 0) {
			return productService.getAllProductsPaginated(filterBean.getStart(), filterBean.getSize());
		}
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
