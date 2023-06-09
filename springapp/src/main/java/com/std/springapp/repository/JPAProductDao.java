package com.std.springapp.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.std.springapp.domain.Product;

@Repository(value = "productDao")
public class JPAProductDao implements ProductDao {
	
	private EntityManager em = null;
	
	@PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	@Transactional(readOnly = true)
	public List<Product> getProductList() {
		
				
		return em.createQuery("select p from Product p order by p.id",Product.class).getResultList();			
		//return em.createNativeQuery("select p.* from products p order by p.id",Product.class).getResultList();
		
		
	}

	@Override
	@Transactional(readOnly = false)
	public void saveProduct(Product prod) {
		em.merge(prod);
		
	}

}
