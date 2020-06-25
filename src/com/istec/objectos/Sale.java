package com.istec.objectos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author 
 *
 */
public class Sale implements Serializable {
	public ArrayList<Product> products;
	public Receipt receipt;
	public User vendor;
	public Date date;
	
	/**
	 * 
	 */
	public Sale() {
		// TODO Auto-generated constructor stub
		this.products = new ArrayList<Product>();
		
	}

	/**
	 * <h1>Sale</h1>
	 * <p>Método para registar uma nova venda</p>
	 * @param products
	 * @param vendedor
	 * @param date
	 */
	public Sale(ArrayList<Product> products,User vendedor, Date date) {
		// TODO Auto-generated constructor stub
		this.products = products;
		this.vendor = vendedor;
		this.date = date;		
	}
}
