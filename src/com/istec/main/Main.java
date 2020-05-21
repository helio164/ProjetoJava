package com.istec.main;

import com.istec.objectos.Admin;
import com.istec.objectos.Engine;
import com.istec.objectos.Store;
import com.istec.objectos.StoreType;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		System.out.println("--- start ---");
		//Engine.getInstance();
		
		//TestRegister();
		//TestLoginOK();
		//TestLoginNOK();
		//Engine.logout();
		
		System.out.println("--- stop ---");
		System.in.read();
	}
	
	public static void TestRegister() {
		Admin admin = new Admin("username", "email", "123");
		Store store = new Store("Loja Mágica", "123456789", StoreType.OTHER, admin);
		
		Engine.register(admin, store);
	}
	
	public static void TestLoginOK() {
		System.out.println(Engine.currentStore.name);
		Engine.login("username", "123");
		System.out.println(Engine.loggedUser.username);
	}
	
	public static void TestLoginNOK() {
		System.out.println(Engine.currentStore.name);
		Engine.login("username", "password");
		System.out.println(Engine.loggedUser.username);
	}
}
