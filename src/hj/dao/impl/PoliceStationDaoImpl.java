package hj.dao.impl;

import hj.dao.PoliceStationDao;
import hj.entity.PoliceStation;
import hj.utils.Global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PoliceStationDaoImpl implements PoliceStationDao {
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private List<PoliceStation> policeStationList;
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
	 * @see hj.dao.impl.PoliceStationDao#add(hj.entity.PoliceStation)
	 */
	@Override
	public void add(PoliceStation ps){
		String sql = "insert into policestation (psid, name, address, contact) values ('"
				+ ps.getPsid() + "', '" + ps.getName() + "', '"
				+ ps.getAddress() + "', '" + ps.getContact() + "')";
		try {
			if(ps != null)
				st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/* (non-Javadoc)
	 * @see hj.dao.impl.PoliceStationDao#update(hj.entity.PoliceStation)
	 */
	@Override
	public void update(PoliceStation ps){
		String sql = "update policestation set name = '" + ps.getName() + "', address = '"
					+ ps.getAddress() + "', contact = '" + ps.getContact() 
					+ "' where psid = '" + ps.getPsid() + "'";
		System.out.println(sql);
		try {
			if(ps != null)
				st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	/* (non-Javadoc)
	 * @see hj.dao.impl.PoliceStationDao#setPoliceStationList()
	 */
	@Override
	public void setPoliceStationList() {
		String sql = "select * from policestation";
		policeStationList = new ArrayList<PoliceStation>();
		try {
			rs = st.executeQuery(sql);
			PoliceStation ps;
			while(rs.next()){
				ps = new PoliceStation();
				ps.setPsid(rs.getInt(1));
				ps.setName(rs.getString(2));
				ps.setAddress(rs.getString(3));
				ps.setContact(rs.getString(4));
				policeStationList.add(ps);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/* (non-Javadoc)
	 * @see hj.dao.impl.PoliceStationDao#find()
	 */
	@Override
	public List<PoliceStation> find(){
		setPoliceStationList();
		return policeStationList;
	}
	/* (non-Javadoc)
	 * @see hj.dao.impl.PoliceStationDao#find(java.lang.String)
	 */
	@Override
	public List<PoliceStation> find(String word){
		setPoliceStationList();
		String [] words = word.split(" ");
		List<PoliceStation> psl = new ArrayList<PoliceStation>();
		String temp;
		int i;
		for(PoliceStation p : policeStationList){
			temp = p.toString();
			for(i = 0; i < words.length; ++i){
				if(!temp.contains(words[i])){
					break;
				}
			}
			if(i == words.length){
				psl.add(p);
			}
		}
		if(psl.size() == 0) return null;
		return psl;
	}
	/* (non-Javadoc)
	 * @see hj.dao.impl.PoliceStationDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public List<PoliceStation> find(String key, String word){
	/*	System.out.println("key=" + key);
		System.out.println("word=" + word);*/
		setPoliceStationList();
		String [] words = word.split(" ");
		List<String> sa = new ArrayList<String>();
		List<PoliceStation> psl = new ArrayList<PoliceStation>();
		if (key.equals("psid")){
			for (PoliceStation p : policeStationList)
				sa.add(p.getPsid() + "");
		}
		if (key.equals("name")){
			for (PoliceStation p : policeStationList)
				sa.add(p.getName());
		}
		if (key.equals("address")){
			for (PoliceStation p : policeStationList)
				sa.add(p.getAddress());
		}
		if (key.equals("contact")){
			for (PoliceStation p : policeStationList)
				sa.add(p.getContact());
		}
		for(String s : sa){
			int i;
			for(i = 0; i < words.length; ++i){
				if(!s.contains(words[i])){
					break;
				}
			}
			if(i == words.length){
				psl.add(policeStationList.get(sa.indexOf(s)));
			}
		}
		if(psl.size() == 0) return null;
		return psl;
	}
	@Override
	public void finalize() {
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
	}	
}
