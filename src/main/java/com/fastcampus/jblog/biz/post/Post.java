package com.fastcampus.jblog.biz.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Post {
    @Id @GeneratedValue
    @Column(name = "POST_ID")
    private int postId;

    @Column(name = "BLOG_ID")
    private int blogId;

    @Column(name = "CATEGORY_ID")
    private int categoryId;
    private String title;
    private String content;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
