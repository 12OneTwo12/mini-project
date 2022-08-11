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
		
		// gifticons���� Array
		List<Gifticon> gifticons = new ArrayList<>();
		
		try {
			// DB Ŀ�ؼ� ����
			connection = Utils.getConnection();
			// DB���� Query ���޿� ��ü ����
			statement = connection.createStatement();
			// Query ���� �� ����
			resultSet = statement.executeQuery(selectQuery); // �����(ResultSet)�� ǥ ���·� �����Ǿ�����

			while (resultSet.next()) { //resultSet.get~~ ��ü�� ��������
				Gifticon gifticon = new Gifticon(resultSet.getInt("gifticon_id"), 
						resultSet.getString("serial_number"),
						resultSet.getInt("amount"), 
						resultSet.getDate("expiry_date").toLocalDate());
				gifticons.add(gifticon); // ��� ������ʰ� �迭�� ������ѹ��� 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ڿ�����(�ڿ��ݳ�)
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
		final String selectQuery = "SELECT * FROM gifticon WHERE gifticon_id = ?"; // ? �� �̿��ؼ� int GifticonNumber�� ���ε��Ѵ�.
		Gifticon gifticon = null;
		
		// try-with resource ���� -> �ڿ��ݳ����ص��� �˾Ƽ� try�� �˾Ƽ� ���� 
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
			
			// records���� Array
			List<Gifticon> records = new ArrayList<>();
			
			try {
				// DB Ŀ�ؼ� ����
				connection = Utils.getConnection();
				// DB���� Query ���޿� ��ü ����
				statement = connection.createStatement();
				// Query ���� �� ����
				resultSet = statement.executeQuery(selectQuery); // �����(ResultSet)�� ǥ ���·� �����Ǿ�����

				while (resultSet.next()) { //resultSet.get~~ ��ü�� ��������
					Gifticon record = new Gifticon(resultSet.getInt("record_id"), 
							resultSet.getInt("gifticon_id"),
							resultSet.getDate("payment_date").toLocalDate(),
							resultSet.getInt("used_amount"));
					records.add(record); // ��� ������ʰ� �迭�� ������ѹ��� 
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// �ڿ�����(�ڿ��ݳ�)
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
			final String selectQuery = "SELECT * FROM record WHERE record_id = ?"; // ? �� �̿��ؼ� int GifticonNumber�� ���ε��Ѵ�.
			Gifticon record = null;
			
			// try-with resource ���� -> �ڿ��ݳ����ص��� �˾Ƽ� try�� �˾Ƽ� ���� 
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

