package com.fastcampus.jblog.controller.blog;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthScrollPaneUI;

import com.fastcampus.jblog.biz.post.PostService;
import com.fastcampus.jblog.biz.post.PostVO;
import com.fastcampus.jblog.biz.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.category.CategoryService;
import com.fastcampus.jblog.biz.category.CategoryVO;
import com.fastcampus.jblog.biz.user.UserVO;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import java.util.List;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired 
	private CategoryService categoryService;

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;
	
	// 인덱스 페이지에 대한 요청 처리
	@RequestMapping("/")
	public String index() {
		return "forward:/index.jsp";
	}
	
	@RequestMapping("insertBlogView.do")
	public String inserBlogView(BlogVO vo) {
		return "blogcreate";
	}
	
	@RequestMapping("insertBlog.do")
	public String insertBlog(BlogVO blogVO, CategoryVO categoryVO, HttpSession session) {
		blogService.insertBlog(blogVO);
		BlogVO blog = blogService.getBlog(blogVO);
		session.setAttribute("blog", blog);
		categoryVO.setDisplayType("MIXED");
		categoryVO.setCategoryName("미분류");
		categoryVO.setCntDisplayPost(5);
		categoryVO.setDescription("기본 카테고리");
		categoryService.insertCategory(categoryVO);
		System.out.println("블로그 등록");
		return "forward:/";
	}

	@RequestMapping("/blogmain.do")
	public String blogMain(BlogVO blogVO, CategoryVO categoryVO, PostVO postVO, HttpSession session, Model model) {
		// 내 블로그 가기를 통해 접근한 경우
		if (blogVO.getBlogId() == 0) {
			BlogVO blog = (BlogVO) session.getAttribute("blog");
			blogVO.setBlogId(blog.getBlogId());
			categoryVO.setBlogId(blog.getBlogId());
			postVO.setBlogId(blog.getBlogId());
		}

		BlogVO blog = blogService.getBlog(blogVO);
		model.addAttribute("blog", blog);

		if(postVO.getTitle() != null) {
			postVO.setCategoryId(0);
			categoryVO.setCategoryId(0);
		}

		if(categoryVO.getCategoryId() != 0 ) {
			postVO.setCategoryId(categoryVO.getCategoryId());
		}

		List<PostVO> postList = postService.getPostList(postVO);
		model.addAttribute("postList", postList);

		List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
		model.addAttribute("categoryList", categoryList);

		CategoryVO category = categoryService.getCategory(categoryVO);
		model.addAttribute("category", category);

		System.out.println("blog = " + blog);
		return "blogmain";
	}

	@RequestMapping("/deleteRequest.do")
	public String deleteRequest(BlogVO vo) {
		BlogVO blog = blogService.getBlog(vo);
		if (blog.getStatus().equals("운영")) {
			blog.setStatus("삭제요청");
		} else if (blog.getStatus().equals("삭제요청")){
			blog.setStatus("운영");
		}
		blogService.deleteRequest(blog);
		return "forward:/logout.do";
	}

	@RequestMapping("/updateBlog.do")
	public String updateBlog(BlogVO vo) {
		blogService.updateBlog(vo);
		BlogVO blog = blogService.getBlog(vo);
//		session.setAttribute("blog", blog);
//		System.out.println(blog.getBlogId());
		return "forward:/blogmain.do";
	}

	@RequestMapping("deleteBlog.do")
	public String deleteBlog(BlogVO vo) {
		blogService.deleteBlog(vo.getBlogId());
		return "forward:/getBlogList.do";
	}
	
	@RequestMapping("blogadmin.do")
	public String blogAdmin(BlogVO vo, Model model) {
		BlogVO blog = blogService.getBlog(vo);
		model.addAttribute("blog", blog);
		return "blogadmin_basic";
	}
	
	@RequestMapping("/getBlogList.do")
	public String getBlogList(BlogVO vo, HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		if(user == null) {
			return "bloglogin";
		} else {
			//Null Check
//			if (vo.getSearchCondition() == null) return vo.setSearchCondition("TITLE");
//			if (vo.getSearchKeyword() == null) return vo.setSearchKeyword("");
			session.setAttribute("blogList", blogService.getBlogList(vo));
			session.setAttribute("search", vo);

			System.out.println("blogList = " + blogService.getBlogList(vo));
			return "forward:/";
		}
	}

}
