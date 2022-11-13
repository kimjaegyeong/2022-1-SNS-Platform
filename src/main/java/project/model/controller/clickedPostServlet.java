package project.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.dao.CommentDao;
import project.model.dao.PostDao;
import project.model.dto.Comment;
import project.model.dto.Post;

/**
 * Servlet implementation class clickedPostServlet
 */
@WebServlet("/clickedPost")
public class clickedPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clickedPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_number= request.getParameter("post_number");
		PostDao dao= new PostDao();
		CommentDao comDao= new CommentDao();
		Post dto =dao.select_post(post_number);
		ArrayList<Comment> comDto= new ArrayList<Comment>();
		
		comDto =comDao.select_comment(post_number);
			
		request.setAttribute("dto" , dto);
		request.setAttribute("comDto", comDto);
		
		request.getRequestDispatcher("showPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	
		
	}
}
