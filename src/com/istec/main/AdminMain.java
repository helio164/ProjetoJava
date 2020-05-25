package com.istec.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class AdminMain extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		Adminmainlbladduser.setBounds(917, 10, 83, 83);
		
		Adminmainlbladduser.setIcon(new ImageIcon(new ImageIcon("img\\addUser.png").getImage().getScaledInstance(Adminmainlbladduser.getWidth(), Adminmainlbladduser.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(Adminmainlbladduser);
		
		JPanel Adminmainpanelusers = new JPanel();
		Adminmainpanelusers.setBounds(180, 20, 657, 73);
		contentPane.add(Adminmainpanelusers);
		Adminmainpanelusers.setLayout(new BoxLayout(Adminmainpanelusers, BoxLayout.X_AXIS));
		
		JPanel Adminmainpanelitems = new JPanel();
		Adminmainpanelitems.setBounds(182, 142, 805, 535);
		contentPane.add(Adminmainpanelitems);
		Adminmainpanelitems.setLayout(new GridLayout(1, 0, 0, 0));
	}
}
