package hj.dao;

import hj.entity.Resident;
import hj.exception.ResidentIdnumExistException;

/*import java.text.SimpleDateFormat;
import java.util.Date;*/
import java.util.List;

public interface ResidentDao {
	void reloadDriver();
	void add(Resident resident) throws ResidentIdnumExistException;

	// 获取居民信息
	void setResident();

	// 查询
	List<Resident> find();

	List<Resident> find(String word);

	List<Resident> find(String key, String word);

	void update(Resident resident);
	/*void finalize();*/
	void in(Resident resident, int previousPS) throws ResidentIdnumExistException;
	void out(int rsid, int nowPS);
	
	void logout(int rsid);
	
	public void checkin(int rsid);
	public boolean isChecking(int rsid);
	
}