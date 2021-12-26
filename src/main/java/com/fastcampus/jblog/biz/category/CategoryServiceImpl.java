package com.fastcampus.jblog.biz.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public void insertCategory(CategoryVO vo) {
		categoryDAO.insertCategory(vo);
	}

	@Override
	public void updateCategory(CategoryVO vo) {
		categoryDAO.updateCategory(vo);
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryDAO.deleteCategory(categoryId);
	}

	@Override
	public CategoryVO getCategory(CategoryVO vo) {
		return categoryDAO.getCategory(vo);
	}

	@Override
	public List<CategoryVO> getCategoryList(CategoryVO vo) {
		return categoryDAO.getCategoryList(vo);
	}

}
