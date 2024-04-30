package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entities.Products;
import com.pack.services.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<Products> addProducts(@RequestBody Products products) {

		Products data = productService.addProducts(products);

		return new ResponseEntity<>(data, HttpStatus.CREATED);

	}

	@GetMapping("/all")
	 
	public ResponseEntity<List<Products>> getAllProducts() {

		List<Products> data = productService.getAllProducts();

		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{pid}")
	 
	public ResponseEntity<Products> getProductBtId(@PathVariable(name = "pid") Long pid) {

		Products data = productService.getProductById(pid);

		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/{pid}")
	 
	public ResponseEntity<Products> updateProduct(@PathVariable(name = "pid") Long pid,
			@RequestBody Products updatedProduct) {

		Products data = productService.updateProducts(pid, updatedProduct);

		System.out.println(data);

		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/{pid}")
	 public ResponseEntity<String> deleteProduct(@PathVariable(name = "pid") Long pid  ){
			
		  return new ResponseEntity<String>(productService.deleteProduct(pid),HttpStatus.OK);
		
		
	}

}