package com.std.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.std.springapp.domain.Product;
import com.std.springapp.repository.ProductDao;

//@Service
@Component
public class SimpleProductManager implements ProductManager {
	
    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
	
    	
	@Override
	public List<Product> getProducts() {
		 return productDao.getProductList();
	}
	
	@Override
	public void increasePrice(int percentage) {
        List<Product> products = productDao.getProductList();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                productDao.saveProduct(product);
            }
        }
    }
	
	
	

}
