package junit.test;

import java.util.ArrayList;
import java.util.List;

import hj.dao.impl.PoliceStationDaoImpl;
import hj.entity.PoliceStation;

public class PoliceStationDaoImplTest {
	public static void main(String [] args){
		findTest();
	}

	private static void findTest() {
		PoliceStationDaoImpl psdi = new PoliceStationDaoImpl();
		List<PoliceStation> psl = new ArrayList<PoliceStation>();
		System.out.println("----------------find()-------------------");
		psl = psdi.find();
		if(psl != null){
			for(PoliceStation p : psl){
				System.out.println(p);
			}
		}
		
		System.out.println("----------------------find(word)--------------");
		psl = psdi.find("城 裴");
		if(psl != null){
			for(PoliceStation p : psl){
				System.out.println(p);
			}
		}
		
		System.out.println("----------------------find(key, word)--------------");
		psl = psdi.find("name", "1");
		if(psl != null){
			for(PoliceStation p : psl){
				System.out.println(p);
			}
		}
	}

	private static void updateTest() {
		PoliceStationDaoImpl psdi = new PoliceStationDaoImpl();
		PoliceStation ps = new PoliceStation();
		ps.setPsid(2);
		ps.setName("河南省漯河市郾城区新店派出所");
		ps.setAddress("河南省漯河市郾城区新店镇");
		ps.setContact("0372-123456");
		psdi.update(ps);
	}

	private static void addTest() {
		PoliceStationDaoImpl psdi = new PoliceStationDaoImpl();
		PoliceStation ps = new PoliceStation();
		ps.setPsid(2);
		ps.setName("河南省漯河市郾城区新店派出所");
		ps.setAddress("河南省漯河市郾城区新店镇");
		ps.setContact("123456");
		psdi.add(ps);
	}
}
