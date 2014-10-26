package hj.web.controller;

import hj.entity.Resident;
import hj.exception.ResidentNotFoundException;
import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Checkin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//验证是否登录
		if(!WebUtils.isLogin(request)){
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		String rsid = request.getParameter("rsid");
		if(rsid == null || rsid.trim().equals("")){
			request.setAttribute("badMessage", "服务器异常");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		ResidentServiceImpl service = new ResidentServiceImpl();
		try {
			service.checkin(new Integer(rsid));
			request.setAttribute("goodMessage", "办理成功!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("badMessage", "服务器异常");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
