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
	TextManager textManager;
	
	Editor() {
		textManager = new TextManager();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GCode Translate");
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		textPane = new JTextPane();
		
//		TODO Keylisteners :)
//		textPane.addKeyListener(new KeyListener() {
//
//			public void keyPressed(KeyEvent e) {
//				keyPressedHandler(e);
//			}
//			public void keyTyped(KeyEvent e) {}
//			public void keyReleased(KeyEvent e) {}
//			
//		});
		
		textPane.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				try {
					updateTextManager(e.getDocument().getText(0, e.getDocument().getLength()));
					System.out.println(textManager.getTextPaneContents());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}
			public void removeUpdate(DocumentEvent e) {
				try {
					updateTextManager(e.getDocument().getText(0, e.getDocument().getLength()));
					System.out.println(textManager.getTextPaneContents());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}
			public void changedUpdate(DocumentEvent e) {
				try {
					updateTextManager(e.getDocument().getText(0, e.getDocument().getLength()));
					System.out.println(textManager.getTextPaneContents());
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
		// TODO Key press handled here.
	}
	
	public void updateTextManager(String arg) {
		this.textManager.setTextPaneContents(arg);
	}
	
}
