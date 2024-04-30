package com.pack.services;

import java.util.List;

import com.pack.entities.Products;

public interface ProductService {

	public Products addProducts(Products products);
	
	public List<Products> getAllProducts();
	
	public Products getProductById(Long pid);
	
	public Products updateProducts(Long pid,Products updatedProduct);
	
	public String deleteProduct(Long pid);
	
}
