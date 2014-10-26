package hj.entity;

public class PoliceStation {
	/*
	psid int not null primary key,
	name nvarchar(40) not null,
	address nvarchar(40) not null,
	contact char(20) not null
	*/
	
	private int psid;
	private String name;
	private String address;
	private String contact;
	public int getPsid() {
		return psid;
	}
	public void setPsid(int psid) {
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
	@Override
	public String toString(){
		return getPsid() + "," + getName() + "," + getAddress() + "," + getContact();
	}
	public boolean checkInfo(){
		if(getPsid() == 0) return false;
		if(getName() == null) return false;
		if(getAddress() == null) return false;
		if(getContact() == null) return false;
		return true;
	}
	
	
}
