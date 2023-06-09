package com.std.springapp.repository;

import java.util.List;

import com.std.springapp.domain.Product;

public interface  ProductDao {

	public List<Product> getProductList();

    public void saveProduct(Product prod);
    
}
