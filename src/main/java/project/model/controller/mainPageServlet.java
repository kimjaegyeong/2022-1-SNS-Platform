package project.model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.model.dao.PostDao;
import project.model.dto.Post;

/**
 * Servlet implementation class mainPageServlet
 */
@WebServlet("/mainPage")
public class mainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 
		 * 회원이 아닌 경우 back
		 * 
		 */
		


		   response.setContentType("text/html; charset=euc-kr");
		   PrintWriter out = response.getWriter();
		   
		   //history.go(-1) >> 이전페이지로 -2가되면  이전 이전 페이지로
		   String msg = "로그인을 해 주십시오.";
		   String str1="";
		   str1 = "<script language='javascript'>";
		   str1 += "alert('"+ msg + "');";   //얼럿창 띄우기
		   str1 += "location.href='login.jsp'"; 
		   str1 += "</script>";
		   out.print(str1);
		
		/*
		 * 
		 * main page 처리 
		 * 
		 */
		
		request.setCharacterEncoding("utf-8");
		HttpSession session= request.getSession();
		
		String memberId= (String) session.getAttribute("memberId");
		String followings = null;
		System.out.println(memberId);
		
		PostDao dao= new PostDao();
		ArrayList<Post> list = new ArrayList<Post>();
		
		if(session.getAttribute("grade").equals("u")) {
					System.out.println("1");
					ArrayList<String> followingList = new ArrayList<String>();
					followingList= dao.select_following(memberId);	
					
					try {
					if(followingList.size()>0) {	
						if(followingList.size()<2) {
							followings="id = '"+followingList.get(0)+"'"+" or "+"id = '"+memberId+"'";
							}
						else{
							for(int i=0; i<followingList.size(); i++) {
								
								if(i==0) {
									followings=  "id="+"'"+ memberId  + "'"+ " or " + "id="+"'"+followingList.get(i)+"'";
								}
								else {
									followings= followings+"or "+"id="+"'"+followingList.get(i)+"'";
								}
							}				
						}
						list= dao.select_postInMain(followings);
					}
					}catch (ArrayIndexOutOfBoundsException e) {
						Post post= new Post("","","","");
						list.add(post);
						
					}finally {
						request.setAttribute("list", list);
						request.getRequestDispatcher("mainPage.jsp").forward(request, response);
		
					}
					
		}

		
		else if(session.getAttribute("grade").equals("m")) {
			
			list= dao.select_AllPost();
			request.setAttribute("list", list);
			request.getRequestDispatcher("mainPageForAdmin.jsp").forward(request, response);
			
		}
		
	
		
	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}



