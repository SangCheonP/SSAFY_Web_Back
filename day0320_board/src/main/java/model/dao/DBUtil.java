package model.dao;

import java.sql.*;

public class DBUtil {
	private static final String db_driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
	private static final String username = "ssafy";
	private static final String userpw = "ssafy";
	
	
	// 실행할 프로그램이 데이터베이스에 접속하기 위해 커넥션을 뚫어서 주는 메소드
	public static Connection makeConnection() {
		try {
			Class.forName(db_driver);  // 버전에 따라 생략되기도 함.
			return DriverManager.getConnection(url, username, userpw); // 커넥션 객체 생성해서 리턴
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("커넥션 생성중 오류");
			e.printStackTrace();
		}
		return null;
	}
	
	// Connection, Statement, PreparedStatement, ResultSet 같은 리소스를 종료할 때 사용할 메소드
	public static void close(AutoCloseable... closeable) {
		for(AutoCloseable c: closeable) {
			if(c != null) {
				try {
					c.close();
				} catch (Exception e) {
					System.out.println("여기 close 도중 catch는 살면서 아직까지는 못봄...;;");
					e.printStackTrace();
				}
			}
		}
	}
}



