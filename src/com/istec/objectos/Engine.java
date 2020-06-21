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
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.istec.paginas.AdminMain;
import com.istec.paginas.VendedorMain;

public class Engine implements Serializable {
	private static String filename = "data.data";
	
	private static Engine instance;
	public static User loggedUser;
	public static Store currentStore;
	public static ArrayList<Store> stores;
	public static Sale currentSale;

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
							}else {
								new VendedorMain();
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

	public static void recoverPassword(User user) {
		 // Recipient's email ID needs to be mentioned.
	      String to = user.email;

	      // Sender's email ID needs to be mentioned
	      String from = "projetojava.istec@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "smtp.gmail.com";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.put("mail.smtp.port", "465");
	      properties.put("mail.smtp.ssl.enable", "true");
	      properties.put("mail.smtp.auth", "true");

	      // Get the Session object.// and pass username and password
	      Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

	          protected PasswordAuthentication getPasswordAuthentication() {

	              return new PasswordAuthentication("projetojava.istec@gmail.com", "J@v@C@f3");
	          }
	      });

	      
	      // Used to debug SMTP issues
	      session.setDebug(true);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Recover your password!");

	         // Send the actual HTML message, as big as you like
	         message.setContent(
	        		 "<h1>Hello "+user.username+"!</h1>"+
	        		 "<p>We notice you forgot your password.</p>"+
	        		 "<p>Your password is: <strong>"+user.password+"</strong></p>"+
	        		 "<p>Best regards!</p>"
	        		 ,"text/html");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	      /**/
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
	
	public static User getUserByEmail(String email) {		
			try {
				for(Store store : stores) {
					for(User user: store.users) {
						if(user.email.equalsIgnoreCase(email)) {
							return user;
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ERRO");
				//e.printStackTrace();			
			}
			
			
		return null;
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
		try {
			if(currentSale == null) {
			currentSale = new Sale();
			}
			currentSale.products.add(product);
			WriteFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//currentStore.sales.add(sale);
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


