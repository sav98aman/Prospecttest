package com.app.service.category;

import javax.xml.catalog.CatalogException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryDao;
import com.app.dao.CurrentUserSeesionDao;
import com.app.model.Category;

@Service
public class CateogryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao catdao;
	@Autowired
	private CurrentUserSeesionDao curentuserdao;
	@Override
	public Category AddNewCategory(String uuid,String catName) throws CatalogException {
		
		if(null==curentuserdao.findByUuid(uuid)) {
			throw new CatalogException(" user Is Not Login Please Login First");
		}
		
		Category cat=catdao.findByCategoryName(catName);
		if (cat != null) {
			throw new CatalogException(" category Is All reday present ");
		}
		Category newcat =new Category();
		newcat.setCategoryName(catName);
		return catdao.save(newcat);
	}
	
	
}
