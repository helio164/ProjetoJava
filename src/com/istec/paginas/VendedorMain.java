package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class VendedorMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(70, 130, 180));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Adminmainpanelitems = new JPanel();
		Adminmainpanelitems.setBounds(253, 46, 752, 646);
		Adminmainpanelitems.setBackground(new Color(255, 255, 255));
		contentPane.add(Adminmainpanelitems);
		Adminmainpanelitems.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(22, 46, 221, 590);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
	}
}
