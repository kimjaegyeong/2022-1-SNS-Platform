package project.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.model.dao.MemberDao;
import project.model.dto.*;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		MemberDao dao= new MemberDao();
		String grade= dao.login(memberId, memberPw);
		//System.out.println(memberId+","+grade);
		
		if(grade != null) {	
			HttpSession session= request.getSession();

			session.setAttribute("memberId",memberId);
			session.setAttribute("grade",grade);
			
			session.getAttribute(grade);
			System.out.println(session.getAttribute("memberId"));
			System.out.println(session.getAttribute("grade"));
	
			response.sendRedirect("mainPage");
			
		}
		else { 
			request.setAttribute("message", "[실패] 로그인 정보가 올바르지 않습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
			
		}
	}
}
