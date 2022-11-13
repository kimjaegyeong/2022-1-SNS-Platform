package project.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.model.dto.Comment;
import project.model.dto.Post;

public class CommentDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private	String url = "jdbc:mysql://localhost:3306/sns_platform?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false&useUnicode=true";
	
	private String user = "root";
	private String password = "password";

public CommentDao() { 
	try {
		
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	
	
	public ArrayList<Comment> select_comment(String post_number) {
		try {

			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= " select * from comment where post_number=? order by comment_number desc ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post_number);
			ResultSet rs= pstmt.executeQuery();	

			ArrayList<Comment> list = new ArrayList<Comment>();
			while(rs.next()) {
		
				
				String member_id =rs.getString("id");  
				String comment = rs.getString("comment_content"); 
				String comment_number= rs.getString("comment_number");
				String postNumber= rs.getString("post_number");
				Comment dto= new Comment(member_id, comment, comment_number, postNumber);
				list.add(dto);	
				
			}
			rs.close();
			pstmt.close();
			conn.close();
			
			return list; 
				
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	
		}



	public boolean insert_comment(Comment dto) {
		try {
			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= "insert into comment(id,comment_content,post_number) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);	
				
			pstmt.setString(1, dto.getMemberId()); 
			pstmt.setString(2,dto.getComment()); 
			pstmt.setString(3, dto.getPost_number());

			int rows = pstmt.executeUpdate();
			
			if (rows == 1) {
				return true;
			}
			pstmt.close();
			conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} 
			return false;
		}



	public boolean deleteComment(String comment_number) {
		try {

			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= "delete from comment where comment_number=?";
			int commentNumber = Integer.parseInt(comment_number); 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,commentNumber);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
			return true; 
				
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
	}
	}
	

