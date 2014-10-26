package hj.web.controller;

import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//验证是否登录
		if(!WebUtils.isLogin(request)){
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		String word = request.getParameter("word");
		String key = request.getParameter("key");
		//System.out.println("key=" + key + " word=" + word);
		ResidentServiceImpl service = new ResidentServiceImpl();
			
		//搜索关键词为空
		if(word == null || word.trim().equals("")){
			List rel = service.find();
			request.setAttribute("rel", rel);
			request.getRequestDispatcher("/WEB-INF/jsp/resident.jsp").forward(request, response);
			return;
		}
		
		//关键词不为空，但未选择分类
		request.setAttribute("word", word);
		if(key == null){
			List rel = service.find(word);
			request.setAttribute("rel", rel);
			request.getRequestDispatcher("/WEB-INF/jsp/resident.jsp").forward(request, response);
			return;
		}
		//关键词不为空，选择分类
		request.setAttribute(key, "checked");
		
		//System.out.println(request.getAttribute("name"));
		List rel = service.find(key, word);
		request.setAttribute("rel", rel);
		
		request.getRequestDispatcher("/WEB-INF/jsp/resident.jsp").forward(request, response);
		return;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
