import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

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
		textPane.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				try {
					System.out.println("Insert...");
					System.out.println(e.getDocument().getText(0, e.getDocument().getLength()));
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}
			public void removeUpdate(DocumentEvent e) {
				try {
					System.out.println("Removed...");
					System.out.println(e.getDocument().getText(0, e.getDocument().getLength()));
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}
			public void changedUpdate(DocumentEvent e) {
				try {
					System.out.println("Changed...");
					System.out.println(e.getDocument().getText(0, e.getDocument().getLength()));
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}
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
