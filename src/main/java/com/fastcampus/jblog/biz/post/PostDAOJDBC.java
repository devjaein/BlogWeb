package com.fastcampus.jblog.biz.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fastcampus.jblog.biz.common.JDBCUtil;
import com.fastcampus.jblog.biz.user.UserVO;

@Repository
public class PostDAOJDBC implements PostDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private String POST_INSERT = "insert into post(post_id, blog_id, category_id, title, content, created_date) values ((select nvl(max(post_id), 0) + 1 from post), ?, ?, ?, ?, sysdate)";
	private String POST_UPDATE = "update post set category_id = ?, title = ?, content = ? where post_id = ?";
	private String POST_LIST_CATEGORY = "select * from post where blog_id = ? and category_id = ? order by post_id desc";
	private String POST_DELETE = "delete from post where post_id = ?";
	private String POST_GET = "select * from post where post_id = ?";
	private String POST_LIST = "select * from post where blog_id = ? order by post_id desc";

	
	@Override
	public void insertPost(PostVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POST_INSERT);
			stmt.setInt(1, vo.getBlogId());
			stmt.setInt(2, vo.getCategoryId());
			stmt.setString(3, vo.getTitle());
			stmt.setString(4, vo.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	@Override
	public void updatePost(PostVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POST_UPDATE);
			stmt.setInt(1, vo.getCategoryId());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getContent());
			stmt.setInt(4, vo.getPostId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	@Override
	public void deletePost(PostVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POST_DELETE);
			stmt.setInt(1, vo.getPostId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	@Override
	public PostVO getPost(PostVO vo) {
		PostVO post = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POST_GET);
			stmt.setInt(1, vo.getPostId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				post = new PostVO();
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setPostId(rs.getInt("POST_ID"));
				post.setBlogId(rs.getInt("BLOG_ID"));
				post.setCategoryId(rs.getInt("CATEGORY_ID"));
				post.setCreatedDate(rs.getDate("CREATED_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return post;
	}
	
	@Override
	public List<PostVO> getPostList(PostVO vo) {
		List<PostVO> postList = new ArrayList<PostVO>();
		try {
			conn = JDBCUtil.getConnection();
			if (vo.getCategoryId() != 0) {
				stmt = conn.prepareStatement(POST_LIST_CATEGORY);
				stmt.setInt(1, vo.getBlogId());
				stmt.setInt(2, vo.getCategoryId());
			} else {
				stmt = conn.prepareStatement(POST_LIST);
				stmt.setInt(1, vo.getBlogId());
			}
			rs = stmt.executeQuery();
	
			while (rs.next()) {
				PostVO post = new PostVO();
				post.setBlogId(rs.getInt("BLOG_ID"));
				post.setTitle(rs.getString("TITLE"));
				post.setCreatedDate(rs.getDate("CREATED_DATE"));
				post.setContent(rs.getString("CONTENT"));
				post.setCategoryId(rs.getInt("CATEGORY_ID"));
				post.setPostId(rs.getInt("POST_ID"));
				postList.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return postList;
	}
}
