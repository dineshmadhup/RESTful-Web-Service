package org.dinesh.softarica.productService.database;

import java.util.HashMap;
import java.util.Map;


import org.dinesh.softarica.productService.model.Product;

public class DatabaseClass {
	
	private static Map<Long, Product> myProducts = new HashMap<>();
	
	public static Map<Long, Product>getProduct() {
		return myProducts;
	}

}
