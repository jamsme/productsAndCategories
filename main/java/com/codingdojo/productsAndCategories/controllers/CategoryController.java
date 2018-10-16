package com.codingdojo.productsAndCategories.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsAndCategories.models.Category;
import com.codingdojo.productsAndCategories.models.Product;
import com.codingdojo.productsAndCategories.services.CategoryService;
import com.codingdojo.productsAndCategories.services.ProductService;

@Controller
public class CategoryController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	};
	
	// Index page with new category form
	@RequestMapping("/categories/new")
	public String index(@ModelAttribute("category") Category category) {
		return "categoryNew.jsp";
	};
	
	@PostMapping("/category")
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("HAVE AN ERROR!!!");
			System.out.println(result);
			return "categoryNew.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/" + category.getId();
		}
	};
	
	@RequestMapping("/categories/{id}")
	public String oneCategory(Model model, @PathVariable("id") Long id) {
		Category category = categoryService.oneCategory(id);
		Category categoriesProds = categoryService.oneCategory(id);
		List<Product> prods = productService.allProducts();
		
		model.addAttribute("category", category);
		model.addAttribute("getProducts", categoriesProds.getProducts());
		model.addAttribute("prods", prods);
		return "showCategory.jsp";
	};
	
	@PostMapping("/addProduct/{id}")
	public String addProduct(@PathVariable("id") Long id, @RequestParam("products") Long prodId, @Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("HAVE AN ERROR!!!");
			System.out.println(result);
			return "redirect:/categories/" + id;
		} else {
			Category updateCategory = categoryService.oneCategory(id);
			Product product = productService.oneProduct(prodId);
			List<Product> products = updateCategory.getProducts();
			products.add(product);
			categoryService.update(updateCategory);
			return "redirect:/categories/" + id;
		}
	};

}
