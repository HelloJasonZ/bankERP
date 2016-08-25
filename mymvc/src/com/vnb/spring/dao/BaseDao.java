package com.vnb.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dbweb?useUnicode=true&characterEncoding=gbk";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	/**
	 * 连接数据库
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源
	 */
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		BaseDao b=new BaseDao();
		System.out.println(">>>>>>>>>>>"+b.getConnection());
	}


}
