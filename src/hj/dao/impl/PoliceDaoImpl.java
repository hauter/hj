package hj.dao.impl;

import hj.dao.PoliceDao;
import hj.entity.Police;
import hj.utils.Global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PoliceDaoImpl implements PoliceDao{
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
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
	 * @see hj.dao.impl.PoliceDao#add(hj.entity.Police)
	 */
	@Override
	public void add(Police police) {
		String sql = "insert into police values ( '" + police.getId() + "', '"
				+ police.getUserName() + "', '" + police.getRealName() + "', '"
				+ police.getPassword() + "' )";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see hj.dao.impl.PoliceDao#check(java.lang.String, java.lang.String)
	 */
	@Override
	public Police check(String userName, String password) {
		String sql = "select * from police where userName = '" + userName
				+ "' and password = '" + password + "'";

		try {
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Police police = new Police();
				police.setId(rs.getString(1));
				police.setUserName(rs.getString(1));
				police.setRealName(rs.getString(3));
				police.setPassword(rs.getString(4));
				return police;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see hj.dao.impl.PoliceDao#find(java.lang.String)
	 */
	@Override
	public boolean findByID(String id){
		//System.out.println(id);
		String sql = "select * from police where id = '" + id + "'";
		
		try {
			rs = st.executeQuery(sql);
			if (rs.next()) return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return false;
	}
	public boolean findByUserName(String userName){
		String sql = "select * from police where username = '" + userName + "'";

		try {
			rs = st.executeQuery(sql);
			if (rs.next()) return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see hj.dao.impl.PoliceDao#finalize()
	 */
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
