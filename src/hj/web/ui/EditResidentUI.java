package hj.web.ui;

import hj.entity.Resident;
import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.ResidentForm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditResidentUI extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}else{
			String temp = request.getParameter("rsid");
			ResidentServiceImpl service = new ResidentServiceImpl();
			List<Resident> list = service.find("rsid", temp);
			Resident resident = list.get(0);
			//System.out.println(resident);
			ResidentForm editform = WebUtils.ResidentToResidentForm(resident);
			request.getSession().setAttribute("editform", editform);
			request.getRequestDispatcher("/WEB-INF/jsp/editresident.jsp").forward(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
