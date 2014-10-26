package hj.web.controller;

import hj.entity.PoliceStation;
import hj.exception.PoliceStationIDExistException;
import hj.service.impl.PoliceStationServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.PoliceStationForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPS extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//验证是否登录
		if(!WebUtils.isLogin(request)){
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		PoliceStationForm addpsform = WebUtils.requestToFormBean(request, PoliceStationForm.class);
		boolean b = addpsform.validate();
		//校验失败
		if(!b){
			request.setAttribute("addpsform", addpsform);
			request.getRequestDispatcher("/WEB-INF/jsp/addps.jsp").forward(request, response);
			return;
		}
		//校验成功
		try {
			PoliceStation ps = WebUtils.PSFormToPSBean(addpsform);
			PoliceStationServiceImpl service = new PoliceStationServiceImpl();
			service.add(ps);
			response.sendRedirect(request.getContextPath()+ "/servlet/PoliceStationUI");
			return;
		} catch (PoliceStationIDExistException e) {
			addpsform.getErrors().put("psid", "编号已存在");
			request.setAttribute("addpsform", addpsform);
			request.getRequestDispatcher("/WEB-INF/jsp/addps.jsp").forward(request, response);
			return;
		} catch(Exception e){
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
