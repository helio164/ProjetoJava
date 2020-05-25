package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.istec.componentes.Placeholderpasswordfield;
import com.istec.componentes.Placeholdertextfield;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class RegisterPage extends JFrame {
	private int width = 923;
	private int height = 777;

	private JPanel contentPane;
	private JPasswordField Password;
	private JPasswordField ConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Logincontainer = new JPanel();
		
		Logincontainer.setBackground(new Color(204,204,204,150));
		Logincontainer.setBounds(255, 176, 441, 514);
		contentPane.add(Logincontainer);
		Logincontainer.setLayout(null);
		
		
		Placeholdertextfield CompanyName = new Placeholdertextfield();
		CompanyName.setBounds(101, 124, 157, 20);
		CompanyName.setPlaceholder("Company Name");
		CompanyName.setOpaque(true);
		Logincontainer.add(CompanyName);
		
		
		Placeholdertextfield VATNumber = new Placeholdertextfield();
		VATNumber.setBounds(101, 155, 157, 20);
		VATNumber.setPlaceholder("VAT Number");
		VATNumber.setOpaque(true);
		Logincontainer.add(VATNumber);
		
		
		
		
		Placeholdertextfield Username = new Placeholdertextfield();
		Username.setBounds(101, 186, 157, 20);
		Username.setPlaceholder("Username");
		Username.setOpaque(true);
		Logincontainer.add(Username);
				
		
		Placeholdertextfield Email = new Placeholdertextfield();
		Email.setBounds(101, 217, 157, 20);
		Email.setPlaceholder("E-mail");
		Email.setOpaque(true);
		Logincontainer.add(Email);
		
		
		
		Placeholderpasswordfield Password = new Placeholderpasswordfield();
		Password.setBounds(101, 258, 157, 19);
		Password.setOpaque(true);
		Password.setPlaceholder("Password");
		Logincontainer.add(Password);
		
		
		
		Placeholderpasswordfield ConfirmPassword = new Placeholderpasswordfield();
		ConfirmPassword.setBounds(101, 288, 157, 19);
		ConfirmPassword.setOpaque(true);
		ConfirmPassword.setPlaceholder("Confirm Password");
		Logincontainer.add(ConfirmPassword);
		
		
		JLabel lblbackgroundimage = new JLabel("");
		lblbackgroundimage.setBounds(0,0,width,height);
		lblbackgroundimage.setIcon(new ImageIcon(new ImageIcon("img\\POS.jpg").getImage().getScaledInstance(lblbackgroundimage.getWidth(), lblbackgroundimage.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblbackgroundimage);
	}
}
