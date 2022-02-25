package org.java17recipes.chapter12.recipe12_06;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection {

	static Properties props = new Properties();

	String hostname = null;
	String port = null;
	String database = null;
	String username = null;
	String password = null; 

	public CreateConnection() {
		// Looks for properties file in the root of the src directory in Netbeans project
		try (InputStream in = Files.newInputStream(FileSystems.getDefault().
				getPath(System.getProperty("user.dir") + File.separator + "db_props.properties"));) {
			props.load(in);
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		loadProperties();
	}

	public final void loadProperties() {
		hostname = props.getProperty("host_name");
		port = props.getProperty("port_number");
		database = props.getProperty("db_name");
		username = props.getProperty("username");
		password = props.getProperty("password"); 
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String jdbcUrl; 
		jdbcUrl = "jdbc:mysql://" + this.hostname + ":"
				+ this.port + "/" + this.database; 
		conn = DriverManager.getConnection(jdbcUrl, username, password);
		System.out.println("Successfully connected");
		return conn;
	}

	public static void main(String[] args) {
		CreateConnection createConnection = new CreateConnection();
		try {
			Connection conn = createConnection.getConnection();
			if (conn != null) {
				System.out.println("Closing Connection...");
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

