package com.fastcampus.jblog.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOMyBatis implements UserDAO{

    @Autowired
    private SqlSessionTemplate myBatis;

    public UserVO getUser(UserVO vo) {
        System.out.println("mybatis로 실행");
        return (UserVO) myBatis.selectOne("UserDAO.getUser", vo);
    }
}
