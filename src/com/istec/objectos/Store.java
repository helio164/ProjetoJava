package com.istec.objectos;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {
	public String name;
	public String vat;
	public Admin admin;
	public StoreType type;
	public ArrayList<User> users;
	public ArrayList<Product> products;
	public ArrayList<Sale> sales; //historico
	
	public Store(String name, String vat, StoreType type, Admin admin) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.vat = vat;
		this.type = type;
		this.admin = admin;
		this.products = new ArrayList<Product>();
		this.sales = new ArrayList<Sale>();
		this.users = new ArrayList<User>();
			 users.add(admin);	
	}
	
	
	
	
}