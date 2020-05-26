package com.istec.objectos;

public class Vendedor extends User {

	public Vendedor(String username, String email, String password) {
		super(username, email, password);
	}
	
	@Override
	public Boolean isAdmin() {		
		return false;
	}
}
