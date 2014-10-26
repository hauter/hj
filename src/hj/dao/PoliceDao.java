package hj.dao;

import hj.entity.Police;

public interface PoliceDao {
	void reloadDriver();
	void add(Police police);

	Police check(String userName, String password);
	void finalize();

	boolean findByID(String id);
	boolean findByUserName(String userName);

}