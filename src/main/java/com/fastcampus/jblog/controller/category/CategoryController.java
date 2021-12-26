package com.fastcampus.jblog.controller.category;

import javax.servlet.http.HttpSession;

import com.fastcampus.jblog.biz.blog.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.category.CategoryService;
import com.fastcampus.jblog.biz.category.CategoryVO;

import java.util.List;
import java.util.Date;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("blogadmin_categoryView.do")
	public String categoryView(CategoryVO categoryVO, HttpSession session, Model model) {
		if (categoryVO.getBlogId() == 0) {
			BlogVO blog = (BlogVO) session.getAttribute("blog");
			categoryVO.setBlogId(blog.getBlogId());
		}

		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);

		model.addAttribute("categoryStatus", "insert");
		return "blogadmin_category";
	}

	@RequestMapping("deleteCategory.do")
	public String categoryDelete(CategoryVO vo){
		categoryService.deleteCategory(vo.getCategoryId());
		return "forward:/blogadmin_categoryView.do";
	}

	@RequestMapping("insertCategory.do")
	public String categoryInsert(CategoryVO vo) {
		categoryService.insertCategory(vo);
		return "forward:/blogadmin_categoryView.do";
	}

	@RequestMapping("updateCategoryView.do")
	public String categoryUpdateView(CategoryVO vo, Model model, HttpSession session) {

		if (vo.getBlogId() == 0) {
			BlogVO blog = (BlogVO) session.getAttribute("blog");
			vo.setBlogId(blog.getBlogId());
		}

		CategoryVO category = categoryService.getCategory(vo);
		model.addAttribute("category", category);

		List<CategoryVO> categoryList = categoryService.getCategoryList(vo);
		model.addAttribute("categoryList", categoryList);

		model.addAttribute("categoryStatus", "update");
		return "blogadmin_category";
	}
	
	@RequestMapping("updateCategory.do")
	public String categoryUpdate(CategoryVO vo, Model model) {
		categoryService.updateCategory(vo);
		return "forward:/blogadmin_categoryView.do";
	}

}
