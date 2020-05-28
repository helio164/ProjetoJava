package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.istec.componentes.GridOfProducts;
import com.istec.componentes.ListOfVendedoresPanel;
import com.istec.objectos.Engine;
import com.istec.objectos.Store;
import com.istec.objectos.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.JTabbedPane;


public class AdminMain extends JFrame {

	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
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
	public AdminMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		//uncomment below
		Border border = BorderFactory.createTitledBorder(Engine.currentStore.name);
		contentPane.setBorder(border);
		//uncomment above
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Adminmainlbladditem = new JLabel("New label");		
		Adminmainlbladditem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "carreguei no cenas");
				new AdminAddProduto();
			}
		});
		//ir buscar codigo das labels do login
		
		
		Adminmainlbladditem.setBounds(883, 620, 117, 111);
		Adminmainlbladditem.setIcon(new ImageIcon(new ImageIcon("img\\add.png").getImage().getScaledInstance(Adminmainlbladditem.getWidth(), Adminmainlbladditem.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(Adminmainlbladditem);
		
		JButton Adminmainbtnmanage = new JButton("Manage");
		Adminmainbtnmanage.setForeground(new Color(255, 255, 255));
		Adminmainbtnmanage.setBackground(new Color(72, 209, 204));
		Adminmainbtnmanage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Adminmainbtnmanage.setBounds(34, 35, 112, 21);
		contentPane.add(Adminmainbtnmanage);
		
		JButton Adminmainbtnsales = new JButton("Sales");
		Adminmainbtnsales.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Adminmainbtnsales.setForeground(new Color(255, 255, 255));
		Adminmainbtnsales.setBackground(new Color(72, 209, 204));
		Adminmainbtnsales.setBounds(34, 77, 112, 21);
		contentPane.add(Adminmainbtnsales);
		
		JButton Adminmainbtnstats = new JButton("Stats");
		Adminmainbtnstats.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Adminmainbtnstats.setForeground(new Color(255, 255, 255));
		Adminmainbtnstats.setBackground(new Color(72, 209, 204));
		Adminmainbtnstats.setBounds(34, 121, 112, 21);
		contentPane.add(Adminmainbtnstats);
		
		JLabel Adminmainlbladduser = new JLabel("New label");
		Adminmainlbladduser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "carreguei no cenas");
				new AddVendedor();
				System.out.println("Registration successful");
			}
		});		
		Adminmainlbladduser.setBounds(917, 10, 83, 83);		
		Adminmainlbladduser.setIcon(new ImageIcon(new ImageIcon("img\\addUser.png").getImage().getScaledInstance(Adminmainlbladduser.getWidth(), Adminmainlbladduser.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(Adminmainlbladduser);
		
		ListOfVendedoresPanel Adminmainpanelusers = new ListOfVendedoresPanel();
		Adminmainpanelusers.setBounds(180, 20, 703, 73);
		Adminmainpanelusers.setLayout(new BoxLayout(Adminmainpanelusers, BoxLayout.X_AXIS));
		//lov.loadVendedores();
		contentPane.add(Adminmainpanelusers);
		
		GridOfProducts Adminmainpanelitems = new GridOfProducts();
		//JPanel Adminmainpanelitems = new JPanel();
		Adminmainpanelitems.setBounds(182, 142, 800, 500);
		contentPane.add(Adminmainpanelitems);
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				Adminmainpanelusers.loadVendedores();
				Adminmainpanelitems.loadProducts();
				//JOptionPane.showMessageDialog(null, "novo foco");
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});

//		  compsToExperiment.add(new JButton("Button 1"));
//        compsToExperiment.add(new JButton("Button 2"));
//        compsToExperiment.add(new JButton("Button 3"));
//        compsToExperiment.add(new JButton("Long-Named Button 4"));
//        compsToExperiment.add(new JButton("5"));

		this.setVisible(true);

	}
}
