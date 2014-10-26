package hj.web.frombean;

import hj.utils.Global;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class InForm {
	private String rsid;
	private String name;
	private String sex;
	private String idnum;	//身份证号
	private String nation;	//民族
	private String birthday;
	private String contact;
	private String address;
	private String unit;	//所在单位
	private String state;
	private String oldPS;
	private String psid;
	private Map errors = new HashMap();
	
	
	
	public String getOldPS() {
		return oldPS;
	}
	public void setOldPS(String oldPS) {
		this.oldPS = oldPS;
	}
	public String getRsid() {
		return rsid;
	}
	public void setRsid(String rsid) {
		this.rsid = rsid;
	}
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPsid() {
		return psid;
	}
	public void setPsid(String psid) {
		this.psid = psid;
	}
	public boolean validate(){
		boolean isOK = true;
		if(name == null || name.trim().equals("")){
			isOK = false;
			errors.put("name", "姓名不能为空!");
		}else{
			if(!name.matches("[\u4e00-\u9fa5]{2,}")){
				isOK = false;
				errors.put("name", "姓名不合法");
			}
		}
		if(sex == null || sex.trim().equals("")){
			isOK = false;
			errors.put("sex", "请选择性别");
		}else{
			if( !( sex.equals("男") || sex.equals("女") ) ){
				isOK = false;
				errors.put("sex", "性别无效");
			}
		}
		if(idnum == null || idnum.trim().equals("")){
			isOK = false;
			errors.put("idnum", "身份证号不能为空");
		}else{
			if(idnum.length() != 18 || !idnum.matches("\\d{17}[0-9X]")){
				//System.out.println(idnum.substring(0,17));
				isOK = false;
				errors.put("idnum", "身份证不合法");
			}
		}
		if(nation == null || nation.trim().equals("")){
			isOK = false;
			errors.put("nation", "请选择民族");
		}else{
			String allNation = "汉族 蒙古族 回族 藏族 维吾尔族 苗族 彝族 壮族 布依族 " +
					"朝鲜族 满族 侗族 瑶族 白族 土家族 哈尼族 哈萨克族 傣族 黎族 傈僳族 " +
					"佤族 畲族 高山族 拉祜族 水族 东乡族 纳西族 景颇族 柯尔克孜族 土族 " +
					"达斡尔族 仫佬族 羌族 布朗族 撒拉族 毛南族 仡佬族 锡伯族 阿昌族 " +
					"普米族 塔吉克族 怒族 乌孜别克族 俄罗斯族 鄂温克族 德昂族 保安族 " +
					"裕固族 京族 塔塔尔族 独龙族 鄂伦春族 赫哲族 门巴族 珞巴族 基诺族 ";
			if(!allNation.contains(nation)){
				isOK = false;
				errors.put("nation", "民族不合法");
			}
		}
		if(birthday == null || birthday.trim().equals("")){
			isOK = false;
			errors.put("birthday", "生日不能为空");
		}else{
			try{
				DateLocaleConverter converter = new DateLocaleConverter();
				converter.convert(birthday, "yyyy-MM-dd");
			}catch(Exception e){
				isOK = false;
				errors.put("birthday", "生日不合法");
			}
		}
		//如果填写联系方式
		if(contact != null){
			//如果填入的是空白符
			if(contact.trim().equals("")){
				contact = null;
			}else{
				//不是空白符,但不是至少7位数字
				if(!contact.replace("-", "").matches("\\d{7,}")){
					isOK = false;
					errors.put("contact", "联系方式不合法");
				}
			}
		}
		if(address == null || address.trim().equals("")){
			isOK = false;
			errors.put("address", "地址不能为空");
		}

		/*if(state != null && state.equals("正常")){
			state = "0";
		}else{
			isOK = false;
			errors.put("state", "状态描述不合法");
		}*/
		if(state == null || state.trim().equals("")){
			isOK = false;
			errors.put("state", "状态描述不能为空");
		}else{
			if(state.equals("正常")){
				state = "0";
			}else if(state.equals("注销")){
				state = "1";
			}else if(state.equals("迁出")){
				state = "2";
			}else{
				isOK = false;
				errors.put("state", "状态描述无效");
			}
		}
		/*if(psid != null && psid.equals(Global.thisName)){
			psid = Global.thisPsid + "";
		}else{
			isOK = false;
			errors.put("psid", "隶属派出所有误");
		}*/
		
		if(oldPS == null || oldPS.trim().equals("")){
			isOK = false;
			errors.put("oldPS", "派出所编号不能为空");
		}else{
			if(!oldPS.matches("\\d{4}")){
				isOK = false;
				errors.put("oldPS", "派出所编号为4为数字");
			}
			if(oldPS.equals(psid)){
				isOK = false;
				errors.put("oldPS", "派出所编号错误");
			}
		}
		
		if(psid == null || psid.trim().equals("")){
			isOK = false;
			errors.put("psid", "派出所编号不能为空");
		}else{
			if(!psid.matches("\\d{4}")){
				isOK = false;
				errors.put("psid", "派出所编号为4为数字");
			}
			
		}
		
		
		return isOK;
	}
	
	
	
	
	
	
	
	
	
	
	
}
