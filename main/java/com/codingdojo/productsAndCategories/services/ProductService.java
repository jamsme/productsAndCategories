package com.codingdojo.productsAndCategories.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsAndCategories.models.Product;
import com.codingdojo.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
			this.productRepo = productRepo;
	};
	
	// create a Product
	public Product createProduct(Product product) {
		return productRepo.save(product);
	};
	
	// get all of the Products
	public List<Product> allProducts(){
		return productRepo.findAll();
	};
	
	// specific Product
	public Product oneProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	};
	
	// update Product
	public Product update(Product product) {
		product.setUpdatedAt(new Date());
		return productRepo.save(product);
	}
	
}
