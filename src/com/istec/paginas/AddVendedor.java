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
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

/**
 * @author StarbucksJavaCoffe
 * <h1>AddVendedor</h1>
 * <p>Classe que vai criar e adicionar vendedor</p>
 */
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
	 * <h1>AddVendedor</h1>
	 * <p>Construtor permite criar as janelas para adicionar vendedor</p> 
	 */
	public AddVendedor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 555);
		Engine.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		    /**
		     * Create the frame.
		    */	  
		JFileChooser fc = new JFileChooser();
        JLabel picPanel = new JLabel("");
        picPanel.setBounds(151, 22, 113, 104);
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
		AddVendedorUsername.setBounds(176, 178, 230, 25);
		AddVendedorUsername.setPlaceholder("Username");
		AddVendedorUsername.setOpaque(true);
		contentPane.add(AddVendedorUsername);
		
		AddVendedorEmail = new Placeholdertextfield();
		AddVendedorEmail.setBounds(176, 214, 230, 25);
		AddVendedorEmail.setPlaceholder("Email");
		AddVendedorEmail.setOpaque(true);
		contentPane.add(AddVendedorEmail);
		
		AddVendedorPassword = new Placeholderpasswordfield();
		AddVendedorPassword.setBounds(176, 250, 230, 25);
		AddVendedorPassword.setPlaceholder("Password");
		AddVendedorPassword.setOpaque(true);
		contentPane.add(AddVendedorPassword);
		

		AddVendedorConfirmPassword = new Placeholderpasswordfield();
		AddVendedorConfirmPassword.setBounds(176, 286, 230, 25);
		AddVendedorConfirmPassword.setPlaceholder("Confirm Password");
		AddVendedorConfirmPassword.setOpaque(true);
		contentPane.add(AddVendedorConfirmPassword);
	
		JButton AddVendedorbtncancel = new JButton("Cancel");
		AddVendedorbtncancel.setForeground(Color.DARK_GRAY);
		AddVendedorbtncancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		AddVendedorbtncancel.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		AddVendedorbtncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		AddVendedorbtncancel.setBounds(106, 365, 145, 56);		
		contentPane.add(AddVendedorbtncancel);
		
		JButton AddVendedorbtncreate = new JButton("Register");
		AddVendedorbtncreate.setForeground(Color.DARK_GRAY);
		AddVendedorbtncreate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		AddVendedorbtncreate.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		AddVendedorbtncreate.setBounds(330, 365, 145, 56);
		AddVendedorbtncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldValidation()) {
				//JOptionPane.showMessageDialog(null, "carregaste no register");				
					if(Engine.addVendedor(
							new Vendedor(AddVendedorUsername.getText(),AddVendedorEmail.getText(),AddVendedorPassword.getText(), (pathName.isEmpty()?"img\\user.png":pathName)))
					) {
						JOptionPane.showMessageDialog(null, "Seller was added!",null,1);
						close();
					} else {
						JOptionPane.showMessageDialog(null, "Seller was NOT added!",null,0);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Please fill all required fields.",null,2);
				}
			}
		});
		contentPane.add(AddVendedorbtncreate);
		
		this.setVisible(true);
	}
	/**
	 * <h1>close</h1>
	 * <p>método para fechar a janela</p>
	 */
	public void close(){
		this.dispose();
	}
	/**
	 * <h1>fieldValidation</h1>
	 * <p>Método que verifica se os campos estão preenchidos</p>
	 * @return Booleano, verdadeiro caso os campos sejam todos preenchidos
	 */
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

