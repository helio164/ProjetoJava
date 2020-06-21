package com.istec.objectos;

public class Admin extends User {
	public String username;
	public String email;
	public String password;
	public String image;
	
	public Admin(String username, String email, String password, String image) {		
		super(username, email, password, image);
	}

	@Override
	public Boolean isAdmin() {		
		return true;
	}
}
