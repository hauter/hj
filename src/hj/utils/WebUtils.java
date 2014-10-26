package hj.utils;

import hj.entity.Police;
import hj.entity.PoliceStation;
import hj.entity.Resident;
import hj.web.frombean.InForm;
import hj.web.frombean.PoliceStationForm;
import hj.web.frombean.ResidentForm;
import hj.web.frombean.RegisterForm;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	//提交的表达请求封装成FormBean
	public static <T> T requestToFormBean(HttpServletRequest request, Class<T> beanClass){
		try {
			T bean = beanClass.newInstance();
			String name;
			String value;
			
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				name = (String)e.nextElement();
				value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
				//System.out.println(name + " = " + value);
			}
			//System.out.println("new CheckCodeS=" + request.getSession().getAttribute("checkCodeS"));
			BeanUtils.setProperty(bean, "checkCodeS", request.getSession().getAttribute("checkCodeS"));
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//将formBean 转化为 PoliceBean
	public static Police getPoliceBeanByFromBean(RegisterForm rf){
		Police p = new Police();
		p.setId(rf.getId());
		p.setUserName(rf.getUserName());
		p.setRealName(rf.getRealName());
		p.setPassword(rf.getPassword1());
		return p;
	}
	
	//将添加到AddResidentForm 转为Resident
	public static Resident getResidentBeanByAddResidentFormBean(ResidentForm addForm){
		Resident r = new Resident();
		r.setName(addForm.getName());
		r.setSex(addForm.getSex());
		r.setIdnum(addForm.getIdnum());
		r.setNation(addForm.getNation());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date birthday =  format.parse(addForm.getBirthday());
			r.setBirthday(birthday);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		r.setContact(addForm.getContact());
		r.setAddress(addForm.getAddress());
		r.setUnit(addForm.getUnit());
		r.setState(new Integer(addForm.getState()).intValue());
		r.setPsid(new Integer(addForm.getPsid()).intValue());	
		return r;
	}
	//将添加到AddResidentForm 转为Resident
		public static Resident getResidentBeanByEditFormBean(ResidentForm editform){
			Resident r = new Resident();
			r.setRsid(new Integer(editform.getRsid()).intValue());
			r.setName(editform.getName());
			r.setSex(editform.getSex());
			r.setIdnum(editform.getIdnum());
			r.setNation(editform.getNation());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date birthday =  format.parse(editform.getBirthday());
				r.setBirthday(birthday);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
			r.setContact(editform.getContact());
			r.setAddress(editform.getAddress());
			r.setUnit(editform.getUnit());
			r.setState(new Integer(editform.getState()).intValue());
			r.setPsid(new Integer(editform.getPsid()).intValue());	
			return r;
		}
	public static boolean isLogin(HttpServletRequest request){
		//验证是否登录
		Object police = request.getSession().getAttribute("police");
		if(police == null){
			return false;
		}else{
			return true;
		}
	}
	public static ResidentForm ResidentToResidentForm(Resident resident){
		ResidentForm form = new ResidentForm();
		
		form.setRsid(resident.getRsid() + "");
		form.setName(resident.getName().trim());
		form.setSex(resident.getSex().trim());
		form.setIdnum(resident.getIdnum().trim());
		form.setNation(resident.getNation().trim());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String bir = format.format(resident.getBirthday());		
		form.setBirthday(bir);
		form.setContact(resident.getContact().trim());
		form.setAddress(resident.getAddress().trim());
		form.setUnit(null);
		if(resident.getUnit() != null){
			form.setUnit(resident.getUnit().trim());
		}
		form.setState(resident.getState() + "");
		form.setPsid("0001");
		return form;
	}
	public static Resident getResidentBeanByInFormBean(InForm inForm){
		Resident r = new Resident();
		r.setName(inForm.getName());
		r.setSex(inForm.getSex());
		r.setIdnum(inForm.getIdnum());
		r.setNation(inForm.getNation());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date birthday =  format.parse(inForm.getBirthday());
			r.setBirthday(birthday);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		r.setContact(inForm.getContact());
		r.setAddress(inForm.getAddress());
		r.setUnit(inForm.getUnit());
		r.setState(new Integer(inForm.getState()).intValue());
		r.setPsid(new Integer(inForm.getPsid()).intValue());	
		return r;
	}
	
	public static PoliceStation PSFormToPSBean(PoliceStationForm form){
		PoliceStation ps = new PoliceStation();
		ps.setPsid(new Integer(form.getPsid()));
		ps.setName(form.getName());
		ps.setAddress(form.getAddress());
		ps.setContact(form.getContact());
		return ps;
	}
	public static PoliceStationForm PSBeanToPSForm(PoliceStation ps){
		PoliceStationForm form = new PoliceStationForm();
		form.setPsid(String.format("%04d", ps.getPsid()));
		form.setName(ps.getName());
		form.setContact(ps.getContact().trim());
		form.setAddress(ps.getAddress());		
		return form;
	}
}