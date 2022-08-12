package dev.gifticon.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "minipjt";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	// java와 MySQL Database 연결 메서드
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}
}

