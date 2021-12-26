//package com.fastcampus.jblog.biz.category;
//
//import com.fastcampus.jblog.persistence.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CategoryDAOJPA implements CategoryDAO {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Override
//    public void insertCategory(CategoryVO vo) {
//        categoryRepository.save(vo);
//    }
//
//    @Override
//    public void updateCategory(CategoryVO vo) {
//        CategoryVO findCategory = categoryRepository.findById(vo.getCategoryId()).get();
//        findCategory.setCategoryName(vo.getCategoryName());
//        findCategory.setDisplayType(vo.getDisplayType());
//        findCategory.setCntDisplayPost(vo.getCntDisplayPost());
//        findCategory.setDescription(vo.getDescription());
//        categoryRepository.save(vo);
//    }
//
//    @Override
//    public void deleteCategory(int categoryId) {
//        categoryRepository.deleteById(categoryId);
//    }
//
//    @Override
//    public CategoryVO getCategory(CategoryVO vo) {
//        return categoryRepository.findById(vo.getCategoryId()).get();
//    }
//
//    @Override
//    public List<CategoryVO> getCategoryList(CategoryVO vo) {
//        CategoryVO category = categoryRepository.findById(vo.getBlogId()).get();
//        return (List<CategoryVO>) categoryRepository.findAllById((Iterable<Integer>) category);
//    }
//}
