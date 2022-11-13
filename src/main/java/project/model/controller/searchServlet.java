package project.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.model.dto.Post;
import project.model.dao.PostDao;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/search")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchText= request.getParameter("search");
		System.out.println(searchText);
		PostDao dao= new PostDao();
		ArrayList<Post> list = new ArrayList<Post>();
		list= dao.search(searchText);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
	}

}
