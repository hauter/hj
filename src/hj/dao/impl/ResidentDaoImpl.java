package hj.dao.impl;

import hj.dao.ResidentDao;
import hj.entity.Resident;
import hj.exception.ResidentIdnumExistException;
import hj.utils.Global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentDaoImpl implements ResidentDao {
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private List< Resident> residentLise;
	static {
		try {
			Class.forName(Global.sqlConnector);
			conn = DriverManager.getConnection(Global.sqlurl,
					Global.sqlUsername, Global.sqlPassword);
			st = conn.createStatement();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void reloadDriver(){
		try {
			if (conn.isClosed()) {
				conn = DriverManager.getConnection(Global.sqlurl,
						Global.sqlUsername, Global.sqlPassword);
				st = conn.createStatement();
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	/* (non-Javadoc)
	 * @see hj.dao.impl.ResidentDao#add(hj.entity.Resident)
	 */
	@Override
	public void add(Resident resident) throws ResidentIdnumExistException {
		
		String sql1 = "insert into resident(name,sex, idnum, nation, birthday, contact, address, unit)values('"
				+ resident.getName() + "', '" + resident.getSex() + "', '" + resident.getIdnum() + "', '"
				+ resident.getNation() + "', '" + resident.getStringBirthday() + "', '"+ resident.getContact() + "', '" 
				+ resident.getAddress() + "', '" + resident.getUnit() + "')";
		String sql2 = "select rsid from resident where idnum = '" + resident.getIdnum() + "'";
		if(find("idnum", resident.getIdnum() ) != null ){
			throw new ResidentIdnumExistException();
		}
		try {
			//插入居民
			if(resident != null)
				st.executeUpdate(sql1);
			//查询id
			rs = st.executeQuery(sql2);
			int id = 0;
			if(rs.next())
				id = rs.getInt(1);
			String sql3 = "insert into memberof (rsid, psid) values ('" + id + "', '" + resident.getPsid() + "')";
			//插入隶属关系
			st.executeUpdate(sql3);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see hj.dao.impl.ResidentDao#updateResident(hj.entity.Resident, int)
	 */
	@Override
	public void update(Resident resident){
		String sql = "update resident set name = '" + resident.getName() +"', sex = '" + resident.getSex()
				+ "', nation = '" + resident.getNation() + "', birthday = '" + resident.getStringBirthday()
				+ "', contact = '" + resident.getContact() + "', address = '" + resident.getAddress()
				+ "', unit = '" + resident.getUnit() + "' where rsid = " + resident.getRsid();
		//System.out.println(sql);
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//获取居民信息
	/* (non-Javadoc)
	 * @see hj.dao.impl.ResidentDao#setResident()
	 */
	@Override
	public void setResident(){
		residentLise = new ArrayList<Resident>();
		String sql = "select * from resident";
		try {
			Resident re = null;
			rs = st.executeQuery(sql);
			while(rs.next()){
				re = new Resident();
				re.setRsid(rs.getInt(1));
				re.setName(rs.getString(2));
				re.setSex(rs.getString(3));
				re.setIdnum(rs.getString(4));
				re.setNation(rs.getString(5));
				re.setBirthday(rs.getDate(6));
				re.setContact(rs.getString(7));
				re.setAddress(rs.getString(8));
				re.setUnit(rs.getString(9));
				re.setState(rs.getInt(10));
				residentLise.add(re);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//查询
	/* (non-Javadoc)
	 * @see hj.dao.impl.ResidentDao#find()
	 */
	@Override
	public List<Resident> find(){
		setResident();
		return residentLise;
	}
	/* (non-Javadoc)
	 * @see hj.dao.impl.ResidentDao#find(java.lang.String)
	 */
	@Override
	public List<Resident> find(String word){
		setResident();
		String[] words = word.split(" ");
		List<Resident> rl = new ArrayList<Resident>();
		int i;
		String temp = "";
		for (Resident r : residentLise) {
			temp = r.toString();
			for (i = 0; i < words.length; ++i) {
				if (!temp.contains(words[i]))
					break;
			}
			if (i == words.length)
				rl.add(r);
		}
		//System.out.println(rl.size());
		if (rl.size() == 0) return null;
		return rl;
	}
	/* (non-Javadoc)
	 * @see hj.dao.impl.ResidentDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Resident> find (String key, String word){
		setResident();
		String [] words = word.split(" ");
		List<Resident> rl = new ArrayList<Resident>();
		List<String> sa = new ArrayList<String>();
		//System.out.println(key);
		//System.out.println(word);
		if(key.equals("rsid")){
			//System.out.println("dd");
			for(Resident r : residentLise)
				sa.add(r.getRsid() + "");
		}
		if(key.equals("name")){
			//System.out.println("dd");
			for(Resident r : residentLise)
				sa.add(r.getName());
		}
		if(key.equals("sex")){
			for(Resident r : residentLise)
				sa.add(r.getSex());
		}
		if(key.equals("idnum")){
			for(Resident r : residentLise)
				sa.add(r.getIdnum());
		}
		if(key.equals("nation")){
			for(Resident r : residentLise)
				sa.add(r.getNation());
		}
		if(key.equals("birthday")){
			for(Resident r : residentLise)
				sa.add(r.getBirthday() + "");
		}
		if(key.equals("contact")){
			for(Resident r : residentLise)
				sa.add(r.getContact());
		}
		if(key.equals("address")){
			for(Resident r : residentLise)
				sa.add(r.getAddress());
		}
		if(key.equals("unit")){
			for(Resident r : residentLise)
				sa.add(r.getUnit());
		}
		if(key.equals("state")){
			for(Resident r : residentLise)
				sa.add(r.getState() + "");
		}
		for(String s : sa){
			int i;
			for (i = 0; i < words.length; ++i) {
				if (!s.contains(words[i]))
					break;
			}
			if (i == words.length)
				rl.add(residentLise.get(sa.indexOf(s)));
		}
		if (rl.size() == 0) return null;
		return rl;
	}
	@Override
	/*public void finalize() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		}
	}*/
	//迁入
	public void in(Resident resident, int previousPS) throws ResidentIdnumExistException{
		add(resident);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		String sql1 = "select rsid from resident where idnum = '" + resident.getIdnum() + "'";
		try {
			//查询rsid
			int rsid = 0;
			rs = st.executeQuery(sql1);
			if(rs.next()){
				rsid = rs.getInt(1);
			}
			//插入inout（迁入)表
			String sql2 = "insert into `inout` ( rsid, previousPS, nowPS ) values ( '" + rsid + "', '"
					+ previousPS  + "', '" + Global.thisPsid + "')";
			st.executeUpdate(sql2);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//迁出
	public void out(int rsid, int nowPS){
		String sql1 = "update resident set state = '2' where rsid = " + rsid;
		String sql2 = "insert into `inout` ( rsid, previousPS, nowPS ) values ('" + rsid + "', '"
				+ Global.thisPsid + "', '" + nowPS + "')";
		System.out.println(sql1);
		System.out.println(sql2);
		try {
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//注销
	public void logout(int rsid){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(new Date());
		String sql1 = "update resident set state = '1' where rsid = " + rsid;
		String sql2 = "insert into logout (rsid, time) values('" + rsid + "', '"
				+ time + "')";
		try {
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//身份证办理
	public void checkin(int rsid){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(new Date());
		String sql = "insert into checkin (rsid, time) values('" + rsid + "', '"
				+ time + "')";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public boolean isChecking(int rsid){
		String sql = "select * from checkin where rsid = '" + rsid + "'";
		try{
			rs = st.executeQuery(sql);
			if(rs.next()){
				return true;
			}
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		return false;
	}
	
	
	
}
