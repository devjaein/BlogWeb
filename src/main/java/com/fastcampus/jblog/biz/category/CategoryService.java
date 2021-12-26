package com.fastcampus.jblog.biz.category;

import java.util.List;

public interface CategoryService {

	void insertCategory(CategoryVO vo);

	void updateCategory(CategoryVO vo);

	void deleteCategory(int categoryId);

	CategoryVO getCategory(CategoryVO vo);

	List<CategoryVO> getCategoryList(CategoryVO vo);

}