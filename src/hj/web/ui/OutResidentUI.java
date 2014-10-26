package hj.web.ui;

import hj.utils.WebUtils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutResidentUI extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		//检测是否是从编辑页面而来(是否存在editform session)
		if(request.getSession().getAttribute("editform") == null){
			response.sendRedirect(request.getContextPath() + "/WEB-INF/jsp/resident.jsp");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/outresident.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
