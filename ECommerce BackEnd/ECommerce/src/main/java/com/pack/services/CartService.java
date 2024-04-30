package com.pack.services;

import java.util.List;

import com.pack.response.UserCartResponse;

public interface CartService {

//	public Cart addToCart(Cart cart);
//	public List<Cart> items();
	
	public void addToCart(Long productId, Long userId);
	 List<UserCartResponse > getCartByUser(Long userId);
	
	
}
