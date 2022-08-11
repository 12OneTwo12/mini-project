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
	// 테이블 생성 메서드
//	public static void dropAndCreateTable() {
//		// 기존테이블 날리고 새로만들면 에러 안날꺼니까
//		final String dropTableQuery = "DROP TABLE IF EXISTS todo";
//		
//		// Statement : Query 전달 객체
//		Connection conn;
//		Statement stmt;
//		try {
//			conn = getConnection();
//			stmt = conn.createStatement();
//			stmt.execute(dropTableQuery); // 진행시키는 코드
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
