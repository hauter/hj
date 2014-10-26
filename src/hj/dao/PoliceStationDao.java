package hj.dao;

import hj.entity.PoliceStation;

import java.util.List;

public interface PoliceStationDao {
	void reloadDriver();
	void add(PoliceStation ps);

	void update(PoliceStation ps);

	void setPoliceStationList();

	List<PoliceStation> find();

	List<PoliceStation> find(String word);

	List<PoliceStation> find(String key, String word);
	void finalize();
}