package com.game.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3307/game";
	private static final String USER = "root";
	private static final String PWD = "kd1824java";
	
	static {
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 성공");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		try {
			Connection con = DriverManager.getConnection(URL,USER,PWD);
			System.out.println("나도 성공");
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
