package hj.service.impl;

import hj.dao.PoliceStationDao;
import hj.dao.impl.PoliceStationDaoImpl;
import hj.entity.PoliceStation;
import hj.exception.PoliceStationIDExistException;
import hj.exception.PoliceStationInfoIncompleteException;

import java.util.List;


public class PoliceStationServiceImpl {
	private PoliceStationDao dao = new PoliceStationDaoImpl();
	/*void add(PoliceStation ps);

	void update(PoliceStation ps);

	void setPoliceStationList();

	List<PoliceStation> find();

	List<PoliceStation> find(String word);

	List<PoliceStation> find(String key, String word);
	void finalize();
	*/
	
	public void add(PoliceStation ps) throws PoliceStationIDExistException{
		dao.reloadDriver();
		List list = dao.find("psid", ps.getPsid() + "");
		if(list != null){
			throw new PoliceStationIDExistException();
		}
		dao.add(ps);
	}
	public void update(PoliceStation ps){
		dao.reloadDriver();
		dao.update(ps);

	}
	public List<PoliceStation> find(){
		dao.reloadDriver();
		return dao.find();
	}
	public List<PoliceStation> find(String word){
		dao.reloadDriver();
		return dao.find(word);
	}
	public List<PoliceStation> find(String key, String word){
		dao.reloadDriver();
		return dao.find(key, word);
	}
}
