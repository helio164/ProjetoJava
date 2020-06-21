package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.istec.componentes.Placeholderpasswordfield;
import com.istec.componentes.Placeholdertextfield;
import com.istec.objectos.Admin;
import com.istec.objectos.Engine;
import com.istec.objectos.Store;
import com.istec.objectos.StoreType;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegisterPage extends JFrame {
	private int width = 923;
	private int height = 777;
	public String pathName = "";

	private JPanel contentPane;
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
		Logincontainer.setBounds(254, 164, 441, 514);
		contentPane.add(Logincontainer);
		Logincontainer.setLayout(null);
		
		JFileChooser fc = new JFileChooser();
		
		
		Placeholdertextfield CompanyName = new Placeholdertextfield();
		CompanyName.setBounds(153, 124, 157, 20);
		CompanyName.setPlaceholder("Company Name");
		CompanyName.setOpaque(true);
		Logincontainer.add(CompanyName);
		
		
		Placeholdertextfield VATNumber = new Placeholdertextfield();
		VATNumber.setBounds(153, 155, 157, 20);
		VATNumber.setPlaceholder("VAT Number");
		VATNumber.setOpaque(true);
		Logincontainer.add(VATNumber);
		
		
		
		
		Placeholdertextfield Username = new Placeholdertextfield();
		Username.setBounds(153, 186, 157, 20);
		Username.setPlaceholder("Username");
		Username.setOpaque(true);
		Logincontainer.add(Username);
				
		
		Placeholdertextfield Email = new Placeholdertextfield();
		Email.setBounds(153, 217, 157, 20);
		Email.setPlaceholder("E-mail");
		Email.setOpaque(true);
		Logincontainer.add(Email);
		
		
		
		Placeholderpasswordfield Password = new Placeholderpasswordfield();
		Password.setBounds(153, 258, 157, 19);
		Password.setOpaque(true);
		Password.setPlaceholder("Password");
		Logincontainer.add(Password);
		
		
		
		Placeholderpasswordfield ConfirmPassword = new Placeholderpasswordfield();
		ConfirmPassword.setBounds(153, 288, 157, 19);
		ConfirmPassword.setOpaque(true);
		ConfirmPassword.setPlaceholder("Confirm Password");
		Logincontainer.add(ConfirmPassword);
		
		JComboBox cbxStoreType = new JComboBox();
		cbxStoreType.setModel(new DefaultComboBoxModel<>(StoreType.values()));
		cbxStoreType.setBounds(153, 317, 157, 21);
		Logincontainer.add(cbxStoreType);
		
		JButton BackAdmin = new JButton("Back");
		BackAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		BackAdmin.setForeground(Color.DARK_GRAY);
		BackAdmin.setBounds(27, 375, 168, 77);
		Logincontainer.add(BackAdmin);
		BackAdmin.setBackground(new Color(0, 255, 0));
		BackAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "carregaste no Back");
				new LoginPage();
				close();
			}
		});
		
		JButton RegisterAdmin = new JButton("Register");
		RegisterAdmin.setFont(new Font("Tahoma", Font.ITALIC, 12));
		RegisterAdmin.setForeground(Color.DARK_GRAY);
		RegisterAdmin.setBounds(260, 375, 157, 77);
		Logincontainer.add(RegisterAdmin);
		RegisterAdmin.setBackground(new Color(0, 255, 0));
		JLabel picPanel = new JLabel("Search Picture");
		picPanel.setBounds(186, 44, 79, 63);
		Logincontainer.add(picPanel);
		picPanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent arg0) {
		        FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg", "png");
		        fc.setFileFilter(filter);
		        int response = fc.showOpenDialog(null);
		        try {
		            if (response == JFileChooser.APPROVE_OPTION) {
		                pathName = fc.getSelectedFile().getPath();
		                JOptionPane.showMessageDialog(null, pathName);
		                ImageIcon icon = new ImageIcon(pathName);
		                picPanel.setIcon(icon);
		            } else {
		                JOptionPane.showMessageDialog(null, "Feel Free to Look Later");
		            }
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		    }
		});
		RegisterAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "carregaste no Register");
				if(Password.getText().equals(ConfirmPassword.getText())) {
					Store newStore = new Store(
							CompanyName.getText(),
							VATNumber.getText(),
							(StoreType) cbxStoreType.getSelectedItem(),
							new Admin(
									Username.getText(),
									Email.getText(),
									Password.getText(),
									(pathName.isEmpty()?"img\\user.png":pathName)
									)
							);
					if(Engine.register(newStore)) {
						JOptionPane.showMessageDialog(null, "Registo adicionado COM sucesso!");
						new LoginPage();
						close();
					} else {
						JOptionPane.showMessageDialog(null, "Vendedor adicionado SEM sucesso!");
					}
				}
			}
		});
		
		
		JLabel lblbackgroundimage = new JLabel("");
		lblbackgroundimage.setBounds(0,0,width,height);
		lblbackgroundimage.setIcon(new ImageIcon(new ImageIcon("img\\POS.jpg").getImage().getScaledInstance(lblbackgroundimage.getWidth(), lblbackgroundimage.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblbackgroundimage);
		
		this.setVisible(true);
	}

	public void close(){
		this.dispose();
	}
}
