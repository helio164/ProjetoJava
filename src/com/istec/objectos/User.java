package com.istec.objectos;

import java.io.Serializable;

public abstract class User implements Serializable {
	public String username;
	public String email;
	public String password;
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Boolean isAdmin() {		
		return false;
	}
}
