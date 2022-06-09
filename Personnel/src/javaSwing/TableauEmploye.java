package javaSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TableauEmploye extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

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
	public TableauEmploye() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 693, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table_1 = new JTable();
		table_1.setBounds(45, 37, 612, 338);
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
			JOptionPane.showInputDialog( "Pilote JDBC non installé.");
		}
		catch (SQLException e)
		{
			JOptionPane.showInputDialog(e);
			JOptionPane.showInputDialog("Connexion échouée");
		}
	}
	}