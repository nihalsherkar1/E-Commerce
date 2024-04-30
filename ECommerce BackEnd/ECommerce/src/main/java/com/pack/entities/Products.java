package com.pack.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "productname")
	private String productname;
	
	private Double price;
	
	

	 

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Products(Long id, String productname, Double price) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", productname=" + productname + ", price=" + price + "]";
	}
	
//	@OneToMany(mappedBy = "product")
//    private List<Cart> carts;
	

	 

	 

	 

	 
 
	 

	 

	 

	 
	
	
	
}
