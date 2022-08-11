package dev.gifticon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.gifticon.model.Gifticon;
import dev.gifticon.utils.Utils;

public class DAO {

	private Connection connection; // con, conn
	private Statement statement; // stmt
	private PreparedStatement preparedStatement;
	private ResultSet resultSet; // rs
	private Gifticon gifticon;
	
	public List<Gifticon> findBySerialNumbers(String SerialNumber) {
		List<Gifticon> gifticons = new ArrayList<>();
		final String selectQuery = "SELECT * FROM record INNER JOIN gifticon ON record.gifticon_id = gifticon.gifticon_id WHERE serial_number = ?;";

		try (Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, SerialNumber);
				ResultSet resultSet = preparedStatement.executeQuery();) {

			while (resultSet.next()) {
				Gifticon gifticon = new Gifticon(resultSet.getInt("record_id"), resultSet.getInt("gifticon_id"),
						resultSet.getDate("payment_date").toLocalDate(), resultSet.getInt("used_amount"),
						resultSet.getInt("amount"));
				gifticons.add(gifticon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return gifticons;
	}

	PreparedStatement createPreparedStatement(Connection connection, String sql, String SerialNumber)
			throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, SerialNumber);

		return preparedStatement;
	}

	public Gifticon findBySerialNumber(String SerialNumber) {

		final String selectQuery = "SELECT * FROM gifticon WHERE serial_number = ?;";

		try (Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, SerialNumber);
				ResultSet resultSet = preparedStatement.executeQuery();) {

			while (resultSet.next()) {
				Gifticon gifticon = new Gifticon(resultSet.getInt("gifticon_id"),
												 resultSet.getDate("expiry_date").toLocalDate(), 
												 resultSet.getInt("amount"),
												 resultSet.getString("serial_number"));
				
				return gifticon;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private PreparedStatement createPreparedStatement(Connection connection, String sql, int gifticon_id) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, gifticon_id);
		return preparedStatement;
	}
	private PreparedStatement createStatement(Connection connection, String sql, Gifticon gifticon) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, gifticon.getSerialNumber());
		return preparedStatement;
	}
	
	public boolean zeroAmount(Gifticon gifticon) {
		final String selectQuery = "UPDATE gifticon SET amount = -1 WHERE serial_number = ?;" ;

		try (Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = createStatement(connection, selectQuery, gifticon);
				) {
				preparedStatement.executeUpdate();
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private PreparedStatement useAmoutStatement1(Connection connection, String sql, Gifticon gifticon, int i) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, gifticon.getAmount()-i);
		preparedStatement.setString(2, gifticon.getSerialNumber());
		
		return preparedStatement;
	}
	
	private PreparedStatement useAmoutStatement2(Connection connection, String sql, Gifticon gifticon, int i) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, gifticon.getGifticonId());
		preparedStatement.setString(2, LocalDate.now().toString());
		preparedStatement.setInt(3, i);
		
		return preparedStatement;
	}
	
	
	public boolean useAmount1(Gifticon gifticon, int i) {
		final String selectQuery = "UPDATE gifticon SET amount = ? WHERE serial_number = ?;" ;

		try (Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = useAmoutStatement1(connection, selectQuery, gifticon,i);
				) {
				preparedStatement.executeUpdate();
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean useAmount2(Gifticon gifticon, int i) {
		final String selectQuery = "INSERT INTO record (gifticon_id, payment_date, used_amount) VALUES(?, ?, ?);" ;

		try (Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = useAmoutStatement2(connection, selectQuery, gifticon,i);
				) {
				preparedStatement.executeUpdate();
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean save(Gifticon gifticon) {
		final String selectQuery = "INSERT INTO gifticon(serial_number, amount, expiry_date) VALUES(?, ?, ?);";

		try (Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = createGifticonStatement(connection, selectQuery, gifticon);
				){
				preparedStatement.executeUpdate();
				return true;
				
		} catch (Exception e){
			return false;
		}
		
	}	
		
	private PreparedStatement createGifticonStatement(Connection connection, String sql, Gifticon gifticon) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, gifticon.getSerialNumber());
		preparedStatement.setInt(2, gifticon.getAmount());
		preparedStatement.setString(3, gifticon.getExpiryDate().toString());
		return preparedStatement;
	}

	public Gifticon updateById(int id, Gifticon newTodo) {
		return null;
	}

	public boolean deleteById(int id) {
		return false;
	}

	// FindbyId - Record
	public Gifticon findByIdRecord(int record_id) {
		final String selectQuery = "SELECT * FROM record WHERE record_id = ?"; // ? 를 이용해서 int GifticonNumber를 바인딩한다.
		Gifticon record = null;

		// try-with resource 문법 -> 자원반납안해도됨 알아서 try가 알아서 해줌
		try (Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, record_id);
				ResultSet resultSet = preparedStatement.executeQuery();) {

			while (resultSet.next()) {
				record = new Gifticon(resultSet.getInt("record_id"), resultSet.getInt("gifticon_id"),
						resultSet.getDate("payment_date").toLocalDate(), resultSet.getInt("used_amount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return record;
	}

	// FindbyId - Gifticon
	public Gifticon findByIdGifticon(int gifticon_id) {
		final String selectQuery = "SELECT * FROM gifticon WHERE gifticon_id = ?"; // ? 를 이용해서 int GifticonNumber를
																					// 바인딩한다.
		Gifticon gifticon = null;

		// try-with resource 문법 -> 자원반납안해도됨 알아서 try가 알아서 해줌
		try (Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, gifticon_id);
				ResultSet resultSet = preparedStatement.executeQuery();) {

			while (resultSet.next()) {
				gifticon = new Gifticon(resultSet.getInt("gifticon_id"), resultSet.getString("serial_number"),
						resultSet.getInt("amount"), resultSet.getDate("expiry_date").toLocalDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return gifticon;
	}

	// FindAll - Gifticon
	public List<Gifticon> findAllGifticon() {
		final String selectQuery = "SELECT * FROM gifticon";

		// gifticons들의 Array
		List<Gifticon> gifticons = new ArrayList<>();

		try {
			// DB 커넥션 연결
			connection = Utils.getConnection();
			// DB로의 Query 전달용 객체 생성
			statement = connection.createStatement();
			// Query 전달 및 수행
			resultSet = statement.executeQuery(selectQuery); // 결과값(ResultSet)이 표 형태로 구성되어있음

			while (resultSet.next()) { // resultSet.get~~ 자체가 데이터임
				Gifticon gifticon = new Gifticon(resultSet.getInt("gifticon_id"), resultSet.getString("serial_number"),
						resultSet.getInt("amount"), resultSet.getDate("expiry_date").toLocalDate());
				gifticons.add(gifticon); // 계속 덮어쓰지않고 배열에 저장시켜버림
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원해제(자원반남)
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return gifticons;
	}

	// FindAll - Record
	public List<Gifticon> findAllRecord() {
		final String selectQuery = "SELECT * FROM record";

		// records들의 Array
		List<Gifticon> records = new ArrayList<>();

		try {
			// DB 커넥션 연결
			connection = Utils.getConnection();
			// DB로의 Query 전달용 객체 생성
			statement = connection.createStatement();
			// Query 전달 및 수행
			resultSet = statement.executeQuery(selectQuery); // 결과값(ResultSet)이 표 형태로 구성되어있음

			while (resultSet.next()) { // resultSet.get~~ 자체가 데이터임
				Gifticon record = new Gifticon(resultSet.getInt("record_id"), resultSet.getInt("gifticon_id"),
						resultSet.getDate("payment_date").toLocalDate(), resultSet.getInt("used_amount"));
				records.add(record); // 계속 덮어쓰지않고 배열에 저장시켜버림
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원해제(자원반남)
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return records;
	}
}
