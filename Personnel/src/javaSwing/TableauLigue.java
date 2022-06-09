package javaSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TableauLigue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableauEmploye frame = new TableauEmploye();
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
	public TableauLigue() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 47, 160));
		panel.setBounds(0, -24, 768, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		lblNewLabel = new JLabel("Root");
		lblNewLabel.setBounds(647, 13, 111, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 43, 693, 364);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		 
		table_1 = new JTable();
		table_1.setBounds(45, 49, 612, 326);
		contentPane.add(table_1);
		
		try
		{
			Class.forName(Credentials.getDriverClassName());
			connection = DriverManager.getConnection(Credentials.getUrl(), Credentials.getUser(), Credentials.getPassword());
			Statement st=con.createStatement();
			String query="select * from ligue";
			ResultSet rs= st.executeQuery(query);
			ResultMetaData rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) tblData.getModel();
			
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showInputDialog( "Pilote JDBC non installï¿½.");
		}
		catch (SQLException e)
		{
			JOptionPane.showInputDialog(e);
			JOptionPane.showInputDialog("Connexion ï¿½chouï¿½e");
		}
	}
	}
