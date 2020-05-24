package com.istec.objectos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Engine {
	private static String filename = "data.data";
	
	private static Engine instance;
	public static User loggedUser;
	public static Store currentStore;
	public ArrayList<Store> stores;



	public Engine() {
		
		// TODO Auto-generated constructor stub
		File file = new File(filename);
		if(file.exists()) {
			System.out.println("File exists");
			try {
				ReadFile(file);
				System.out.println("file read");
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("file not read");
				e.printStackTrace();
			}			
		}else {
			System.out.println("File not exists");
			try {
				file.createNewFile();
				stores = new ArrayList<Store>();
				System.out.println("File Created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Engine getInstance() {
		if(instance == null) {
			instance = new Engine();
			return instance;
		}else {
			return instance;
		}		
	}


	//Registration Stuff
	public static void login(String username, String password) {
		for(User user: currentStore.users) {
			if(user.username.equalsIgnoreCase(username)) {
				if(user.password.equals(password)) {
					Engine.loggedUser = user;
					System.out.println("Login successful: "+user.username);
				}else {
					System.out.println("Login unsuccessful: Wrong Password");
				}
			}else {
				System.out.println("Login unsuccessful: Inexistent User");
			}
		}
	}

	public static void register(Admin admin, Store store) {
		try {
			WriteFile(store);
			currentStore = store;
			System.out.println("Registration successful");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void logout() {
		Engine.loggedUser = null;
		Engine.currentStore = null;
		System.out.println("Logout successful");
	}


	//File Stuff
	private void ReadFile(File file) throws IOException, ClassNotFoundException {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			currentStore = (Store) in.readObject();
			in.close();
	}
	
	private static void WriteFile(Store store) throws IOException {
		FileOutputStream fos;
		fos = new FileOutputStream(new File(filename));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(store);
	}
	
	public static Boolean hasFile() {
		File file = new File(filename);		
		return file.exists();
	}


/*FIM DO FICHEIRO */ }


