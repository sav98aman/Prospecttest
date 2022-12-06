package com.app.service.category;

import javax.xml.catalog.CatalogException;

import com.app.model.Category;

public interface CategoryService {
	
	public Category AddNewCategory(String uuid,String catName)throws CatalogException;
}
