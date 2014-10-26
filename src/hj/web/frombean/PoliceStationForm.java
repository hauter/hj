package hj.web.frombean;

import java.util.HashMap;
import java.util.Map;

public class PoliceStationForm {
	private String psid;
	private String name;
	private String address;
	private String contact;
	private Map errors = new HashMap();
	public String getPsid() {
		return psid;
	}
	public void setPsid(String psid) {
		this.psid = psid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	
	public boolean validate(){
		boolean isOK = true;
		if(psid == null || psid.trim().equals("")){
			isOK = false;
			errors.put("psid", "编号不能为空");
		}else{
			if(!psid.matches("\\d{4}")){
				isOK = false;
				errors.put("psid", "编号为四位数字");
			}
		}
		if(name == null || name.trim().equals("")){
			isOK = false;
			errors.put("name", "名字不能为空");
		}else{
			if(!name.matches("[\u4e00-\u9fa5]{4,}")){
				isOK = false;
				errors.put("name", "名字错误");
			}
		}
		if(address == null || address.trim().equals("")){
			isOK = false;
			errors.put("address", "地址不能为空");
		}else{
			if(!address.matches("[\u4e00-\u9fa5]{4,}")){
				isOK = false;
				errors.put("address", "地址错误");
			}
		}
		if(contact == null || contact.trim().equals("")){
			isOK = false;
			errors.put("contact", "联系方式不能为空");
		}else{
			if(!contact.replace("-", "").matches("\\d{7,}")){
				isOK = false;
				errors.put("contact", "联系方式不合法");
			}
		}
		
		return isOK;
	}
	
	
}
