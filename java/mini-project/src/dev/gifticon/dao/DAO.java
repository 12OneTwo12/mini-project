package dev.gifticon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.gifticon.model.Gifticon;
import dev.gifticon.utils.Utils;

public class DAO {

	private Connection connection; // con, conn
	private Statement statement; // stmt
	private PreparedStatement preparedStatement;
	private ResultSet resultSet; // rs

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

			while (resultSet.next()) { //resultSet.get~~ 자체가 데이터임
				Gifticon gifticon = new Gifticon(resultSet.getInt("gifticon_id"), 
						resultSet.getString("serial_number"),
						resultSet.getInt("amount"), 
						resultSet.getDate("expiry_date").toLocalDate());
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

	// FindbyId - Gifticon
	public Gifticon findByIdGifticon(int gifticon_id) {
		final String selectQuery = "SELECT * FROM gifticon WHERE gifticon_id = ?"; // ? 를 이용해서 int GifticonNumber를 바인딩한다.
		Gifticon gifticon = null;
		
		// try-with resource 문법 -> 자원반납안해도됨 알아서 try가 알아서 해줌 
		try(Connection connection = Utils.getConnection();
			PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, gifticon_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			){
			
						
			while(resultSet.next()) {
				gifticon = new Gifticon(resultSet.getInt("gifticon_id"), 
						resultSet.getString("serial_number"),
						resultSet.getInt("amount"), 
						resultSet.getDate("expiry_date").toLocalDate());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return gifticon;
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

				while (resultSet.next()) { //resultSet.get~~ 자체가 데이터임
					Gifticon record = new Gifticon(resultSet.getInt("record_id"), 
							resultSet.getInt("gifticon_id"),
							resultSet.getDate("payment_date").toLocalDate(),
							resultSet.getInt("used_amount"));
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
		
		// FindbyId - Record
		public Gifticon findByIdRecord(int record_id) {
			final String selectQuery = "SELECT * FROM record WHERE record_id = ?"; // ? 를 이용해서 int GifticonNumber를 바인딩한다.
			Gifticon record = null;
			
			// try-with resource 문법 -> 자원반납안해도됨 알아서 try가 알아서 해줌 
			try(Connection connection = Utils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, record_id);
				ResultSet resultSet = preparedStatement.executeQuery();
				){
				
				while(resultSet.next()) {
					record = new Gifticon(resultSet.getInt("record_id"), 
							resultSet.getInt("gifticon_id"),
							resultSet.getDate("payment_date").toLocalDate(), 
							resultSet.getInt("used_amount"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return record;
		}
	
	
	
	
	private PreparedStatement createPreparedStatement(Connection connection, String sql, int gifticon_id) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, gifticon_id);
		return preparedStatement;
	}

	
	public boolean save(Gifticon gifticon) {
		return false;
	}

	public Gifticon updateById(int id, Gifticon newTodo) {
		return null;
	}

	public boolean deleteById(int id) {
		return false;
	}
}

