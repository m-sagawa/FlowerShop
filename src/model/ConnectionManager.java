package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public final static String URL = "jdbc:mysql://localhost:3306/flowerdb?useSSL=false";
	public final static String USER = "user";
	public final static String PASSWORD = "password";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}