package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.istec.componentes.GridOfProducts;
import com.istec.componentes.ListOfSales;
import com.istec.componentes.PItem;
import com.istec.objectos.Engine;
import com.istec.objectos.Product;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VendedorMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendedorMain frame = new VendedorMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VendedorMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		Engine.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(70, 130, 180));
		Border border = BorderFactory.createTitledBorder(Engine.currentStore.name);
		contentPane.setBorder(border);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListOfSales listOfSales = new ListOfSales(10,85);
		//listOfSales.setLocation(10, 87);
		listOfSales.setBackground(new Color(255, 255, 255));
		//listOfSales.setBounds(18, 170, 220, 333);
		//panel.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(listOfSales);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(new Color(0, 206, 209));
		btnConfirm.setBounds(17, 647, 221, 42);
		btnConfirm.setEnabled(!Engine.currentSale.products.isEmpty());
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "mudar para pagina de registo");
				if(btnConfirm.isEnabled()) {
					new fatura();
					Engine.addSale();
				}else {
					JOptionPane.showMessageDialog(null, "Nothing to buy");
				}
			}
		});
		contentPane.add(btnConfirm);
				
		GridOfProducts Vendedorpanelitems = new GridOfProducts("SALES");
		//JPanel Vendedorpanelitems = new JPanel();
		Vendedorpanelitems.setBounds(268, 58, 714, 631);
		contentPane.add(Vendedorpanelitems);
		 
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				listOfSales.loadSales();
				btnConfirm.setEnabled(!Engine.currentSale.products.isEmpty());
			}
			public void windowLostFocus(WindowEvent e) {
				btnConfirm.setEnabled(!Engine.currentSale.products.isEmpty());
			}
		});
		
		this.setVisible(true);
	}
}
