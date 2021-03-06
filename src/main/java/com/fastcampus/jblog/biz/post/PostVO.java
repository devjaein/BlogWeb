package com.fastcampus.jblog.biz.post;

import java.util.Date;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class PostVO {
	private int postId;
	private int categoryId;
	private String title;
	private String content;
	private Date createdDate;
	private int blogId;
}
