package javaSwing;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ModifEmploye extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblPrnom;
	private JLabel lblEmail;
	private JLabel lblPrnom_2;
	private JLabel lblPrnom_3;
	private JLabel lblPrnom_4;
	private JLabel lblPrnom_5;
	private JLabel lblPrnom_6;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifEmploye frame = new ModifEmploye();
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
	public ModifEmploye() {
		Container container = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(92, 129, 225, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(462, 129, 225, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(462, 190, 225, 19);
		contentPane.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 190, 225, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(462, 251, 225, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 312, 225, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(462, 312, 225, 21);
		contentPane.add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 251, 225, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(414, 377, 125, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(563, 377, 125, 26);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(92, 93, 85, 26);
		contentPane.add(lblNewLabel);
		
		lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrnom.setBounds(462, 93, 85, 26);
		contentPane.add(lblPrnom);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(92, 158, 85, 26);
		contentPane.add(lblEmail);
		
		lblPrnom_2 = new JLabel("Mot de passe");
		lblPrnom_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrnom_2.setBounds(462, 158, 142, 26);
		contentPane.add(lblPrnom_2);
		
		lblPrnom_3 = new JLabel("Date de commencement");
		lblPrnom_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrnom_3.setBounds(92, 219, 189, 26);
		contentPane.add(lblPrnom_3);
		
		lblPrnom_4 = new JLabel("Date de fin de service");
		lblPrnom_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrnom_4.setBounds(462, 219, 195, 26);
		contentPane.add(lblPrnom_4);
		
		lblPrnom_5 = new JLabel("R\u00F4le");
		lblPrnom_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrnom_5.setBounds(92, 286, 85, 26);
		contentPane.add(lblPrnom_5);
		
		lblPrnom_6 = new JLabel("Ligue");
		lblPrnom_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrnom_6.setBounds(462, 280, 85, 26);
		contentPane.add(lblPrnom_6);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 47, 160));
		panel.setBounds(0, -24, 768, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Root");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(713, 34, 45, 13);
		panel.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("Pr\u00E9c\u00E9dent");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(29, 62, 132, 21);
		contentPane.add(btnNewButton_2);
	    Border emptyBorder = BorderFactory.createEmptyBorder();
	    btnNewButton_2.setBorder(null);
	}
}