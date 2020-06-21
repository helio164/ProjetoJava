package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import com.istec.componentes.Placeholdertextfield;
import com.istec.objectos.Engine;
import com.istec.objectos.User;
import com.istec.objectos.Vendedor;
import com.istec.componentes.ChooseFile;
import com.istec.componentes.ListOfVendedoresPanel;
import com.istec.componentes.Placeholderpasswordfield;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "unused", "serial" })
public class AddVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public String pathName = "";
	public Placeholdertextfield AddVendedorUsername;
	public Placeholdertextfield AddVendedorEmail;
	public Placeholderpasswordfield AddVendedorPassword;
	public Placeholderpasswordfield AddVendedorConfirmPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVendedor frame = new AddVendedor();
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
	public AddVendedor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
//		JLabel lblFotoVendedor = new JLabel("New label");
//		lblFotoVendedor.addMouseListener(new MouseAdapter() {
//			@Override
//			//Marcos inventou aqui cenas
//						
//			public void mouseClicked(MouseEvent e) {
//				final JFileChooser fc = new JFileChooser();
//				int returnVal = fc.showOpenDialog(fc);
//				String filePath = null;
//				if (returnVal == JFileChooser.APPROVE_OPTION) {
//					filePath = fc.getSelectedFile().getAbsolutePath();
//					
//				} else {
//					System.out.println("User clicked CANCEL");
//					System.exit(1);
//					
//				}
//				
//				new ChooseFile(filePath);
//				
//			}
//		});
//		lblFotoVendedor.setBounds(232, 52, 128, 113);
//		contentPane.add(lblFotoVendedor);
		
		    /**
		     * Create the frame.
		    */	  
		JFileChooser fc = new JFileChooser();
        JLabel picPanel = new JLabel("");
        picPanel.setBounds(238, 50, 113, 104);
        picPanel.setHorizontalAlignment(SwingConstants.CENTER);
        picPanel.setIcon(new ImageIcon(new ImageIcon("img\\add.png").getImage().getScaledInstance(picPanel.getWidth(), picPanel.getHeight(), Image.SCALE_DEFAULT)));
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
                        //ImageIcon icon = new ImageIcon(pathName);
                        picPanel.setIcon(new ImageIcon(new ImageIcon(pathName).getImage().getScaledInstance(picPanel.getWidth(), picPanel.getHeight(), Image.SCALE_DEFAULT)));
                    } else {
                        JOptionPane.showMessageDialog(null, "Feel Free to Look Later");
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        picPanel.setBounds(151, 22, 267, 156);
        contentPane.add(picPanel);
		
		
		AddVendedorUsername = new Placeholdertextfield();
		AddVendedorUsername.setBounds(176, 202, 231, 19);
		AddVendedorUsername.setPlaceholder("Username");
		AddVendedorUsername.setOpaque(true);
		contentPane.add(AddVendedorUsername);
		
		AddVendedorEmail = new Placeholdertextfield();
		AddVendedorEmail.setBounds(176, 231, 231, 19);
		AddVendedorEmail.setPlaceholder("email");
		AddVendedorEmail.setOpaque(true);
		contentPane.add(AddVendedorEmail);
		
		AddVendedorPassword = new Placeholderpasswordfield();
		AddVendedorPassword.setBounds(176, 260, 231, 19);
		AddVendedorPassword.setPlaceholder("password");
		AddVendedorPassword.setOpaque(true);
		contentPane.add(AddVendedorPassword);
		
		AddVendedorConfirmPassword = new Placeholderpasswordfield();
		AddVendedorConfirmPassword.setBounds(176, 289, 231, 19);
		AddVendedorConfirmPassword.setPlaceholder("Confirm Password");
		AddVendedorConfirmPassword.setOpaque(true);
		contentPane.add(AddVendedorConfirmPassword);
	
		JButton AddVendedorbtncancel = new JButton("Cancel");
		AddVendedorbtncancel.setBackground(new Color(32, 178, 170));
		AddVendedorbtncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "carregaste no cancel");
				close();
			}
		});
		AddVendedorbtncancel.setBounds(68, 382, 168, 104);		
		contentPane.add(AddVendedorbtncancel);
		
		JButton AddVendedorbtncreate = new JButton("Register");
		AddVendedorbtncreate.setBackground(new Color(32, 178, 170));
		AddVendedorbtncreate.setBounds(348, 383, 168, 104);
		AddVendedorbtncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "carregaste no register");				
					if(Engine.addVendedor(
							new Vendedor(AddVendedorUsername.getText(),AddVendedorEmail.getText(),AddVendedorPassword.getText(), (pathName.isEmpty()?"img\\user.png":pathName)))
					) {
						JOptionPane.showMessageDialog(null, "Vendedor adicionado COM sucesso!");
						close();
					} else {
						JOptionPane.showMessageDialog(null, "Vendedor adicionado SEM sucesso!");
					}
			}
		});
		contentPane.add(AddVendedorbtncreate);
		
		this.setVisible(true);
	}
	public void close(){
		this.dispose();
	}
	public Boolean fieldValidation() {
		Boolean result = true;
		
			if (AddVendedorUsername.getText().equals("")){ /* verifica se o campos esta vazio */
				AddVendedorUsername.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				AddVendedorUsername.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
			
			if (AddVendedorEmail.getText().equals("")){ /* verifica se o campos esta vazio */
				AddVendedorEmail.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				AddVendedorEmail.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
			
			if (AddVendedorPassword.getText().equals("")){ /* verifica se o campos esta vazio */
				AddVendedorPassword.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				AddVendedorPassword.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
			
			if (AddVendedorConfirmPassword.getText().equals("")){ /* verifica se o campos esta vazio */
				AddVendedorConfirmPassword.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				AddVendedorConfirmPassword.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
		return result;
	}
}

