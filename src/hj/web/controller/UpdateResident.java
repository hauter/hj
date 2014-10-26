package hj.web.controller;

import hj.entity.Resident;
import hj.exception.ResidentIdnumExistException;
import hj.exception.ResidentInfoIncompleteException;
import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.ResidentForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateResident extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		ResidentForm editform = WebUtils.requestToFormBean(request,
				ResidentForm.class);
		boolean b = editform.validate();
		// 验证不通过
		if (!b) {
			request.setAttribute("editform", editform);
			request.getRequestDispatcher("/WEB-INF/jsp/editresident.jsp")
					.forward(request, response);
			return;
		}
		// 验证通过
		Resident resident = WebUtils
				.getResidentBeanByEditFormBean(editform);
		// System.out.println(resident);
		ResidentServiceImpl service = new ResidentServiceImpl();
		try {
			service.update(resident);
			// 编辑成功
			response.sendRedirect(request.getContextPath()
					+ "/servlet/ResidentUI");
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
