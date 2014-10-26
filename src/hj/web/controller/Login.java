package hj.web.controller;

import hj.entity.Police;
import hj.service.impl.PoliceServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.LoginForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//清空session
		request.getSession().removeAttribute("police");
		request.setCharacterEncoding("UTF-8");
		LoginForm lf = WebUtils.requestToFormBean(request, LoginForm.class);
		Boolean b = lf.validate();
		//表单验证不通过
		if(!b){
			request.setAttribute("lf", lf);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
		//表单验证通过，试图登录
		PoliceServiceImpl psi = new PoliceServiceImpl();
		Police police;
		try{
			police = psi.login(lf.getUserName(), lf.getPassword());
			if(police != null){
				request.getSession().setAttribute("police", police);
				//response.sendRedirect(request.getContextPath() + "/index.jsp");
				response.sendRedirect(request.getContextPath() + "/servlet/ResidentUI");
				return;
			}
		}catch(Exception e){
			//其他问题处理失败（异常）
			e.printStackTrace();
			request.setAttribute("badMessage", "服务器异常");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//登录成功
		//登录失败,用户名或者密码错误
		lf.getErrors().put("userName", "用户名或者密码错误");
		lf.getErrors().put("password", "用户名或者密码错误");
		request.setAttribute("lf", lf);
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
