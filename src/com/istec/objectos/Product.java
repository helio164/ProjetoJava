package com.istec.objectos;

import java.io.Serializable;

public class Product implements Serializable {
	public String Designation;
	public String Code;
	public Double Price;
	public String Type;
	
	public Product(String designation, String code, Double price, String type) {
		this.Designation = designation;
		this.Code = code;
		this.Price = price;
		this.Type = type;
	}

}
