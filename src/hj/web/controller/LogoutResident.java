package hj.web.controller;

import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutResident extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		try{
			int rsid = new Integer(request.getParameter("rsid"));
			ResidentServiceImpl service = new ResidentServiceImpl();
			service.logout(rsid);
			
			//注销成功
			response.sendRedirect(request.getContextPath() + "/servlet/ResidentUI");
			
		} catch ( Exception e){
			//其他问题处理失败（异常）
			e.printStackTrace();
			request.setAttribute("badMessage", "服务器异常");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
