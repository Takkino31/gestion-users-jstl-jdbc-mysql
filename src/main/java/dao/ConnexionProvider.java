package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionProvider {
	
	public static Connection getInstance() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Pilote charge avec succes");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ges-users","root","");
			return connection;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
