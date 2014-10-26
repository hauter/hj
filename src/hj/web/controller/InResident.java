package hj.web.controller;

import hj.entity.Resident;
import hj.exception.PoliceStationNotFoundException;
import hj.exception.ResidentIdnumExistException;
import hj.exception.ResidentInfoIncompleteException;
import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.InForm;
import hj.web.frombean.ResidentForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InResident extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//验证是否登录
		if(!WebUtils.isLogin(request)){
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		InForm inform = WebUtils.requestToFormBean(request, InForm.class);
		boolean b = inform.validate();
		//验证基本信息
		if(!b){
			request.setAttribute("inform", inform);
			request.getRequestDispatcher("/WEB-INF/jsp/inresident.jsp").forward(request, response);
			return;
		}
		// 试图迁入
		Resident resident = WebUtils.getResidentBeanByInFormBean(inform);
		ResidentServiceImpl service = new ResidentServiceImpl();
		try {
			service.in(resident, new Integer(inform.getOldPS()));

			// 添加成功
			response.sendRedirect(request.getContextPath()
					+ "/servlet/ResidentUI");
		} catch (ResidentIdnumExistException e) {
			inform.getErrors().put("idnum", "身份证号已存在");
			request.setAttribute("inform", inform);
			request.getRequestDispatcher("/WEB-INF/jsp/inresident.jsp")
					.forward(request, response);
			return;
		}catch (PoliceStationNotFoundException e) {
			inform.getErrors().put("oldPS", "派出所未找到");
			request.setAttribute("inform", inform);
			request.getRequestDispatcher("/WEB-INF/jsp/inresident.jsp").forward(request, response);
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
