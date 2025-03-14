package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.User;

public class UserDao {

	private static int nextId = 1;
	private static final ArrayList<User> users = new ArrayList<User>();

	/*
	 * static { try { users.add(new User(nextId++, "Oumar", "Lo", "omzo", "sakso"));
	 * users.add(new User(nextId++, "Takkino", "war", "takkino31", "yaasopp")); }
	 * catch (Exception e) { e.printStackTrace(); } }
	 */

	public static ArrayList<User> getUsers() {
		try {
			Connection connection = ConnexionProvider.getInstance();
			
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
			
			int id;
			String nom, prenom, login, password;
			
			
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				nom = resultSet.getString("nom");
				prenom = resultSet.getString("prenom");
				login = resultSet.getString("login");
				password = resultSet.getString("password");
				users.add(new User(id,nom,prenom,login,password));
			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Erreur lors du fetch des data");
			e.printStackTrace();
		}
		return users;
	}

	public static boolean addUser(User user){
		user.setId(nextId++); 
		users.add(user);
		return true;
	 }
	 
	 public static boolean delete(int id) { 
		 for (User user : users) { 
			 if(user.getId() == id) {
				 users.remove(user); return true; 
				 }
			 }
		 return false;
	 }
	 
	 public static boolean update(User userUpdate) {
		 for (User user : users) {
			 if(user.getId() == userUpdate.getId()) {
				 user.setNom(userUpdate.getNom());
				 user.setPrenom(userUpdate.getPrenom());
				 user.setLogin(userUpdate.getLogin());
				 user.setPassword(userUpdate.getPassword());
				 return true; 
			 }
		 }
		 return false;
	 }
	
}
