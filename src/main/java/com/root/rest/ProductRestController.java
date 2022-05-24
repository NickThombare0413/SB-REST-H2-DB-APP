package com.root.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.entity.Product;
import com.root.repo.ProductRepository;

@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository repo;

	@PostMapping(value = "/product", consumes = "application/json")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		repo.save(product);
		return new ResponseEntity<String>("product added", HttpStatus.CREATED);

	}

	@GetMapping(value = "/products", produces = "application/json")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> productList = repo.findAll();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
}
