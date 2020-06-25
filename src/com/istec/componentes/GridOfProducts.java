package com.istec.componentes;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.istec.objectos.Engine;
import com.istec.objectos.Product;

/**
 * <h1>login</h1>
 * <p>Classe para posicionamento dos produtos no interface.</p>
 *  
*/


public class GridOfProducts extends JTabbedPane {	
	public String page;	
	/**
	 * <h1>GridOfProducts</h1>
	 * <p>M�todo para gerar um painel com separadores que vai mostrar os produtos</p>
	 * @param page
	 */
	public GridOfProducts(String page) {

		this.page = page;
		JTabbedPane tabbedpane = new JTabbedPane(); 
		tabbedpane.setTabPlacement(EAST);
		this.loadProducts();
	}
	
	/**
	 * <h1>loadProducts</h1>
	 * <p>M�todo para carregar os produtos</p>
	 */
	public void loadProducts() {
		this.removeAll();
		
		ArrayList<String> types = new ArrayList<String>();
		for(Product p : Engine.currentStore.products) {
			if(!types.contains(p.Type.toUpperCase())) {
				types.add(p.Type.toUpperCase());
			}
		}
		
		for(String t : types) {
			ArrayList<Product> prods = (ArrayList<Product>) Engine.currentStore.products.stream().filter(x -> x.Type.equals(t)).collect(Collectors.toList());
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

			for(Product p : prods) {
				PItem product = new PItem(p);				
				product.setBounds(new Rectangle(100, 100));
				product.setToolTipText(p.Designation+" - \n"+p.Price+"�");
				product.setIcon(new ImageIcon(new ImageIcon(p.Image).getImage().getScaledInstance(product.getWidth(), product.getHeight(), Image.SCALE_DEFAULT)));
				product.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(page.equals("SALES")) {
							PItem p = (PItem)e.getSource();
							Engine.addProductToSale(p.obj);
							JOptionPane.showMessageDialog(null,"Buy product "+ p.obj.Designation +", price: "+p.obj.Price.toString());
						}else {
							JOptionPane.showMessageDialog(null,"Page is admin");
						}
					}
				});
					panel.add(product);
			}
			this.addTab(t, panel);
		}
	}
	
}



