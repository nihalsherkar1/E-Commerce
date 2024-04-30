package com.pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entities.Cart;
import com.pack.entities.Products;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByProductId(Long productId);
	List<Cart> findAllByUserId(Long userId);
}
