package com.istec.componentes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

import com.istec.objectos.Engine;
import com.istec.objectos.Product;

public class GridOfProducts extends JTabbedPane {

	public GridOfProducts() {
		// TODO Auto-generated constructor stub
		JTabbedPane tabbedpane = new JTabbedPane(); 
		tabbedpane.setTabPlacement(EAST);
		this.loadProducts();
	}

	public void loadProducts() {
		this.removeAll();
		
		ArrayList<String> types = new ArrayList<String>();
		for(Product p : Engine.currentStore.products) {
			if(!types.contains(p.Type)) {
				types.add(p.Type);
			}
		}
		
		for(String t : types) {
			ArrayList<Product> prods = (ArrayList<Product>) Engine.currentStore.products.stream().filter(x -> x.Type.equals(t)).collect(Collectors.toList());
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

			for(Product p : prods) {
					JLabel label = new JLabel();
					label.setBounds(new Rectangle(100, 100));
					label.setToolTipText(p.Designation+" - \n"+p.Price+"€");
					label.setIcon(new ImageIcon(new ImageIcon("img\\product.png").getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
					panel.add(label);
			}
			this.addTab(t, panel);
		}
				
		/*
		 * for(Product p : Engine.currentStore.products) {
		 * 
		 * 
		 * this.addTab(p.Type, null);
		 * 
		 * JLabel label = new JLabel(); label.setBounds(new Rectangle(70, 70)); Border
		 * border = BorderFactory.createLineBorder(Color.BLACK, 2);
		 * label.setBorder(border); //label.setToolTipText(u.username);
		 * label.setIcon(new ImageIcon(new
		 * ImageIcon("img\\user.png").getImage().getScaledInstance(label.getWidth(),
		 * label.getHeight(), Image.SCALE_DEFAULT))); label.addMouseListener(new
		 * MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * //JOptionPane.showMessageDialog(null, u.username+"\n"+u.email); } });
		 * this.add(label); }
		 */
	}
	
}


