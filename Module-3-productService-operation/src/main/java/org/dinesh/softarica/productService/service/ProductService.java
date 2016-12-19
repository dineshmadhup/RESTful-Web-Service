package org.dinesh.softarica.productService.service;

import java.util.ArrayList;
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

	// public Product getProduct(long id) {
	// return myProducts.get(id);
	// }

}