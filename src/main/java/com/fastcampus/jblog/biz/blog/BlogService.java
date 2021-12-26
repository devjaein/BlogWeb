package com.fastcampus.jblog.biz.blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

	void insertBlog(BlogVO vo);

	void updateBlog(BlogVO vo);
	
	void deleteBlog(int blogId);

	void deleteRequest(BlogVO vo);

	BlogVO getBlog(BlogVO vo);

	List<BlogVO> getBlogList(BlogVO vo);

}
