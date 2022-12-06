package com.app.service.products;

import com.app.GlobalException.CurrentUserException;
import com.app.GlobalException.ProductExcpetion;
import com.app.model.Products;

public interface ProductsSerive {
	
	public Products AddNewProduct(String uuid ,Products product)throws ProductExcpetion,CurrentUserException;
}
