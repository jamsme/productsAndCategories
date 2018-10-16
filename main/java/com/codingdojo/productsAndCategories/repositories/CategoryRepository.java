package com.codingdojo.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productsAndCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long>{
	
	List<Category> findAll();

}
