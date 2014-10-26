package hj.web.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResidentUI extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object police = request.getSession().getAttribute("police");
		if( police == null){
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}else{
			request.getSession().setAttribute("pagename", "resident");
			request.getRequestDispatcher("/WEB-INF/jsp/addresident.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
