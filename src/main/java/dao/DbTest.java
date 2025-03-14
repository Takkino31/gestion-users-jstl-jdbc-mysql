package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Pilote charge avec succes");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ges-users","root","");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
			
			while (resultSet.next()) {
				System.out.println("ID : " + resultSet.getInt("id"));
				System.out.println("NOM : " + resultSet.getString("nom"));
				System.out.println("PRENOM : " + resultSet.getString("prenom"));
				System.out.println("LOGIN : " + resultSet.getString("login"));
				System.out.println("PASSWORD : " + resultSet.getString("password"));
				System.out.println("+++++++0000000+++++++");
			}
			  
		} catch (SQLException e) {
			System.out.println("Probleme de chargement du pilote JDBC");
		}
		catch (Exception e) {
			System.out.println("Probleme de chargement du pilote JDBC");
		}
	}
}
