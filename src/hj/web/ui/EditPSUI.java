package hj.web.ui;

import hj.entity.PoliceStation;
import hj.service.impl.PoliceStationServiceImpl;
import hj.utils.WebUtils;
import hj.web.frombean.PoliceStationForm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditPSUI extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否登录
		if (!WebUtils.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		String psid = request.getParameter("psid");
		PoliceStationServiceImpl service = new PoliceStationServiceImpl();
		List<PoliceStation> pslist = service.find("psid", psid);
		if(pslist == null){
			request.setAttribute("badMessage", "服务器异常");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		PoliceStation PoliceStation = pslist.get(0);
		PoliceStationForm editpsform = WebUtils.PSBeanToPSForm(PoliceStation);
		request.setAttribute("editpsform", editpsform);
		request.getRequestDispatcher("/WEB-INF/jsp/editps.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
