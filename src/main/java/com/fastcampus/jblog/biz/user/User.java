package com.fastcampus.jblog.biz.user;

import com.fastcampus.jblog.biz.blog.Blog;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "BLOG_USER")
public class User {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    @JoinColumn(name = "BLOG_ID")
    private int userId;

    @OneToMany(mappedBy = "blog")
    private List<Blog> blogs = new ArrayList<>();

    private String id;
    private String userName;
    private String role;
    private String password;
}
