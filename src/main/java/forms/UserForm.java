package forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import beans.User;
import dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;

public class UserForm {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";

	private boolean status;
	private User user;
	private Map<String, String> erreurs;
	private HttpServletRequest request;
	private String EMPTY_FIELD_MESSAGE = "Ce champ est obligatoire";
	private String DIFFERENT_PASSWORD_MESSAGE = "les mots de passe sont differents";
	private String statusMessage = "";
	private String ADD_USER_SUCCESS_MESSAGE = "Ajout Reussi";
	private String ADD_USER_FAILED_MESSAGE = "Echec d'ajout";
	private String UPDATE_USER_SUCCESS_MESSAGE = "Modification reussie";
	private String UPDATE_USER_FAILED_MESSAGE = "Modification failed";
	
	public UserForm(HttpServletRequest request) {
		this.request = request;
		this.erreurs = new HashMap<String,String>();
	}
	
	public boolean ajouter() {
		
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		this.status = false;
		
		this.user = new User(nom,prenom,login,password);
		
		this.validerChamps(CHAMP_NOM,CHAMP_PRENOM,CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		this.validerPasswords();
		
		if (this.erreurs.isEmpty()) {
			 this.status = UserDao.addUser(user);
			 if (this.status) {
				this.statusMessage = ADD_USER_SUCCESS_MESSAGE;
			}else {
				this.statusMessage = ADD_USER_FAILED_MESSAGE;
			}
		}
		System.out.println("le status dans ajouter : "+ this.status);
		return this.status;
	}
	
	public boolean modifier() {
		
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		
		this.validerChamps(CHAMP_NOM,CHAMP_PRENOM,CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		this.validerPasswords();
		
		if (this.erreurs.isEmpty()) {
			int  id = Integer.parseInt(request.getParameter("id"));
			this.user = new User(id,nom,prenom,login,password);
			 this.status = UserDao.update(user);
			 if (this.status) {
				this.statusMessage = UPDATE_USER_SUCCESS_MESSAGE;
			}else {
				this.statusMessage = UPDATE_USER_FAILED_MESSAGE;
			}
		}
		System.out.println("le status dans modifier : "+ this.status);
		return this.status;
		
	}
	
	private String getParameter(String parameter) {
		String value = request.getParameter(parameter);
		if (value == null || value.isBlank()) {
			return null;
		}
		return value.trim();
	}
	
	public void validerChamps(String... champs) {
		for (String champ : champs) {
			if ( this.getParameter(champ) == null) {
				this.erreurs.put(champ, EMPTY_FIELD_MESSAGE);
			}
		}
	}
	
	public void validerPasswords() {
		String password= this.getParameter(CHAMP_PASSWORD);
		String passwordBis= this.getParameter(CHAMP_PASSWORD_BIS);
		if (password != null && !password.equals(passwordBis)) {
			this.erreurs.put(CHAMP_PASSWORD, DIFFERENT_PASSWORD_MESSAGE );
			this.erreurs.put(CHAMP_PASSWORD_BIS, DIFFERENT_PASSWORD_MESSAGE );
		}
	}
	
	public User getUser() {
		return user;
	}
	
	public Map<String, String> getErreurs() {
		return erreurs; 
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}
	
	public boolean isStatus() {
		return status;
	}
}
