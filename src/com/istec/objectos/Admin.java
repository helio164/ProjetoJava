package com.istec.objectos;

public class Admin extends User {
	public String username;
	public String email;
	public String password;
	
	public Admin(String username, String email, String password) {		
		super(username, email, password);
	}

	@Override
	public Boolean isAdmin() {		
		return true;
	}
}
