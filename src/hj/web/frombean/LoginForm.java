package hj.web.frombean;

import java.util.HashMap;
import java.util.Map;

public class LoginForm {
	private String userName;
	private String password;
	private String checkCodeC;
	private String checkCodeS;
	private Map errors = new HashMap();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCheckCodeC() {
		return checkCodeC;
	}
	public void setCheckCodeC(String checkCodeC) {
		this.checkCodeC = checkCodeC;
	}
	public String getCheckCodeS() {
		return checkCodeS;
	}
	public void setCheckCodeS(String checkCodeS) {
		this.checkCodeS = checkCodeS;
	}
	public Map getErrors() {
		return errors;
	}
	public void setErrorsl(Map errors) {
		this.errors = errors;
	}
	
	public boolean validate(){
		boolean isOK = true;
		
		if(userName == null || userName.trim().equals("")){
			isOK = false;
			errors.put("userName", "用户名不能为空");
		}
		if(password == null || password.trim().equals("")){
			isOK = false;
			errors.put("password", "密码不能为空");
		}
		if(checkCodeC == null || checkCodeC.trim().equals("")){
			isOK = false;
			errors.put("checkCodeC", "验证码不能为空");
		}else{
			if(!checkCodeC.equals(checkCodeS)){
				isOK = false;
				errors.put("checkCodeC", "验证码错误");
			}
		}
		return isOK;
	}
}
