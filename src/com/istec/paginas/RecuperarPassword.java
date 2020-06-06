package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.istec.componentes.Placeholdertextfield;

import javax.swing.SwingConstants;
import java.awt.Font;

public class RecuperarPassword extends JFrame {

	private JPanel contentPane;	
	private int width = 923;
	private int height = 777;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperarPassword frame = new RecuperarPassword();
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
	public RecuperarPassword() {
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
		
		JLabel lblTitulo = new JLabel("Recuperar Password");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(73, 36, 276, 66);
		loginContainer.add(lblTitulo);
		
		Placeholdertextfield Email = new Placeholdertextfield();
		Email.setBounds(132, 148, 145, 20);
		loginContainer.add(Email);
		Email.setPlaceholder("E-mail");
		Email.setOpaque(true);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(132, 297, 145, 56);
		loginContainer.add(btnCancel);
		btnCancel.setBackground(new Color(32, 178, 170));
		
		
		JButton btnConfirm = new JButton("Recuperar");
		btnConfirm.setBounds(132, 202, 145, 56);
		loginContainer.add(btnConfirm);
		btnConfirm.setBackground(new Color(32, 178, 170));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				close();
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				close();
			}
		});
		
		//imagem de fundo
		JLabel lblbackgroundimage = new JLabel("");
		lblbackgroundimage.setBounds(0,0,width,height);
		lblbackgroundimage.setIcon(new ImageIcon(new ImageIcon("img\\POS.jpg").getImage().getScaledInstance(lblbackgroundimage.getWidth(), lblbackgroundimage.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblbackgroundimage, BorderLayout.NORTH);
		
		this.setVisible(true);
		
		
	}
	
	public void close(){
		this.dispose();
	}
}
