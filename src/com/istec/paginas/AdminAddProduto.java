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
import com.istec.objectos.Product;
import com.istec.objectos.Vendedor;
import com.istec.componentes.Placeholderpasswordfield;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;

public class AdminAddProduto extends JFrame {

	public JPanel contentPane;
	public Placeholdertextfield AdminAddDesignation;
	public Placeholdertextfield AdminAddCode;
	public Placeholdertextfield AdminAddPrice;
	public Placeholdertextfield AdminAddType;
	public String pathName = "";
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddProduto frame = new AdminAddProduto();
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
	public AdminAddProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * JLabel Adminlbladditem = new JLabel("New label");
		 * Adminlbladditem.setBounds(238, 50, 113, 104);
		 * 
		 * Adminlbladditem.setIcon(new ImageIcon(new
		 * ImageIcon("img\\add.png").getImage().getScaledInstance(Adminlbladditem.
		 * getWidth(), Adminlbladditem.getHeight(), Image.SCALE_DEFAULT)));
		 * contentPane.add(Adminlbladditem);
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
		
		//
		
		
		
		//

		AdminAddDesignation = new Placeholdertextfield();
		AdminAddDesignation.setBounds(176, 202, 231, 19);
		AdminAddDesignation.setPlaceholder("Designation");
		AdminAddDesignation.setOpaque(true);
		contentPane.add(AdminAddDesignation);
		
		AdminAddCode = new Placeholdertextfield();
		AdminAddCode.setBounds(176, 231, 231, 19);
		AdminAddCode.setPlaceholder("Code");
		AdminAddCode.setOpaque(true);
		contentPane.add(AdminAddCode);
		
		AdminAddPrice = new Placeholdertextfield();
		AdminAddPrice.setBounds(176, 260, 231, 19);
		AdminAddPrice.setPlaceholder("Price");
		AdminAddPrice.setOpaque(true);
		contentPane.add(AdminAddPrice);
		
		AdminAddType = new Placeholdertextfield();
		AdminAddType.setBounds(176, 289, 231, 19);
		AdminAddType.setPlaceholder("Type");
		AdminAddType.setOpaque(true);
		contentPane.add(AdminAddType);
	
		JButton Adminbtncancel = new JButton("Cancel");
		Adminbtncancel.setForeground(Color.DARK_GRAY);
		Adminbtncancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		Adminbtncancel.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		Adminbtncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "carregaste no cancel");
				close();
			}
		});
		Adminbtncancel.setBounds(85, 383, 145, 56);
		
		contentPane.add(Adminbtncancel);
		
		JButton Adminbtncreate = new JButton("Create");
		Adminbtncreate.setForeground(Color.DARK_GRAY);
		Adminbtncreate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		Adminbtncreate.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		Adminbtncreate.setBounds(343, 383, 145, 56);
		Adminbtncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "carregaste no create");
				String designation = AdminAddDesignation.getText();
				String code = AdminAddCode.getText();
				Double price = Double.parseDouble(AdminAddPrice.getText());
				String type = AdminAddType.getText().toUpperCase();
				String image = (pathName.isEmpty()?"img\\product.png":pathName);
				
								
				if(Engine.addProduct(new Product(designation, code, price, type, image))) {
					JOptionPane.showMessageDialog(null, "Produto adicionado COM sucesso!");
					close();
				} else {
					JOptionPane.showMessageDialog(null, "Produto adicionado SEM sucesso!");
				}	
			}
		});
		contentPane.add(Adminbtncreate);
		
		this.setVisible(true);
	}
	
	public void close(){
		this.dispose();
	}
	public Boolean fieldValidation() {
		Boolean result = true;
		
			if (AdminAddDesignation.getText().equals("")){ /* verifica se o campos esta vazio */
				AdminAddDesignation.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				AdminAddDesignation.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
			
			if (AdminAddCode.getText().equals("")){ /* verifica se o campos esta vazio */
				AdminAddCode.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				AdminAddCode.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
			
			if (AdminAddPrice.getText().equals("")){ /* verifica se o campos esta vazio */
				AdminAddPrice.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				AdminAddPrice.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
			
			if (AdminAddType.getText().equals("")){ /* verifica se o campos esta vazio */
				AdminAddType.setBackground(Color.RED); /* coloca o background para vermelho */
				result=false;
			} else {
				AdminAddType.setBackground(Color.WHITE);  /* coloca o background para branco */
				}
		return result;
	}
}
