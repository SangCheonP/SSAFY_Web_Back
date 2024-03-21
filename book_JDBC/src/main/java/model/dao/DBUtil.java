package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3303/testdb?serverTimezone=UTC";
	private static final String user = "ssafy";
	private static final String pass = "ssafy";
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	
	private DBUtil() {};
	private DBUtil dbUtil = new DBUtil();
	public DBUtil getInstance() {
		return dbUtil;
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url, user, pass);
		}catch (SQLException | ClassNotFoundException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close(AutoCloseable...autoCloseables) {
		for(AutoCloseable c : autoCloseables) {
			if(c != null) {
				try {
					c.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
