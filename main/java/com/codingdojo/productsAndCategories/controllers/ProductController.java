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
public class ProductController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	};
	
	// Index page with new product form
	@RequestMapping("/products/new")
	public String index(@ModelAttribute("product") Product product) {
		return "index.jsp";
	};
	
	// creating a Product
	@PostMapping("/product")
	public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("HAVE AN ERROR!!!");
			System.out.println(result);
			return "index.jsp";
		} else {
			System.out.println("going to the other page");
			productService.createProduct(product);
			return "redirect:/products/" + product.getId();
		}
	};
	
	// showing a specific Product with all of the Categories
	@RequestMapping("/products/{id}")
	public String oneProduct(Model model, @PathVariable("id") Long id) {
		Product product = productService.oneProduct(id);
		Product prodsCategories = productService.oneProduct(id);
		List<Category> categories = categoryService.allCategories();
		
		model.addAttribute("product", product);
		model.addAttribute("categories", prodsCategories.getCategories());
		model.addAttribute("allCategories", categories);
		return "showProduct.jsp";
	};
	
	@PostMapping("/addCategory/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam("categories") Long categoryId, @Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/" + id;
		} else {
			Product updateProduct = productService.oneProduct(id);
			Category category = categoryService.oneCategory(categoryId);
			List<Category> categories = updateProduct.getCategories();
			categories.add(category);
			productService.update(updateProduct);
			return "redirect:/products/" + id;
		}
	};

}
