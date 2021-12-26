package com.fastcampus.jblog.biz.category;

import com.fastcampus.jblog.biz.blog.BlogVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOMyBatis implements CategoryDAO{

    @Autowired
    private SqlSessionTemplate myBatis;

    public void insertCategory(CategoryVO vo) {
        myBatis.insert("CategoryDAO.insertCategory", vo);
    }

    public void updateCategory(CategoryVO vo) {
        myBatis.update("CategoryDAO.updateCategory", vo);
    }

    public void deleteCategory(int categoryId) {
        myBatis.delete("CategoryDAO.deleteCategory", categoryId);
    }

    public CategoryVO getCategory(CategoryVO vo) {
        return (CategoryVO) myBatis.selectOne("CategoryDAO.getCategory", vo);
    }

    public List<CategoryVO> getCategoryList(CategoryVO vo) {
        return myBatis.selectList("CategoryDAO.getCategoryList", vo);
    }
}
