package com.istec.objectos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.istec.paginas.AdminMain;

public class Engine implements Serializable {
	private static String filename = "data.data";
	
	private static Engine instance;
	public static User loggedUser;
	public static Store currentStore;
	public static ArrayList<Store> stores;



	public Engine() {
		stores = new ArrayList<Store>();
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
	public static Boolean login(String username, String password) {
		String result = null;
		System.out.println("Login try with: "+username+" | "+password);
		try {
			for(Store store : stores) {
				for(User user: store.users) {
					if(user.username.equalsIgnoreCase(username)) {
						if(user.password.equals(password)) {
							Engine.loggedUser = user;
							Engine.currentStore = stores.get(stores.indexOf(store));
							result = ("Login successful: "+user.username);
							if(store.admin == user) {
								new AdminMain();
							}
							return true;
						}else {
							result = ("Login unsuccessful: Wrong Password");
						}
					}else {
						result = ("Login unsuccessful: Inexistent User");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO a efectuar o Login");
			//e.printStackTrace();			
		}
		System.out.println(result);
		return false;
	}

	public static Boolean register(Store store) {
		try {
			stores.add(store);
			WriteFile();
			System.out.println("Registration successful");
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void logout() {
		Engine.loggedUser = null;
		//Engine.currentStore = null;
		System.out.println("Logout successful");
	}


	//Vendedor stuff
	public static Boolean addVendedor(Vendedor vendedor) {
		
		if(currentStore.users.stream().anyMatch(x -> x.username.equals(vendedor.username) || x.email.equals(vendedor.email))) {
			System.out.println("Vendedor já existe");		
		}else {
			try {
				System.out.println("Novo Vendedor");
				currentStore.users.add(vendedor);
				System.out.println("Saving on file");
				WriteFile();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	//Product stuff
	public static boolean addProduct(Product product) {
		if(currentStore.products.stream().anyMatch(x -> x.Designation.equals(product.Designation) && x.Code.equals(product.Code))) {
			System.out.println("Produto já existe");
		}else {
			try {
				System.out.println("Novo Produto");
				currentStore.products.add(product);
				System.out.println("Saving on file");
				WriteFile();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return false;
	}
	
	public static void addProductToSale(Product product) {
		currentStore.sales = new ArrayList<Sale>();
		Sale sale = new Sale();
		sale.products.add(product);
		currentStore.sales.add(sale);
	}
	
	//File Stuff
	@SuppressWarnings("unchecked")
	private void ReadFile(File file) throws IOException, ClassNotFoundException {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
				stores = (ArrayList<Store>) in.readObject();
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private static void WriteFile() throws IOException {
		FileOutputStream fos;
		fos = new FileOutputStream(new File(filename));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(stores);
		oos.close();
	}
	
	public static Boolean hasFile() {
		File file = new File(filename);		
		return file.exists();
	}


/*FIM DO FICHEIRO */ }


