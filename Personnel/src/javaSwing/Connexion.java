package javaSwing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Connexion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(75, 100, 272, 21);
		contentPane.add(textArea);
		textArea.getText();

		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(75, 140, 272, 21);
		contentPane.add(passwordField);
		
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.setBounds(229, 179, 118, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValue = textArea.getText();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Gestion des ligues et des employées");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(61, 24, 312, 42);
		contentPane.add(lblNewLabel);
		panel.setBorder(UIManager.getBorder("PopupMenu.border"));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(61, 76, 301, 135);
		contentPane.add(panel);
		
	}    
}
