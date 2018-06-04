package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "jspexam";
	private String password = "m1234";
		
	// 1. Driver Loading	
	public SchoolDAO() {
		try {
			Class.forName(driver); // ����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
		
	// 2. connection
	public Connection getConnection() {	// ����
		Connection conn = null;
			
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return conn;
	}
	
	// 3. SQL �۾�ó��
	public int insertArticle(SchoolDTO schoolDTO) {
		Connection conn = getConnection(); 	// ȣ��
		PreparedStatement pstmt = null;
		int su = 0;
		String sql = "insert into school values (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql); // ����
			pstmt.setString(1, schoolDTO.getName());
			pstmt.setString(2, schoolDTO.getValue());
			pstmt.setInt(3, schoolDTO.getCode());
			su = pstmt.executeUpdate(); 		 // ���� - ������ ���ϵ�
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	
	public SchoolDTO selectArticle(String name) {
		Connection conn = getConnection();	// ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SchoolDTO schoolDTO = null;
		String sql = "select * from school where name like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);		// ����
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();				// ���� -> ����� ����			
			
			if(rs.next()) {
				schoolDTO = new SchoolDTO();
				schoolDTO.setName(rs.getString("name")); 	// rs.getString(1);
				schoolDTO.setValue(rs.getString("value"));	// rs.getString(2);
				schoolDTO.setCode(rs.getInt("code")); 		// rs.getInt(3);						
			}			
		} catch (SQLException e) {
			schoolDTO = null;
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return schoolDTO;
	}
	
	public List<SchoolDTO> selectList() {
		Connection conn = getConnection();	// ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SchoolDTO> list = new ArrayList<>();
		String sql = "select * from school";
		
		try {
			pstmt = conn.prepareStatement(sql);		// ����			
			rs = pstmt.executeQuery();				// ���� -> ����� ����			
			
			while(rs.next()) {
				SchoolDTO schoolDTO = new SchoolDTO();
				schoolDTO.setName(rs.getString("name")); 	// rs.getString(1);
				schoolDTO.setValue(rs.getString("value"));	// rs.getString(2);
				schoolDTO.setCode(rs.getInt("code")); 		// rs.getInt(3);
				list.add(schoolDTO);
			}			
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int deleteArticle(String name) {
		Connection conn = getConnection(); 	// ȣ��
		PreparedStatement pstmt = null;
		int su = 0;
		String sql = "delete school where name = ?";
		
		try {
			pstmt = conn.prepareStatement(sql); // ����
			pstmt.setString(1, name);
			su = pstmt.executeUpdate(); 		 // ���� - ������ ���ϵ�
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
}
