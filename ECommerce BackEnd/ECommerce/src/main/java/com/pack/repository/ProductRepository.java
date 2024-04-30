package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
