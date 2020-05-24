package com.istec.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.FlowLayout;

import com.istec.objectos.Admin;
import com.istec.objectos.Engine;
import com.istec.objectos.Store;
import com.istec.objectos.StoreType;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		//marcos start 24 Maio
		
		//este fdp fez isto tudo à mão só para mostrar como criar janelas por código e depois cagou nisto
//		JFrame frame = new JFrame();
//		JPanel panel = new JPanel();
//		panel.setLayout(new FlowLayout());
//		
//		JLabel label = new JLabel("o eclipse não vale um peido");
//		JButton btn = new JButton("abrir o visual studio");
//		
//		panel.add(label);
//		panel.add(btn);
//		
//		frame.add(panel);
//		frame.setBounds(100,100,400,400);
//		
//		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		
//		frame.setVisible(true);
//		
		//marcos end 24 Maio
		
		
		System.out.println("--- start ---");
		//Engine.getInstance();
		
		//TestRegister();
		//TestLoginOK();
		//TestLoginNOK();
		//Engine.logout();
		
		System.out.println("--- stop ---");
		System.in.read();
	}
	
	public static void TestRegister() {
		Admin admin = new Admin("username", "email", "123");
		Store store = new Store("Loja Mágica", "123456789", StoreType.OTHER, admin);
		
		Engine.register(admin, store);
	}
	
	public static void TestLoginOK() {
		System.out.println(Engine.currentStore.name);
		Engine.login("username", "123");
		System.out.println(Engine.loggedUser.username);
	}
	
	public static void TestLoginNOK() {
		System.out.println(Engine.currentStore.name);
		Engine.login("username", "password");
		System.out.println(Engine.loggedUser.username);
	}
}
