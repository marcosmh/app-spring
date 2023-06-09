package com.std.springapp.service;

import java.util.List;

import com.std.springapp.domain.Product;

public interface ProductManager {
	
	 public void increasePrice(int percentage);
	    
	 public List<Product> getProducts();


}
