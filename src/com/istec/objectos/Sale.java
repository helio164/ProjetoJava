package com.istec.objectos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Sale implements Serializable {
	public ArrayList<Product> products;
	public Receipt receipt;
	public User vendor;
	public Date date;
	
	public Sale() {
		// TODO Auto-generated constructor stub
		this.products = new ArrayList<Product>();
		
	}

}
