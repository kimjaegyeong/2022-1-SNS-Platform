package project.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.dao.MemberDao;
import project.model.dto.Member;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name= request.getParameter("name");
		String phone= request.getParameter("phone");
		String email= request.getParameter("email");
	//	String grade= request.getParameter("grade");
		String grade="m";
		System.out.println(memberId + "," + memberPw);
		MemberDao dao= new MemberDao();
		Member member= new Member(memberId, memberPw, name, phone, email, grade);
		boolean check= dao.signUp(member);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
