package com.app.service.products;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.GlobalException.CurrentUserException;
import com.app.GlobalException.ProductExcpetion;
import com.app.dao.CurrentUserSeesionDao;
import com.app.dao.ProductDao;
import com.app.model.Products;

public class ProductServiceImpl implements ProductsSerive {
	
	@Autowired
	private CurrentUserSeesionDao currentuserdao;
	
	@Autowired
	private ProductDao productdao;
	
	@Override
	public Products AddNewProduct(String uuid, Products product) throws ProductExcpetion, CurrentUserException {
		if(null==currentuserdao.findByUuid(uuid)) {
			throw new CurrentUserException(" User Is Not Login Please Login first ");
		}
		
		return productdao.save(product);
	}

}
