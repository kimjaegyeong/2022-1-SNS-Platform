package project.model.controller;

import java.io.IOException;
import java.io.File.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;

import com.oreilly.servlet.MultipartRequest;

import project.model.dao.PostDao;
import project.model.dto.Post;

/**
 * Servlet implementation class uploadPostServlet
 */
@WebServlet("/uploadPost")
public class uploadPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session= request.getSession();
		
		Post dto= new Post();
		PostDao dao= new PostDao();
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		String saveFolder=request.getSession().getServletContext().getRealPath("/")+"./imgInPost";
		int fileSize= 10*1024*1024;
		
		MultipartRequest multi= new MultipartRequest(
				request,
				saveFolder,
				fileSize,
				"UTF-8"
				);
		
		String id = (String) session.getAttribute("memberId");
		String contents= multi.getParameter("contents");

		java.io.File file= multi.getFile("f");
		
		dto.setId(id);
		dto.setContents(contents);
		
		boolean check;
		
		if(file!=null) {
			dto.setImg(file.getName());
			check=dao.insert_post(dto);
		}else {
			dto.setImg("notExist");
			check=dao.insert_post_not_img(dto);
		}
		request.getRequestDispatcher("mainPage").forward(request, response);
	}
}
