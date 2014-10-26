package hj.web.controller;

import hj.entity.PoliceStation;
import hj.service.impl.PoliceStationServiceImpl;
import hj.utils.WebUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PSSearch extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		PoliceStationServiceImpl service = new PoliceStationServiceImpl();
		List pslist;
		//关键字为空
		if(word == null || word.trim().equals("")){
			try{
				pslist = service.find();
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("badMessage", "服务器异常");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				return;
			}
			request.setAttribute("pslist", pslist);
			request.getRequestDispatcher("/WEB-INF/jsp/policestation.jsp").forward(request, response);
			return;
		}
		
		//关键不为空,但未选择分类
		request.setAttribute("word", word);
		if(key == null || key.trim().equals("")){
			try{
				pslist = service.find(word);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("badMessage", "服务器异常");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				return;
			}
			request.setAttribute("pslist", pslist);
			request.getRequestDispatcher("/WEB-INF/jsp/policestation.jsp").forward(request, response);
			return;
		}
		//关键不为空,且选择了分类
		request.setAttribute(key, "checked");
		try{
			pslist = service.find(key, word);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("badMessage", "服务器异常");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		request.setAttribute("pslist", pslist);
		request.getRequestDispatcher("/WEB-INF/jsp/policestation.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
