package com.istec.objectos;

public class Vendedor extends User {

	public Vendedor(String username, String email, String password, String image) {
		super(username, email, password, image);
	}
	
	@Override
	public Boolean isAdmin() {		
		return false;
	}
}
