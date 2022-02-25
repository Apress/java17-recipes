package org.java17recipes.chapter12.recipe12_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection {

	static Properties props = new Properties();

	String hostname = "localhost";
	String port = "3306";
	String database = "apressbooks";
	String username = "root";
	String password = "root";

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String jdbcUrl;            
		jdbcUrl = "jdbc:mysql://" + this.hostname + ":" + 
				this.port  + "/" + this.database; 
		System.out.println(jdbcUrl);
		conn = DriverManager.getConnection(jdbcUrl, this.username, this.password);
		System.out.println("Successfully connected");
		return conn;
	}

	public static void main(String[] args) {
		CreateConnection createConnection = new CreateConnection();
		try {
			createConnection.getConnection();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}

