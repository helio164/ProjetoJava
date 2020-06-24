package com.istec.main;

import com.istec.objectos.Engine;
import com.istec.paginas.LoginPage;

public class Main {
	public static void main(String[] args) throws Exception {		
		System.out.println("--- start ---");
		Engine.getInstance();
		new LoginPage();		
		System.out.println("--- stop ---");
		System.in.read();
	}
}
