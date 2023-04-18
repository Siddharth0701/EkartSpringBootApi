package com.ekart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.dto.ProductData;
import com.ekart.service.ProductServicee;

@RestController
@RequestMapping(value="api/products",produces="application/json")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductServicee productService;

	@GetMapping
	public List<ProductData> findAll() {
		return productService.findAll();
	}

	@GetMapping("{id}")
	public ProductData findById(@PathVariable Long id) {
		return productService.findById(id);

	}

	@PostMapping
	public ProductData create( @Valid @RequestBody ProductData productData) {
		return productService.create(productData);

	}

	@DeleteMapping("{id}")
	public boolean delete(@PathVariable Long id) {
		return productService.delete(id);
	}

	@PutMapping("{id}")
	public boolean updateProduct(@Valid @RequestBody ProductData productData, @PathVariable("id") Long productId) {
		return productService.update(productData, productId);

	}

}
