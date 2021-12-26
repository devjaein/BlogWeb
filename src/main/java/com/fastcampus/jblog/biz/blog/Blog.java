package com.fastcampus.jblog.biz.blog;

import com.fastcampus.jblog.biz.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Blog {
    @Id @GeneratedValue
    @Column(name = "BLOG_ID")
    private int blogId;

    private String title;
    private String tag;

    @Column(name = "CNT_DISPLAY_POST")
    private int cntDisplayPost;
    private String status;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Transient
    private String searchCondition;

    @Transient
    private String searchKeyword;

    @Transient
    private String userName;

    public void setUser(User user) {
        //기존관계 제거
        if (this.user != null) {
            this.user.getBlogs().remove(this);
        }
        this.user = user;
        user.getBlogs().add(this);
    }

    public Blog() {
    }

    public Blog(int blogId, String title, String tag, int cntDisplayPost, String status, int userId, String searchCondition, String searchKeyword, String userName) {
        this.blogId = blogId;
        this.title = title;
        this.tag = tag;
        this.cntDisplayPost = cntDisplayPost;
        this.status = status;
        this.searchCondition = searchCondition;
        this.searchKeyword = searchKeyword;
        this.userName = userName;
    }
}
