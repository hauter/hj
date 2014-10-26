package hj.web.controller;

import hj.entity.Police;
import hj.exception.PoliceIDExistException;
import hj.exception.PoliceUserNameExistException;
import hj.service.impl.PoliceServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.RegisterForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对用户提交的数据进行验证
		request.setCharacterEncoding("UTF-8");
		RegisterForm rf = WebUtils.requestToFormBean(request, RegisterForm.class);
		Boolean b = rf.validate();
		//验证不通过
		if(!b){
			request.setAttribute("rf", rf);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		//验证通过，试图添加用户
		Police police = WebUtils.getPoliceBeanByFromBean(rf);
		PoliceServiceImpl psi = new PoliceServiceImpl();
		try {
			psi.register(police);
			request.setAttribute("goodMessage", "注册成功!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (PoliceIDExistException e) {
			//用户ID已存在已存在
			rf.getErrors().put("id", "该ID已被注册");
			request.setAttribute("rf", rf);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch (PoliceUserNameExistException e){
			//用户名已存在
			rf.getErrors().put("userName", "该用户名已被注册");
			request.setAttribute("rf", rf);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch(Exception e){
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
