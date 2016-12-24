package org.dinesh.softarica.productService.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.dinesh.softarica.productService.database.DatabaseClass;
import org.dinesh.softarica.productService.model.Product;

public class ProductService {

	// Creating MAP with Key Long and value Product
	private Map<Long, Product> myProducts = DatabaseClass.getProduct();
	
	// No-arg constructor
	public ProductService() {

		myProducts.put(1L, new Product(1, "IPhone7", "900"));
	}

	public List<Product> getAllProducts() {
		return new ArrayList<Product>(myProducts.values());
	}

	 public Product getProduct(long id) {
	 return myProducts.get(id);
	 }
	 
	 //Filtering based on year
	 public List<Product> getAllProductsForYear(int year) {
		 List<Product> productsForYear = new ArrayList<>();
		 Calendar cal = Calendar.getInstance();
		 for(Product product: myProducts.values()) {
			 cal.setTime(product.getCreated());
			 if(cal.get(Calendar.YEAR) == year) {
				 productsForYear.add(product); 
			 }
		 }
		 return productsForYear;
	 }
	 
	 // Pagination
	 public List<Product> getAllProductsPaginated(int start, int size) {
		 ArrayList<Product> list = new ArrayList<Product>(myProducts.values());
		 if(start + size > list.size())
			 return new ArrayList<Product>();
		 return list.subList(start, start + size);
	 }
	
	
	// Create operation
	public Product addProduct(Product product) {
		product.setPid(myProducts.size() + 1);
		myProducts.put(product.getPid(), product);
		return product;
	}
	
	// Update Product
	public Product updateProduct(Product product) {
		if(product.getPid() <= 0) {
			return null;
		}
		myProducts.put(product.getPid(), product);
		return product;
	}
	

	// Delete Operation
	public Product removeProduct(long pid) {
		return myProducts.remove(pid);
	}
	
	
	

}