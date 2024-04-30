package com.pack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entities.Products;
import com.pack.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Products addProducts(Products products) {
		 
		return productRepository.save(products);
	}

	@Override
	public List<Products> getAllProducts() {
		
	  List<Products> data =	productRepository.findAll();
		
		return data;
	}

	@Override
	public Products getProductById(Long pid) {
		 
		 Products  data=productRepository.findById(pid).orElse(null);
		
		return data;
	}

	 

	@Override
	public Products updateProducts(Long pid, Products updatedProduct) {
		Products product = productRepository.findById(pid).orElse(null);
		
		if(product != null) {
		    product.setProductname(null);
		    product.setPrice(updatedProduct.getPrice());
		    
		    return productRepository.save(product);
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public String deleteProduct(Long pid) {
		 
       Products data=productRepository.findById(pid).get();
		 
		 if(data != null) {
			 productRepository.delete(data);
			 return "Product Deleted Successfully....";
		 }
		 return "Something went wrong on server....";
		 
		
		 
	}
	
	
}
