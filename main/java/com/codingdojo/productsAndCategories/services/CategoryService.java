package com.codingdojo.productsAndCategories.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsAndCategories.models.Category;
import com.codingdojo.productsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	};
	
	// create a Category
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	};
	
	// get all of the Categories
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	};
	
	// specific Category
	public Category oneCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	};
	
	// update Category
	public Category update(Category category) {
		category.setUpdatedAt(new Date());
		return categoryRepo.save(category);
	};

}
