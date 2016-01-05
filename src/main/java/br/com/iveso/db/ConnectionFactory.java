package br.com.iveso.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/iveso";
		String user = "Henrique";
		String password = "200901";
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			new RuntimeException(e);
		}
		return null;
	}
}
