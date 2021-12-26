package com.fastcampus.jblog.biz.post;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOMyBatis implements PostDAO{

    @Autowired
    private SqlSessionTemplate myBatis;

    public void insertPost(PostVO vo) {
        myBatis.insert("PostDAO.insertPost", vo);
    }

    public void updatePost(PostVO vo) {
        myBatis.update("PostDAO.updatePost", vo);
    }

    public void deletePost(PostVO vo) {
        myBatis.delete("PostDAO.deletePost", vo);
    }

    public PostVO getPost(PostVO vo) {
        return (PostVO) myBatis.selectOne("PostDAO.getPost", vo);
    }

    public List<PostVO> getPostList(PostVO vo) {
        return myBatis.selectList("PostDAO.getPostList", vo);
    }
}
