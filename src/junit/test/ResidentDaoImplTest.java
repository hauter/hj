package junit.test;

import hj.dao.ResidentDao;
import hj.dao.impl.ResidentDaoImpl;
import hj.entity.Resident;
import hj.exception.ResidentIdnumExistException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ResidentDaoImplTest {
	public static void main(String[] args) {
		ResidentDao c = new ResidentDaoImpl();
		boolean b = c.isChecking(10);
		System.out.println(b);
	}

	private static void checkinTest() {
		ResidentDao c = new ResidentDaoImpl();
		int rsid = 16;
		c.checkin(16);
	}

	private static void logoutTest() {
		ResidentDao c = new ResidentDaoImpl();
		int rsid = 16;
		c.logout(rsid);
	}

	private static void outTest() {
		ResidentDao c = new ResidentDaoImpl();
		int rsid = 16;
		c.out(rsid, 2);
	}

	private static void inTest() throws ResidentIdnumExistException {
		ResidentDao c = new ResidentDaoImpl();
		Resident r = new Resident();
		r.setName("薛蛮子");
		r.setSex("男");
		r.setIdnum("411627199205193720");
		r.setNation("汉");
		Calendar cal = Calendar.getInstance();
		cal.set(1992, 8, 19);
		r.setBirthday(cal.getTime());
		r.setContact("18236936461");
		r.setAddress("河南省太康县独塘乡王湾村");
		r.setUnit("河南工业大学信息科学与工程学院");
		r.setState(Resident.normal);
		r.setPsid(1);
		c.in(r,2);
	}

	private static void findTest() {
		ResidentDao c = new ResidentDaoImpl();
		List<Resident> l;
		System.out.println("-----------------find()--------------");
		 l = c.find();
		 if(l != null){
				for(Resident r : l){
					System.out.println(r);
				}
		}
		
		System.out.println("----------------find(word)------------");
		l = c.find("孙 铁");
		if(l != null){
			for(Resident r : l){
				System.out.println(r);
			}
		}
		
		System.out.println("-------------------find(key, word");
		l = c.find("name", "中");
		if(l != null){
			for(Resident r : l){
				System.out.println(r);
			}
		}
	}

	private static void setResidentTest() {
		ResidentDao c = new ResidentDaoImpl();
		c.setResident();
	}

	private static void updateResidentTest() {
		ResidentDao c = new ResidentDaoImpl();
		Resident r = new Resident();
		r.setRsid(6);
		r.setName("王中晴");
		r.setSex("男");
		r.setIdnum("411627199205193717");
		r.setNation("汉");
		Calendar cal = Calendar.getInstance();
		cal.set(1992, 8, 19);
		r.setBirthday(cal.getTime());
		r.setContact("18236936461");
		r.setAddress("河南省太康县独塘乡王湾村");
		r.setUnit("河南工业大学信息科学与工程学院");
		r.setState(Resident.normal);
		c.update(r);
	}

	private static void addToResidentTest() throws ResidentIdnumExistException {
		ResidentDao c = new ResidentDaoImpl();
		Resident r = new Resident();
		r.setName("王中晴");
		r.setSex("男");
		r.setIdnum("411627199205193717");
		r.setNation("汉");
		Calendar cal = Calendar.getInstance();
		cal.set(1992, 8, 19);
		r.setBirthday(cal.getTime());
		r.setContact("18236936461");
		r.setAddress("河南省太康县独塘乡王湾村");
		r.setUnit("河南工业大学");
		r.setPsid(1);
		c.add(r);
	}
	
}
