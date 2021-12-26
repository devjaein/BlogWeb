package com.fastcampus.jblog.biz.category;

import java.util.List;

public interface CategoryDAO {
    void insertCategory(CategoryVO vo);

    void updateCategory(CategoryVO vo);

    void deleteCategory(int categoryId);

    CategoryVO getCategory(CategoryVO vo);

    List<CategoryVO> getCategoryList(CategoryVO vo);
}
