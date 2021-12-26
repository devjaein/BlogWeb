package com.fastcampus.jblog.controller.user;

import javax.servlet.http.HttpSession;

import com.fastcampus.jblog.biz.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.fastcampus.jblog.biz.blog.BlogService;
import com.fastcampus.jblog.biz.blog.BlogVO;
import com.fastcampus.jblog.biz.user.UserService;
import com.fastcampus.jblog.biz.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/loginView.do")
	public String loginView() {
		return "bloglogin";
	}
	
	@RequestMapping("/login.do")
	public String login(UserVO UserVO, HttpSession session, BlogVO blogVO) {
		UserVO user = userService.getUser(UserVO);
		if (user != null) {
			// 로그인 성공한 경우 세션에 사용자 정보를 저장한다.
			session.setAttribute("user", user);
			// TO DO : 로그인 성공한 사용자가 블로그를 소유한 사용자인지 조회하여 세션에 등록한다.
			blogVO.setBlogId(user.getUserId());
			BlogVO blog = blogService.getBlog(blogVO);
			session.setAttribute("blog", blog);
			return "forward:/";
		}
		// 인덱스 페이지로 이동한다.
		return "redirect:/";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
