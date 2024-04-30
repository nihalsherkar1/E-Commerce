package com.pack.services;

 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entities.Cart;
import com.pack.entities.Products;
import com.pack.repository.CartRepository;
import com.pack.repository.ProductRepository;
import com.pack.response.UserCartResponse;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addToCart(Long productId, Long userId) {
		 
		Cart cart=new Cart();
		cart.setProductId(productId);
		cart.setUserId(userId);
		
		cartRepository.save(cart);
		
	}

	 @Override
	    public List<UserCartResponse> getCartByUser(Long userId) {
	        List<Cart> entities = cartRepository.findAllByUserId(userId);
	        List<UserCartResponse> responses = new ArrayList<>();
	        entities.forEach(cartEntity -> {
	            productRepository.findById(cartEntity.getProductId()).ifPresent(productEntity -> {
	                UserCartResponse cartResponse = new UserCartResponse();
	                cartResponse.setPrice(productEntity.getPrice());
	                cartResponse.setProductName(productEntity.getProductname());
	                responses.add(cartResponse);
	            });
	        });
	        return responses;
	    }
	 

	 

	 

 
	
}
