package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import com.istec.componentes.Placeholdertextfield;
import com.istec.componentes.Placeholderpasswordfield;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

public class AddVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVendedor frame = new AddVendedor();
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
	public AddVendedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Placeholdertextfield AddVendedorUsername = new Placeholdertextfield();
		AddVendedorUsername.setBounds(176, 202, 231, 19);
		AddVendedorUsername.setPlaceholder("Username");
		AddVendedorUsername.setOpaque(true);
		contentPane.add(AddVendedorUsername);
		
		Placeholdertextfield AddVendedorEmail = new Placeholdertextfield();
		AddVendedorEmail.setBounds(176, 231, 231, 19);
		AddVendedorEmail.setPlaceholder("email");
		AddVendedorEmail.setOpaque(true);
		contentPane.add(AddVendedorEmail);
		
		Placeholderpasswordfield AddVendedorPassword = new Placeholderpasswordfield();
		AddVendedorPassword.setBounds(176, 260, 231, 19);
		AddVendedorPassword.setPlaceholder("password");
		AddVendedorPassword.setOpaque(true);
		contentPane.add(AddVendedorPassword);
		
		Placeholderpasswordfield AddVendedorConfirmPassword = new Placeholderpasswordfield();
		AddVendedorConfirmPassword.setBounds(176, 289, 231, 19);
		AddVendedorConfirmPassword.setPlaceholder("Confirm Password");
		AddVendedorConfirmPassword.setOpaque(true);
		contentPane.add(AddVendedorConfirmPassword);
	
		JButton Adminbtncancel = new JButton("Cancel");
		Adminbtncancel.setBackground(new Color(32, 178, 170));
		Adminbtncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "carregaste no cancel");
				close();
			}
		});
		Adminbtncancel.setBounds(68, 382, 168, 104);
		
		contentPane.add(Adminbtncancel);
		
		JButton Adminbtncreate = new JButton("Register");
		Adminbtncreate.setBackground(new Color(32, 178, 170));
		Adminbtncreate.setBounds(348, 383, 168, 104);
		Adminbtncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "carregaste no register");
			}
		});
		contentPane.add(Adminbtncreate);
		
		this.setVisible(true);
	}
	public void close(){
		this.dispose();
	}
}

