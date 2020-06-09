package com.istec.componentes;

import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class ChooseFile {
	
	public ChooseFile(String filePath) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new JFrame(filePath);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File(filePath));
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				JLabel lbl = new JLabel();
				lbl.setIcon((Icon) new ImageIcon(img));
				frame.getContentPane().add(lbl, BorderLayout.CENTER);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);						
				
				
			}
		});
	}

}
