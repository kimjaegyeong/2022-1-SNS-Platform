package project.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import project.model.dao.CommentDao;
import project.model.dto.Comment;

/**
 * Servlet implementation class createCommentServlet
 */
@WebServlet("/createComment")
public class createCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String memberId= (String) session.getAttribute("memberId");
		String comment = request.getParameter("comment");
		String post_number= request.getParameter("post_number");
		
		Comment dto= new Comment(post_number, memberId, comment);
		CommentDao dao= new CommentDao();
		
		boolean check= dao.insert_comment(dto);
		
		request.setAttribute("check",check);
		request.setAttribute(post_number,"post_number");
		request.getRequestDispatcher("clickedPost").forward(request, response);
	}

}
