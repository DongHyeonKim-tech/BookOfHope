package util;

import java.sql.*;

public class DBManager {

	public static Connection getConnection() {

		try {

			/*
			 * local jdbc String driver = "com.mysql.jdbc.Driver"; String url =
			 * "jdbc:mysql://localhost/whddnr8063"; String username = "test"; String
			 * password = "1234"; Class.forName(driver);
			 */
//         String url = "jdbc:mysql://globalitbook.mysql.database.azure.com:3306/test?useSSL=true&requireSSL=false"; 

			String driver = "com.mysql.jdbc.Driver";
//			String url = "jdbc:mysql://localhost:3306/whddnr8063?user=whddnr8063";
			 String url = "jdbc:mysql://whddnr8063.cafe24.com:3306/whddnr8063?user=whddnr8063";
			String username = "whddnr8063";
			String password = "djbook1!";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("DBManager : " + conn);

			return conn;

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException" + ex);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}