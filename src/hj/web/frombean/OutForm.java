package hj.web.frombean;

import java.util.HashMap;
import java.util.Map;

public class OutForm {
	private String rsid;
	private String oldPS;
	private String nowPS;
	Map errors = new HashMap();
	
	
	
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getRsid() {
		return rsid;
	}
	public void setRsid(String rsid) {
		this.rsid = rsid;
	}
	public String getOldPS() {
		return oldPS;
	}
	public void setOldPS(String oldPS) {
		this.oldPS = oldPS;
	}
	public String getNowPS() {
		return nowPS;
	}
	public void setNowPS(String nowPS) {
		this.nowPS = nowPS;
	}
	
	public boolean validate(){
		boolean isOK = true;
		if(nowPS == null || nowPS.trim().equals("")){
			isOK = false;
			errors.put("psid", "派出所编号不能为空");
		}else{
			if(!nowPS.matches("\\d{4}")){
				isOK = false;
				errors.put("psid", "派出所编号为4为数字");
			}
			if(nowPS.equals(oldPS)){
				isOK = false;
				errors.put("psid", "派出所编号未变化");
			}
		}
		return isOK;
	}
	
}
