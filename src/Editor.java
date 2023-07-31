import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.DefaultStyledDocument;

public class Editor extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextPane textPane;
	JScrollPane scrollPane;
	TextManager textManager;
	StyledDocument doc;
	
	Editor() {
		textManager = new TextManager(
				'\n'+
				"G90G53G00 Z0." + '\n' +
				"S6000 M3 (spinny boi)" + '\n' +
				"G54x-69. y420.  A-0.606 M8" + '\n' +
				"G0 Z1." + '\n' +
				"G99 G81 Z-3.0 P0.2 F82."
				);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GCode Translate");
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		
		doc = new DefaultStyledDocument();
		textPane = new JTextPane(doc);
		try {
			doc.insertString(0, textManager.getTextPaneContents(), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
					updateTextManagerAppend(e.getOffset(), e.getDocument().getText(e.getOffset(),e.getLength()));
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}
			public void removeUpdate(DocumentEvent e) {
				try {
					updateTextManagerTrim(e.getOffset(), e.getLength(), e.getDocument().getText(0, e.getDocument().getLength()));
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}
			public void changedUpdate(DocumentEvent e) {
				try {
					updateChange(e.getDocument().getText(0, e.getDocument().getLength()));
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
		
		//Line line = new Line("G90G54G00x-1.23456y0.000002z69.0     A-0.606 M8 (boop)");
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyPressedHandler(KeyEvent e) {
		// TODO Key press handled here.
	}
	
	public void updateTextManagerAppend(int offset, String arg) {
		System.out.println("Append offset: " + offset + ", string: " + arg);
		this.textManager.appendTextPaneContents(offset, arg);
		System.out.println(textManager.getTextPaneContents());
	}
	public void updateTextManagerTrim(int offset, int amount, String arg) {
		System.out.println("Trim offset: " + offset + ", amount: " + amount);
		this.textManager.trimTextPaneContents(offset, amount);
		System.out.println(textManager.getTextPaneContents());
	}
	public void updateTextManagerSet(String arg) {
		this.textManager.setTextPaneContents(arg);
	}
	public void updateChange(String arg) {
		
	}
}
