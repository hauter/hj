package hj.service.impl;

import hj.dao.PoliceStationDao;
import hj.dao.ResidentDao;
import hj.dao.impl.PoliceStationDaoImpl;
import hj.dao.impl.ResidentDaoImpl;
import hj.entity.Resident;
import hj.exception.PoliceStationNotFoundException;
import hj.exception.ResidentIdnumExistException;
import hj.exception.ResidentInfoIncompleteException;
import hj.exception.ResidentNotFoundException;

import java.util.List;


public class ResidentServiceImpl {
	private ResidentDao dao = new ResidentDaoImpl();
/*	void add(Resident resident);
	void setResident();
	List<Resident> find();
	List<Resident> find(String word);
	List<Resident> find(String key, String word);
	void update(Resident resident, int sourceID);
	void finalize();
	void in(Resident resident, int previousPS);
	void out(int rsid, int nowPS);
	void logout(int rsid);
	public void checkin(int rsid);
*/
	public void add(Resident resident) throws ResidentIdnumExistException{
		dao.reloadDriver();
		dao.add(resident);
	}
	public void update(Resident resident) throws ResidentIdnumExistException{
		dao.reloadDriver();
		dao.update(resident);
		
	}
	public List<Resident> find(){
		dao.reloadDriver();
		return dao.find();
	}
	public List<Resident> find(String word){
		dao.reloadDriver();
		return dao.find(word);
	}
	public List<Resident> find(String key, String word){
		dao.reloadDriver();
		//System.out.println("---------");
		//System.out.println("key:" + key + " word:" + word);
		return dao.find(key, word);
	}
	public void in(Resident resident, int previousPS) throws ResidentInfoIncompleteException, ResidentIdnumExistException, PoliceStationNotFoundException{
		dao.reloadDriver();
		PoliceStationDao station = new PoliceStationDaoImpl();
		List stations = station.find("psid", previousPS + "");
		if(stations == null){
			throw new PoliceStationNotFoundException();
		}
		dao.in(resident, previousPS);
	}
	public void out(int rsid, int nowPS) throws PoliceStationNotFoundException{
		dao.reloadDriver();
		PoliceStationDao station = new PoliceStationDaoImpl();
		List stations = station.find("psid", nowPS + "");
		if(stations == null){
			throw new PoliceStationNotFoundException();
		}
		dao.out(rsid, nowPS);
	}
	public void logout(int rsid){
		dao.reloadDriver();
		dao.logout(rsid);
	}
	public void checkin(int rsid) throws ResidentNotFoundException{
		dao.reloadDriver();
		List list = find("rsid", rsid + "");
		if(list == null){
			throw new ResidentNotFoundException();
		}
		dao.checkin(rsid);
	}
	public boolean isChecking(int rsid){
		dao.reloadDriver();
		return dao.isChecking(rsid);
	}
}
