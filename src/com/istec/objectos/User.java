package com.istec.objectos;

import java.io.Serializable;

/**
 * <h1>User</h1>
 * <p>Classe para criar novo utilizador</p>
 *
 */
public abstract class User implements Serializable {
	public String username;
	public String email;
	public String password;
	public String image;
	
	/**
	 * <h1>User</h1>
	 * <p>Construtor para criar novo user</p>
	 * @param username
	 * @param email
	 * @param password
	 * @param image
	 */
	public User(String username, String email, String password, String image) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.image = image;
	}

	/**
	 * <h1>isAdmin</h1>
	 * <p>Método para verificar se o user é Admin<p>
	 * @return boleano, verdadeiro caso o utilizador seja Admin
	 */
	public Boolean isAdmin() {		
		return false;
	}
}
