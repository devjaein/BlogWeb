package com.fastcampus.jblog.biz.blog;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BlogDAOMyBatis implements BlogDAO{

    @Autowired
    private SqlSessionTemplate myBatis;

    public void insertBlog(BlogVO vo) {
        myBatis.insert("BlogDAO.insertBlog", vo);
    }

    public void updateBlog(BlogVO vo) {
        myBatis.update("BlogDAO.updateBlog", vo);
    }

    public void deleteBlog(int blogId) {
        myBatis.delete("BlogDAO.deleteBlog", blogId);
    }

    public void deleteRequest(BlogVO vo) {
        myBatis.update("BlogDAO.deleteRequest", vo);
    }

    public BlogVO getBlog(BlogVO vo) {
        return (BlogVO) myBatis.selectOne("BlogDAO.getBlog", vo);
    }

    public List<BlogVO>getBlogList(BlogVO vo) {
        return myBatis.selectList("BlogDAO.getBlogList", vo);
    }
}
