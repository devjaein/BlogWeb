package com.fastcampus.jblog.biz.category;

import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Category {

    @Column(name = "BLOG_ID")
    private int blogId;

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private int categoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "DISPLAY_TYPE")
    private String displayType;

    @Column(name = "CNT_DISPLAY_POST")
    private int cntDisplayPost;
    private String description;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public Category() {
    }

    public Category(int blogId, int categoryId, String categoryName, String displayType, int cntDisplayPost, String description, Date createdDate, Date modifiedDate) {
        this.blogId = blogId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.displayType = displayType;
        this.cntDisplayPost = cntDisplayPost;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
