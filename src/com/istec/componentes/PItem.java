package com.istec.componentes;

import javax.swing.JLabel;

import com.istec.objectos.Product;

public class PItem extends JLabel {
	public Product obj;
	
	public PItem(Product obj) {
		this.obj = obj;
	}

}
