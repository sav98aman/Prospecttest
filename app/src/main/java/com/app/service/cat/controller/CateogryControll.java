package com.app.service.cat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Category;
import com.app.service.category.CateogryServiceImpl;

@RestController
@RequestMapping(value = "category")
public class CateogryControll {
	
	@Autowired
	private CateogryServiceImpl cateservicimpl;
	
	@PostMapping(value = "/{uuid}/{CatName}")
	public ResponseEntity<Category> createNewCategory(@PathVariable String uuid,@PathVariable String CatName){
//		cateservicimpl.AddNewCategory(uuid, CatName);
		return new ResponseEntity<Category>(cateservicimpl.AddNewCategory(uuid, CatName),HttpStatus.CREATED);
	}
	
}
