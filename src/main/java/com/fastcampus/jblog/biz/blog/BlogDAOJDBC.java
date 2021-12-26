package com.fastcampus.jblog.biz.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fastcampus.jblog.biz.common.JDBCUtil;
import com.fastcampus.jblog.biz.user.UserVO;

@Repository
public class BlogDAOJDBC implements BlogDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private String BLOG_INSERT = "insert into blog(blog_id, title, user_id) values (?,?,?)";
	private final String BLOG_UPDATE = "update blog set title = ?, tag = ?, cnt_display_post = ? where blog_id = ?";
	private final String BLOG_DELETE = "delete from blog where blog_id = ?";
	private final String BLOG_DELETE_REQUEST = "update blog set status = ? where blog_id = ?";
	private final String BLOG_GET = "select * from blog where blog_id = ?";
	private final String BLOG_GET_List_TITLE = "select b.blog_id, b.title, b.status, u.user_name from blog b, blog_user u where b.blog_id = u.user_id and b.title like '%'||?||'%' ";
	private final String BLOG_GET_List_TAG = "select b.blog_id, b.title, b.status, u.user_name from blog b, blog_user u where b.blog_id = u.user_id and b.tag like '%'||?||'%' ";
	private final String BLOG_GET_List_BLOGGER = "select b.blog_id, b.title, b.status, u.user_name from blog b, blog_user u where b.blog_id = u.user_id and u.user_name like '%'||?||'%' ";

//	블로그 삭제 요청
	@Override
	public void deleteRequest(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_DELETE_REQUEST);
			stmt.setString(1, vo.getStatus());
			stmt.setInt(2, vo.getBlogId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

//	블로그 생성
	@Override
	public void insertBlog(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_INSERT);
			stmt.setInt(1, vo.getBlogId());
			stmt.setString(2, vo.getTitle());
			stmt.setInt(3, vo.getUserId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 블로그 수정
	@Override
	public void updateBlog(BlogVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getTag());
			stmt.setInt(3, vo.getCntDisplayPost());
			stmt.setInt(4, vo.getBlogId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 블로그 삭제 
	@Override
	public void deleteBlog(int blogId) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_DELETE);
			stmt.setInt(1, blogId);
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);

		}
	}
	
//	블로그 조회
	@Override
	public BlogVO getBlog(BlogVO vo) {
		BlogVO blog = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BLOG_GET);
			stmt.setInt(1, vo.getBlogId());
			rs = stmt.executeQuery();
			if(rs.next()) {
				blog = new BlogVO();
				blog.setBlogId(rs.getInt("BLOG_ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setTag(rs.getString("TAG"));
				blog.setCntDisplayPost(rs.getInt("CNT_DISPLAY_POST"));
				blog.setStatus(rs.getString("STATUS"));
				blog.setUserId(rs.getInt("USER_ID"));
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return blog;
	}

//블로그 목록 조회
	@Override
	public List<BlogVO> getBlogList(BlogVO vo) {
		List<BlogVO> blogList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			if (vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BLOG_GET_List_TITLE);
			} else if (vo.getSearchCondition().equals("TAG")) {
				stmt = conn.prepareStatement(BLOG_GET_List_TAG);
			} else if (vo.getSearchCondition().equals("BLOGGER")) {
				stmt = conn.prepareStatement(BLOG_GET_List_BLOGGER);
			}
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();
			while(rs.next()) {
				BlogVO blog = new BlogVO();
				blog.setBlogId(rs.getInt("BLOG_ID"));
				blog.setTitle(rs.getString("TITLE"));
				blog.setCntDisplayPost(rs.getInt("CNT_DISPLAY_POST"));
				blog.setStatus(rs.getString("STATUS"));
				blog.setTag(rs.getString("TAG"));
				blog.setUserName(rs.getString("USER_NAME"));
				blogList.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		} 
		return blogList;
		
	}
}
