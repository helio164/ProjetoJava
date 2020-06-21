package com.istec.objectos;

import java.io.Serializable;

public abstract class User implements Serializable {
	public String username;
	public String email;
	public String password;
	public String image;
	
	public User(String username, String email, String password, String image) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.image = image;
	}

	public Boolean isAdmin() {		
		return false;
	}
}
