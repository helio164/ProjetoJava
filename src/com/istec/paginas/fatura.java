package com.istec.paginas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.istec.componentes.ListOfSales;
import com.istec.objectos.Engine;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import java.awt.Dimension;

public class fatura extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fatura frame = new fatura();
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
	public fatura() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Engine.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(Color.WHITE);
		panelHeader.setSize(contentPane.getWidth(), (int)(contentPane.getHeight()*0.40));
		contentPane.add(panelHeader, BorderLayout.PAGE_START);
		panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
		
		JLabel lblStoreName = new JLabel(Engine.currentStore.name);
		lblStoreName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblStoreName.setHorizontalAlignment(SwingConstants.CENTER);
		//lblStoreName.setBounds(123, 5, 151, 37);
		lblStoreName.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelHeader.add(lblStoreName);

		JLabel lblVAT = new JLabel("VAT:\t"+Engine.currentStore.vat);
		//lblVAT.setBounds(279, 17, 23, 13);
		panelHeader.add(lblVAT);

		ListOfSales listOfSales = new ListOfSales(10,85);
		listOfSales.setBackground(new Color(255, 255, 255));
		contentPane.add(listOfSales, BorderLayout.CENTER);
		contentPane.add(listOfSales);
		
		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(Color.WHITE);
		contentPane.add(panelFooter, BorderLayout.SOUTH);
		panelFooter.setLayout(new BoxLayout(panelFooter, BoxLayout.Y_AXIS));
		
		JLabel lblThankYou = new JLabel("Thank You");
		lblThankYou.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblThankYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYou.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelFooter.add(lblThankYou);
		
		JLabel lblComeAgain = new JLabel("Come again");
		lblComeAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelFooter.add(lblComeAgain);
		
		
		
		
		listOfSales.loadSales();
		this.setVisible(true);
	}
}
