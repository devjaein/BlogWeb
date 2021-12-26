package com.fastcampus.jblog.biz.blog;

import java.util.List;
import java.util.Map;

public interface BlogDAO {
    //	블로그 삭제 요청
    void deleteRequest(BlogVO vo);

    //	블로그 생성
    void insertBlog(BlogVO vo);

    // 블로그 수정
    void updateBlog(BlogVO vo);

    // 블로그 삭제
    void deleteBlog(int blogId);

    //	블로그 조회
    BlogVO getBlog(BlogVO vo);

    //블로그 목록 조회
    List<BlogVO> getBlogList(BlogVO vo);
}
