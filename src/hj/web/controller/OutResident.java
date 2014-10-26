package hj.web.controller;

import hj.exception.PoliceStationNotFoundException;
import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.OutForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutResident extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		//验证输入是否合法
		OutForm outForm  = WebUtils.requestToFormBean(request, OutForm.class);
		boolean b = outForm.validate();
		if(!b){
			request.setAttribute("outform", outForm);
			request.getRequestDispatcher("/WEB-INF/jsp/outresident.jsp").forward(request, response);
			return;
		}
		try {
			int rsid = new Integer(outForm.getRsid());
			int nowPS = new Integer(outForm.getNowPS());
			ResidentServiceImpl service = new ResidentServiceImpl();
			service.out(rsid, nowPS);
			response.sendRedirect(request.getContextPath() + "/servlet/ResidentUI");
		} catch (PoliceStationNotFoundException e) {
			outForm.getErrors().put("psid", "派出所编号不存在");
			request.setAttribute("outform", outForm);
			request.getRequestDispatcher("/WEB-INF/jsp/outresident.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			// 其他问题处理失败（异常）
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
