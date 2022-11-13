package project.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import project.model.dto.*;

public class PostDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private	String url = "jdbc:mysql://localhost:3306/sns_platform?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false&useUnicode=true";

	private String user = "root";
	private String password = "password";

	public PostDao() { 
		try {
			
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		public boolean insert_post(Post dto) {
		try {
			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= "insert into post(id,content,img) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);	
				
			pstmt.setString(1, dto.getId()); 
			pstmt.setString(2,dto.getContents()); 
			pstmt.setString(3, dto.getImg());
			

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
			
		public  boolean insert_post_not_img(Post dto) {
			try {
				Connection conn= DriverManager.getConnection(url, user, password);
				String sql= "insert into post(id,content) values(?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);	
					
				pstmt.setString(1, dto.getId()); 
				pstmt.setString(2,dto.getContents()); 
				

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
		
		public ArrayList<Post> select_my_post(String memberId) {		

		try {

			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= " select * from post where id=? ORDER BY post_number DESC ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			ResultSet rs= pstmt.executeQuery();	

			ArrayList<Post> list = new ArrayList<Post>();
			while(rs.next()) {
				String post_number= Integer.toString(rs.getInt("post_number"));
				
				String member_id =rs.getString("id");  
				String content = rs.getString("content"); 
				String img = rs.getString("img");	
				Post dto= new Post(post_number,member_id,content,img);
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
				
		public Post select_post(String post_number) {		

			try {

				Connection conn= DriverManager.getConnection(url, user, password);
				String sql= " select * from post where post_number=?  ORDER BY post_number DESC";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, post_number);
				ResultSet rs= pstmt.executeQuery();	
				Post dto = null;
				ArrayList<Post> list = new ArrayList<Post>();
				if(rs.next()) {
					String member_id =rs.getString("id");  
					String content = rs.getString("content"); 
					String img = rs.getString("img");	
					dto= new Post(post_number,member_id,content,img);
					
				
				}
				rs.close();
				pstmt.close();
				conn.close();
				
				return dto; 
					
					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
		
			}
		
	
		
	public String update_post(Post dto) {
		try {
			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= "update post set content=?, img=? where post_number=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getContents()); 
			pstmt.setString(2, dto.getImg());
		
			pstmt.setString(3, dto.getPost_number());

			int rows = pstmt.executeUpdate();
			System.out.println(rows);
			if (rows == 1) {
				return dto.getPost_number();
			}
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		return null;
		
	}
	
	public String update_post_not_img(Post dto) {
		try {
			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= "update post set content=? where post_number=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getContents()); 
			
			pstmt.setString(2, dto.getPost_number());			


			int rows = pstmt.executeUpdate();
			System.out.println(rows);
			if (rows == 1) {
				return dto.getPost_number();
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		return null;
		
	}

	public ArrayList<Post> select_postInMain(String memberId) {
		try {
		
			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= " select * from post where "+memberId+" ORDER BY post_number DESC";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
		//	pstmt.setString(1, memberId);
			ResultSet rs= pstmt.executeQuery();	
		
			Post dto = null;
			
			ArrayList<Post> list = new ArrayList<Post>();
			while(rs.next()) {
				String post_number= rs.getString("post_number");
				String member_id =rs.getString("id");  
				String content = rs.getString("content"); 
				String img = rs.getString("img");	
				dto= new Post(post_number,member_id,content,img);
				
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

	public ArrayList<String> select_following(String memberId) {
		try {

			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= " select followingId from following where id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			ResultSet rs= pstmt.executeQuery();	
			ArrayList<String> list = new ArrayList<String>();
			while(rs.next()) {
				String followingId= rs.getString("followingId");
				
				
				list.add(followingId);
			
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

	public boolean delete_post(String post_number) {
		try {

			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= "delete from post where post_number=?";
			int postNumber = Integer.parseInt(post_number); 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,postNumber);
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

	public ArrayList<Post> search(String searchText) {
	
		try {

			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= " select * from post where content LIKE '%" +searchText+"%'";

			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			ResultSet rs= pstmt.executeQuery();	

			ArrayList<Post> list = new ArrayList<Post>();
			while(rs.next()) {
				String post_number= Integer.toString(rs.getInt("post_number"));
				String member_id =rs.getString("id");  
				String content = rs.getString("content"); 
				String img = rs.getString("img");	
				Post dto= new Post(post_number,member_id,content,img);
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


	public ArrayList<Post> select_AllPost() {
		try {

			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= " select * from post ORDER BY post_number DESC ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs= pstmt.executeQuery();	

			ArrayList<Post> list = new ArrayList<Post>();
			while(rs.next()) {
				String post_number= Integer.toString(rs.getInt("post_number"));
				String member_id =rs.getString("id");  
				String content = rs.getString("content"); 
				String img = rs.getString("img");	
				Post dto= new Post(post_number,member_id,content,img);
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

				
}
	

