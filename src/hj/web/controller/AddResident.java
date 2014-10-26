package hj.web.controller;

import hj.entity.Resident;
import hj.exception.ResidentIdnumExistException;
import hj.exception.ResidentInfoIncompleteException;
import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.ResidentForm;
import hj.web.frombean.RegisterForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResident extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//验证是否登录
		if(!WebUtils.isLogin(request)){
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		ResidentForm addform = WebUtils.requestToFormBean(request, ResidentForm.class);
		boolean b = addform.validate();
		//验证不通过
		if(!b){
			request.setAttribute("addform", addform);
			request.getRequestDispatcher("/WEB-INF/jsp/addresident.jsp").forward(request, response);
			return;
		}
		//验证通过

		// 试图添加
		Resident resident = WebUtils
				.getResidentBeanByAddResidentFormBean(addform);
		ResidentServiceImpl service = new ResidentServiceImpl();
		try {
			service.add(resident);
			// 添加成功
			response.sendRedirect(request.getContextPath()
					+ "/servlet/ResidentUI");
		} catch (ResidentIdnumExistException e) {
			// 身份证重复
			addform.getErrors().put("idnum", "身份证号已存在");
			request.setAttribute("addform", addform);
			request.getRequestDispatcher("/WEB-INF/jsp/addresident.jsp")
					.forward(request, response);
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
