package com.istec.componentes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.istec.objectos.Engine;
import com.istec.objectos.User;

@SuppressWarnings("serial")
public class ListOfVendedoresPanel extends JPanel {

	public ListOfVendedoresPanel() {
		// TODO Auto-generated constructor stub
		JPanel Adminmainpanelusers = new JPanel();
		Adminmainpanelusers.setBounds(180, 20, 657, 73);
		Adminmainpanelusers.setLayout(new BoxLayout(Adminmainpanelusers, BoxLayout.X_AXIS));
		this.loadVendedores();		
	}
	
	public void loadVendedores() {
		this.removeAll();
		for(User u : Engine.currentStore.users) {
			JLabel label = new JLabel();
			label.setBounds(new Rectangle(70, 70));
			Border border = BorderFactory.createLineBorder(Color.BLACK, 0);
			label.setBorder(border);
			label.setToolTipText(u.username);
			label.setIcon(new ImageIcon(new ImageIcon(u.image).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, u.username+"\n"+u.email);
				}
			});		
			this.add(label);
		}
	}

}
