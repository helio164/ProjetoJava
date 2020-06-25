package com.istec.objectos;

import java.io.Serializable;

/**
 * @author StarbucksJavaCoffee
 *
 */
public class Product implements Serializable {
	public String Designation;
	public String Code;
	public Double Price;
	public String Type;
	public String Image;
	
	/**
	 * <h1> Product</h1>
	 * <p> Este construtor serve para criar um produto </p>
	 * @param designation
	 * @param code
	 * @param price
	 * @param type
	 * @param image
	 */
	public Product(String designation, String code, Double price, String type, String image) {
		this.Designation = designation;
		this.Code = code;
		this.Price = price;
		this.Type = type;
		this.Image = image;
	}

}
