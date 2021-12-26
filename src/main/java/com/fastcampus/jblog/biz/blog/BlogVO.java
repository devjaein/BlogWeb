package com.fastcampus.jblog.biz.blog;

import com.fastcampus.jblog.biz.user.UserVO;

import lombok.Data;

import javax.persistence.*;

@Data
public class BlogVO {
	private int blogId;
	private String title;
	private String tag;
	private int cntDisplayPost;
	private String status;
	private int userId;

	private String searchCondition;
	private String searchKeyword;
	private String userName;
}

