package dev.gifticon.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
//	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_NAME = "minipjt";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	// java와 MySQL Database 연결 메서드
	public static Connection getConnection() throws SQLException {
		//Class.forName(DRIVER_NAME); 드라이버 로딩한다는 의미 레거시 코드에는 있을수있음, JDBC 4.0 이후로 모든 드라이버들은 클래스패스에서 자동으로 로딩됨
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}
}

