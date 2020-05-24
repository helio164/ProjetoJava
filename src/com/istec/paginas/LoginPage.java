package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.istec.componentes.Placeholderpasswordfield;
import com.istec.componentes.Placeholdertextfield;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 923;
	private int height = 777;
	private JPanel contentPane;
	private Placeholdertextfield username;
	private Placeholderpasswordfield pwdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//painel para fazer login - com transparencia
		JPanel loginContainer = new JPanel();
		loginContainer.setBackground(new Color(204,204,204,150));
		loginContainer.setBounds((getWidth()/2)-(409/2), (getHeight()/2)-(424/2), 409, 424);
		contentPane.add(loginContainer);
		loginContainer.setLayout(null);
		
		username = new Placeholdertextfield();
		username.setBounds(101, 147, 231, 19);
		username.setPlaceholder("Username");
		username.setOpaque(true);
		loginContainer.add(username);
		username.setColumns(10);
		
		pwdField = new Placeholderpasswordfield();
		pwdField.setBounds(101, 176, 231, 19);
		loginContainer.add(pwdField);
		pwdField.setOpaque(true);
		pwdField.setPlaceholder("Password");
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "carregaste no botão");
			}
		});
		loginBtn.setAutoscrolls(true);
		loginBtn.setBounds(144, 231, 150, 37);
		loginContainer.add(loginBtn);
		
		JLabel registerLbl = new JLabel("Not registered yet?");
		registerLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		registerLbl.setBounds(135, 359, 159, 29);
		loginContainer.add(registerLbl);
		
		JLabel recoverLbl = new JLabel("Forgot password?");
		recoverLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		recoverLbl.setBounds(135, 385, 207, 29);
		loginContainer.add(recoverLbl);
		
		JLabel signin = new JLabel("Sign in");
		signin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "mudar para pagina de registo");
			}
		});
		signin.setFont(new Font("Tahoma", Font.BOLD, 17));
		signin.setBounds(288, 367, 80, 13);
		loginContainer.add(signin);
		
		JLabel recover = new JLabel("Recover");
		recover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "mudar para pagina de recuperacao password");
			}
		});
		recover.setFont(new Font("Tahoma", Font.BOLD, 17));
		recover.setBounds(285, 393, 77, 13);
		loginContainer.add(recover);
		
		//imagem de fundo
		JLabel lblbackgroundimage = new JLabel("");
		lblbackgroundimage.setBounds(0,0,width,height);
		//Marcos - não sei alterar o absolutepath para ir buscar o ficheiro que está dentro do projeto
		lblbackgroundimage.setIcon(new ImageIcon(new ImageIcon("img\\POS.jpg").getImage().getScaledInstance(lblbackgroundimage.getWidth(), lblbackgroundimage.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblbackgroundimage, BorderLayout.NORTH);
		
		
	}
}
