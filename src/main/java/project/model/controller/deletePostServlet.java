package project.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.dao.PostDao;

/**
 * Servlet implementation class deletePostServlet
 */
@WebServlet("/deletePost")
public class deletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String post_number= request.getParameter("post_number");
	
		PostDao dao = new PostDao();
		
		boolean check =dao.delete_post(post_number);
		System.out.println(check);
		request.setAttribute("check" ,check);
		request.getRequestDispatcher("myPost").forward(request, response);
	}

}
