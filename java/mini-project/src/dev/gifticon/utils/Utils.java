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

	// java�� MySQL Database ���� �޼���
	public static Connection getConnection() throws SQLException {
		//Class.forName(DRIVER_NAME); ����̹� �ε��Ѵٴ� �ǹ� ���Ž� �ڵ忡�� ����������, JDBC 4.0 ���ķ� ��� ����̹����� Ŭ�����н����� �ڵ����� �ε���
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}
}
	// ���̺� ���� �޼���
//	public static void dropAndCreateTable() {
//		// �������̺� ������ ���θ���� ���� �ȳ����ϱ�
//		final String dropTableQuery = "DROP TABLE IF EXISTS todo";
//		
//		// Statement : Query ���� ��ü
//		Connection conn;
//		Statement stmt;
//		try {
//			conn = getConnection();
//			stmt = conn.createStatement();
//			stmt.execute(dropTableQuery); // �����Ű�� �ڵ�
//			
//			final String createTableQuery = 
//		            "CREATE TABLE todo (" +
//		            "id INT(5) unsigned NOT NULL AUTO_INCREMENT," +
//		            "title VARCHAR(255)," +
//		            "description VARCHAR(255)," +
//		            "due_date DATE," +
//		            "is_completed BOOLEAN DEFAULT false," +
//		            "PRIMARY KEY (id))"; 
//			
//			stmt.execute(createTableQuery);
//			System.out.println("Table has created.");
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
