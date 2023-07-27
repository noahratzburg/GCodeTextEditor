//
//
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Scanner;
//
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.ScrollPaneConstants;
//
//public class Editor extends JFrame implements ActionListener{
//
//	JTextArea textArea;
//	JScrollPane scrollPane;
//	
//	String pgm;
//	String[] items;
//	String[] colorCode;
//	
//	Scanner scanner = new Scanner(pgm);
//	
//	
//	
//	Editor(){
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setTitle("Gcode Translate");
//		this.setSize(500, 500);
//		this.setLayout(new FlowLayout());
//		this.setLocationRelativeTo(null);
//		
//		textArea = new JTextArea();
//		textArea.setLineWrap(false);
//		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
//		
//		scrollPane = new JScrollPane(textArea);
//		scrollPane.setPreferredSize(new Dimension(450, 450));
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		
//		
//		this.add(scrollPane);
//		this.setVisible(true);
//		
//	
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println(e.hashCode());
//		
//		
//	}
//
//}

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Editor extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextPane textPane;
	JScrollPane scrollPane;
	
	Editor() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GCode Translate");
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		textPane = new JTextPane();
		textPane.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				keyPressedHandler(e);
			}
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			
		});
		//textArea.setLineWrap(false);
		textPane.setFont(new Font("Arial", Font.PLAIN, 14));
		
		scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(450, 450));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		this.add(scrollPane);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyPressedHandler(KeyEvent e) {
		System.out.println("Key Event Captured : " + e.getKeyChar());
	}
	
}
