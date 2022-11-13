package project.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import project.model.dto.Post;
/**
 * Servlet implementation class selectOnePostServlet
 */
@WebServlet("/selectOnePost")
public class selectOnePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectOnePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		
		String post_number= request.getParameter("post_number");
		String img = "imgInPost/" + request.getParameter("img");
		String contents= request.getParameter("contents");
		String id= (String) session.getAttribute("memberId");
		Post dto = new Post(post_number, id, contents, img);
		System.out.println(img);
		request.setAttribute("dto" , dto);
		request.getRequestDispatcher("updateMyPost.jsp").forward(request, response);
	}


}
