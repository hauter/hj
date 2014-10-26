package hj.web.controller;

import hj.entity.PoliceStation;
import hj.service.impl.PoliceStationServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.PoliceStationForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePS extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		PoliceStationForm editpsform = WebUtils.requestToFormBean(request, PoliceStationForm.class);
		boolean b = editpsform.validate();
		//校验失败
		if(!b){
			request.setAttribute("addpsform", editpsform);
			request.getRequestDispatcher("/WEB-INF/jsp/editps.jsp").forward(request, response);
			return;
		}
		//校验成功
		try{
			PoliceStation ps = WebUtils.PSFormToPSBean(editpsform);
			PoliceStationServiceImpl service = new PoliceStationServiceImpl();
			service.update(ps);
			response.sendRedirect(request.getContextPath()+ "/servlet/PoliceStationUI");
			return;
		}catch(Exception e){
			e.printStackTrace();
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
