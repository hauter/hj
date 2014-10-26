package hj.web.frombean;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	private String id;
	private String password1;
	private String password2;
	private String userName;
	private String realName;
	private String checkCodeC;	//clinet 提交的验证码
	private String checkCodeS;	//server 内保存的验证码
	private Map errors = new HashMap();
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
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
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	//服务器端表单验证
	public boolean validate(){
		boolean isOK = true;
		//1. id必须为6位的数字
		if(id == null || id.trim().equals("")){
			isOK = false;
			errors.put("id", "警号不能为空");
		}else{
			if(!id.matches("\\d{6}")){
				isOK = false;
				errors.put("id", "警号为六位数字");
			}
		}		
		
		//2.密码为6~18的字母数字
		if(password1 == null || password1.trim().equals("")){
			isOK = false;
			errors.put("password1", "密码不能为空");
		}else{
			if(!password1.matches("[0-9A-Za-z_]{6,18}")){
				isOK = false;
				errors.put("password1", "密码必须是6~18位数字字母下划线");
			}
		}
		
		//3.确认密码必须和第一次输入相同
		if(password2 == null || password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "确认密码不能为空");
		}else{
			if(!password2.equals(password1)){
				isOK = false;
				errors.put("password2", "两次输入的密码不一致");
			}
		}
		//4.用户名至少3位数字字母下划线
		if(userName == null || userName.trim().equals("")){
			isOK = false;
			errors.put("userName", "用户名不能为空");
		}else{
			if(!userName.matches("[0-9A-Za-z_]{3,15}")){
				isOK = false;
				errors.put("userName", "3~15位数字字母下划线");
			}
		}
		
		
		//5.真实姓名必须是中国汉字
		if(realName == null || realName.trim().equals("")){
			isOK = false;
			errors.put("realName", "真实姓名不能为空");
		}else{
			if(!realName.matches("[\u4e00-\u9fff]{2,}")){
				isOK = false;
				errors.put("realName", "请输入真实的姓名");
			}
		}
		
		
		//6.验证码必须正确
		
		//System.out.println("C=" + checkCodeC);
		//System.out.println("S=" + checkCodeS);
		if(checkCodeC == null || checkCodeC.trim().equals("")){
			isOK = false;
			errors.put("checkCode", "验证码不能为空");
		}else{
			if(!checkCodeC.equals(checkCodeS)){
				isOK = false;
				errors.put("checkCode", "验证码错误");
			}
		}
		return isOK;
	}
	
	
}
