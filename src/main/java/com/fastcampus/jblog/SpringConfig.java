package com.fastcampus.jblog;

import com.fastcampus.jblog.biz.blog.*;
import com.fastcampus.jblog.biz.category.CategoryDAO;
import com.fastcampus.jblog.biz.category.CategoryDAOMyBatis;
import com.fastcampus.jblog.biz.post.PostDAO;
import com.fastcampus.jblog.biz.post.PostDAOMyBatis;
import com.fastcampus.jblog.biz.user.UserDAO;
import com.fastcampus.jblog.biz.user.UserDAOMyBatis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    @Bean
    public BlogDAO blogDAO() {
//        return new BlogDAOJDBC();
        return new BlogDAOMyBatis();
    }

    @Bean
    public CategoryDAO categoryDAO() {
        return new CategoryDAOMyBatis();
    }

    @Bean
    public PostDAO postDAO() {
        return new PostDAOMyBatis();
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAOMyBatis();
    }
}
