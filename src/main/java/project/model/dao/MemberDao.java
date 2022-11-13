package project.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import project.model.dto.*;
public class MemberDao {

		private String driver = "com.mysql.cj.jdbc.Driver";
		private	String url = "jdbc:mysql://localhost:3306/sns_platform?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false&useUnicode=true";

		private String user = "root";
		private String password = "password";

		public MemberDao() { 
			try {
				
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public boolean signUp(Member dto) {
			try {
				Connection conn= DriverManager.getConnection(url, user, password);
				String sql= "insert into member values(?,?,?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, dto.getMemberId()); 
				pstmt.setString(2,dto.getMemberPw()); 
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getPhone());
				pstmt.setString(5, dto.getEmail());
				pstmt.setString(6, dto.getGrade());

				int rows = pstmt.executeUpdate();
				System.out.println(rows);
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


		/** 
		 * 로그인 
		 */
		
		public String login(String memberId, String memberPw) {
			try {
		
				Connection conn= DriverManager.getConnection(url, user, password);
			
			String sql = "select grade from member where id=? and password=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberId); 
				pstmt.setString(2, memberPw); 
				
				ResultSet rs= pstmt.executeQuery();
		
				if(rs.next()) {
					
					return rs.getString("grade");
				}
				
				rs.close();
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		
		}
}