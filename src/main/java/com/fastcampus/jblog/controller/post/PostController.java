package com.fastcampus.jblog.controller.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.category.CategoryService;
import com.fastcampus.jblog.biz.category.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.post.PostService;
import com.fastcampus.jblog.biz.post.PostVO;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("blogadmin_postView.do")
	public String categoryView(CategoryVO categoryVO, Model model, HttpSession session) {

		if (categoryVO.getBlogId() == 0) {
			BlogVO blog = (BlogVO) session.getAttribute("blog");
			categoryVO.setBlogId(blog.getBlogId());
		}

		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);

		model.addAttribute("postStatus", "insert");
		return "adminPost";
	}
	
	@RequestMapping("postInsert.do")
	public String postInsert(PostVO postVO, Model model) {
		postService.insertPost(postVO);
		return "forward:/blogmain.do";
	}

	@RequestMapping("postUpdateView.do")
	public String postUpdateView(PostVO postVO, Model model, CategoryVO categoryVO, HttpSession session) {

		if (categoryVO.getBlogId() == 0) {
			BlogVO blog = (BlogVO) session.getAttribute("blog");
			categoryVO.setBlogId(blog.getBlogId());
		}

		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);

		if (postVO.getPostId() != 0) {
			PostVO post = postService.getPost(postVO);
			model.addAttribute("post", post);
			System.out.println(model.getAttribute("post"));
		}

		model.addAttribute("postStatus", "update");
		return "adminPost";
	}

	@RequestMapping("postUpdate.do")
	public String postUpdate(PostVO vo) {
		postService.updatePost(vo);
		return "forward:/blogmain.do";
	}
	
	@RequestMapping("postDelete.do")
	public String postDelete(PostVO vo) {
		postService.deletePost(vo);
		return "forward:/blogmain.do";
	}

}
