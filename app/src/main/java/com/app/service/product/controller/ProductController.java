package com.app.service.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.GlobalException.CurrentUserException;
import com.app.GlobalException.ProductExcpetion;
import com.app.model.Products;
import com.app.service.products.ProductServiceImpl;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl prserImpl;
	
	@PostMapping(value = "/{uuid}")
	public ResponseEntity<Products> add_newProducthandller(@PathVariable String uuid,@RequestBody Products product) throws ProductExcpetion, CurrentUserException{
		
		return new ResponseEntity<Products>(prserImpl.AddNewProduct(uuid, product),HttpStatus.CREATED);
	}
}
