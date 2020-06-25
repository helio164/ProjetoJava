package com.istec.objectos;

/**
 * <h1>Vendedor</h1>
 * <p>Classe de vendedor</p>
 *
 */
public class Vendedor extends User {

	/**
	 * <h1>Vendedor</h1>
	 * <p>Método para adicionar novo vendedor</p>
	 * @param username
	 * @param email
	 * @param password
	 * @param image
	 */
	public Vendedor(String username, String email, String password, String image) {
		super(username, email, password, image);
	}
	
	@Override
	public Boolean isAdmin() {		
		return false;
	}
}
