package hj.web.ui;

import hj.entity.Resident;
import hj.service.impl.ResidentServiceImpl;
import hj.utils.WebUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckinUI extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		
		String rsid = request.getParameter("rsid");
		ResidentServiceImpl service = new ResidentServiceImpl();
		if(rsid == null || rsid.trim().equals("")){
			request.setAttribute("badMessage", "服务器异常");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		List<Resident> list = service.find("rsid", rsid);
		if(list == null){
			request.setAttribute("badMessage", "服务器异常");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		Resident resident = list.get(0);
		//检测是否已经在办理中
		boolean b = service.isChecking(resident.getRsid());
		if(b){
			request.setAttribute("checkin", "checking");
		}else{
			request.setAttribute("checkin", "unchecked");
		}
		request.getSession().setAttribute("resident", resident);
		request.getRequestDispatcher("/WEB-INF/jsp/checkin.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
