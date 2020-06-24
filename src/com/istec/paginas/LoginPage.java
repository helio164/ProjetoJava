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
import com.istec.objectos.Engine;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 923;
	private int height = 777;
	private JPanel contentPane;
	public Placeholdertextfield username;
	public Placeholderpasswordfield pwdField;

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
		Engine.centreWindow(this);
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
		username.setBounds(101, 137, 230, 25);
		username.setPlaceholder("Username");
		username.setOpaque(true);
		loginContainer.add(username);
		username.setColumns(10);
		
		pwdField = new Placeholderpasswordfield();
		pwdField.setBounds(101, 176, 230, 25);
		loginContainer.add(pwdField);
		pwdField.setOpaque(true);
		pwdField.setPlaceholder("Password");
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setForeground(Color.DARK_GRAY);
		loginBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		loginBtn.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Engine.login(username.getText(), pwdField.getText())) {
					close();
				}else {
					JOptionPane.showMessageDialog(null, "Login was NOT successful!",null,0);
				}
			}
		});
		loginBtn.setAutoscrolls(true);
		loginBtn.setBounds(135, 247, 145, 56);
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
				new RegisterPage();
				close();
			}
		});
		signin.setFont(new Font("Tahoma", Font.BOLD, 17));
		signin.setBounds(285, 359, 80, 29);
		loginContainer.add(signin);
		
		JLabel recover = new JLabel("Recover");
		recover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RecuperarPassword();
				close();
			}
		});
		recover.setFont(new Font("Tahoma", Font.BOLD, 17));
		recover.setBounds(285, 393, 77, 13);
		loginContainer.add(recover);
		
		//imagem de fundo
		JLabel lblbackgroundimage = new JLabel("");
		lblbackgroundimage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblbackgroundimage.setBounds(0,0,width,height);
		lblbackgroundimage.setIcon(new ImageIcon(new ImageIcon("img\\POS.jpg").getImage().getScaledInstance(lblbackgroundimage.getWidth(), lblbackgroundimage.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblbackgroundimage, BorderLayout.NORTH);
		
		this.setVisible(true);
	}
	
	
	public void close(){
		this.dispose();
	}
	public Boolean fieldValidation() {
		Boolean result = true;
		
			if (username.getText().equals("")){ /* verifica se o campos esta vazio */
				username.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				username.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
			
			if (pwdField.getText().equals("")){ /* verifica se o campos esta vazio */
				pwdField.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				pwdField.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
			return result;
	}
}
