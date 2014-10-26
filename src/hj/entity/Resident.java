package hj.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
rsid int identity not null primary key,
name nvarchar(20) not null,
sex nchar(2) not null,
idnum char(20) not null,
nation nchar(20) not null,
birthday date not null,
contact char(20) not null,
address nvarchar(40) not null,
unit nvarchar(40),
state tinyint default (0)
*/
public class Resident {
	private int rsid;
	private String name;
	private String sex;
	private String idnum;	//身份证号
	private String nation;	//民族
	private Date birthday;
	private String contact;
	private String address;
	private String unit;	//所在单位
	private int state;
	private int psid;		//隶属的派出所编号, policestation表
	
	//state的类型
	public static final int  normal = 0;
	public static final int deleted = 1;
	public static final int outed = 2;
	
	public int getPsid() {
		return psid;
	}
	public void setPsid(int psid) {
		this.psid = psid;
	}
	public int getRsid() {
		return rsid;
	}
	public void setRsid(int rsid) {
		this.rsid = rsid;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStringBirthday(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(birthday);
	}
	@Override
	public String toString() {
		return getRsid() + "," + getName() + "," + getSex() + "," + getIdnum().trim() + ","
				+ getNation().trim() + "," + getStringBirthday() + "," + getContact().trim() + ","
				+ getAddress() + "," + getUnit() + "," + getState();
	}
	public boolean checkInfo(){
		if(getRsid() == 0) return false;
		if(getName() == null) return false;
		if(getSex() == null) return false;
		if(getIdnum() == null) return false;
		if(getNation() == null) return false;
		if(getBirthday() == null) return false;
		if(getContact() == null) return false;
		if(getAddress() == null) return false;
		if(getUnit() == null) return false;
		if(getState() < 0 || getState() > 2) return false;
		if(getPsid() == 0) return false;
		return true;
	}
}
