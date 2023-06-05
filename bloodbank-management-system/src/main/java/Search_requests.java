
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class Search_requests extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static Workbook wb;
	private static Sheet sh;
	private static Cell cell;
	private static Row row;
	private CellStyle cellstyle;
	private Color mycolor;
	private String excelFilePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_requests frame = new Search_requests();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Search_requests() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(75, 128, 215, 255));

		JLabel lblNewLabel = new JLabel("Email ID: ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel.setBounds(20, 70, 150, 20);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField.setForeground(new java.awt.Color(0, 0, 0));
		textField.setBounds(180, 70, 170, 26);
		textField.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.add(textField);
		textField.setColumns(10);


		JLabel lblNewLabel_1 = new JLabel("Requested Blood Group");
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(136, 116, 250, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Blood Group: ");
		lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(20, 160, 135, 25);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("<<Back");
		btnNewButton.setBounds(10, 20, 100, 30);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(340, 255, 120, 30);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_1.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String r1 = textField.getText();

				// check the userid from database and display request_blood_grp
				try {
					Class.forName("org.postgresql.Driver");
				}
				catch(ClassNotFoundException e1)
				{
					System.out.println("Error in loading driver");
				}
				String url="jdbc:postgresql://localhost:5432/bloodbank";
				String name="postgres";
				String pass="987987";
				Connection con;
				try {
					con = DriverManager.getConnection(url,name,pass);
					PreparedStatement st = (PreparedStatement) con
							.prepareStatement("Select blood_group from request where email_id =?");
					st.setString(1, r1);

					ResultSet rs = st.executeQuery();
					if(rs.next()) {
						String r2 = rs.getString("blood_group");
						JLabel lblNewLabel_3 = new JLabel(r2);
						lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
						lblNewLabel_3.setBackground(new java.awt.Color(75, 128, 215));
						lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255));
						lblNewLabel_3.setBounds(225, 162, 125, 22);
						contentPane.add(lblNewLabel_3);
						setState(Viewprofile.ICONIFIED);
						setState(Viewprofile.NORMAL);
					}

					else if(r1.equals("")) {
						JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Blood Group Not Found");
					}
				}
				catch(SQLException e1)
				{
					System.out.println("Error in connection");
				}
			}});
		contentPane.add(btnNewButton_1);
	}

}


































































































//import java.awt.*;
//import java.awt.event.*;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Color;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.event.ActionEvent;
//
//public class Search_requests extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField textField;
//	private static FileInputStream fis;
//    private static FileOutputStream fos;
//    private static Workbook wb;
//    private static Sheet sh;
//    private static Cell cell;
//    private static Row row;
//    private CellStyle cellstyle;
//    private Color mycolor;
//    private String excelFilePath;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Search_requests frame = new Search_requests();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 * @throws IOException
//	 * @throws EncryptedDocumentException
//	 */
//	public Search_requests() throws EncryptedDocumentException, IOException {
//		fis = new FileInputStream("./Booook.xlsx");
//		wb=WorkbookFactory.create(fis);
//		sh=wb.getSheet("Sheet1");
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 500, 350);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBackground(new java.awt.Color(75, 128, 215, 255));
//
//		JLabel lblNewLabel = new JLabel("Email ID: ");
//		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
//		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
//		lblNewLabel.setBounds(30, 74, 150, 20);
//		contentPane.add(lblNewLabel);
//
//
//		textField = new JTextField();
//		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
//		textField.setForeground(new java.awt.Color(0, 0, 0));
//		textField.setBounds(180, 70, 170, 26);
//		textField.setBorder(new EmptyBorder(1,1,1,1));
//		contentPane.add(textField);
//		textField.setColumns(10);
//
//
//		JLabel lblNewLabel_1 = new JLabel("Requested Blood Group");
//		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
//		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
//		lblNewLabel_1.setBounds(136, 116, 250, 25);
//		contentPane.add(lblNewLabel_1);
//
//		JLabel lblNewLabel_2 = new JLabel("Blood Group: ");
//		lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255));
//		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
//		lblNewLabel_2.setBounds(20, 160, 135, 25);
//		contentPane.add(lblNewLabel_2);
//
//
//
//
//
//		JButton btnNewButton = new JButton("<<Back");
//		btnNewButton.setBounds(10, 20, 100, 30);
//		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
//		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
//		btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
//
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
//				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
//				btnNewButton.setBorderPainted(true);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
//				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
//			}
//		});
//
//
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Admin.main(null);
//				dispose();
//			}
//		});
//		contentPane.add(btnNewButton);
//
//		JButton btnNewButton_1 = new JButton("Search");
//		btnNewButton_1.setBounds(340, 255, 120, 30);
//		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
//		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//		btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));
//
//		btnNewButton_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
//				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//				btnNewButton_1.setBorderPainted(true);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
//				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//			}
//		});
//
//
//
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				addToDB();
//				 String r1 = textField.getText();
//
//
//					int noOfRows=sh.getLastRowNum();
//
//					for(int i=1;i<=noOfRows;i++) {
//
//	        			Cell q1 = sh.getRow(i).getCell(0);
//	        			String a1 = q1.toString();
//	        			if(a1.equals(r1)){
//	              			Cell b1 = sh.getRow(i).getCell(4);
//	              			String c1 = b1.toString();
//		              		JLabel lblNewLabel_3 = new JLabel(c1);
//		            		lblNewLabel_3.setBounds(224, 142, 125, 16);
//		            		contentPane.add(lblNewLabel_3);
//		            		setState(Viewprofile.ICONIFIED);
//							 setState(Viewprofile.NORMAL);
//		            		break;
//	              			}
//	        			else if(!a1.equals(r1)) {
//              				continue;
//              			}
//
//	        			else if(r1.equals("")) {
//              				JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
//              				break;
//              			}
//
//
//
//			}
//
//
//			}});
//		contentPane.add(btnNewButton_1);
//}
//
//	public void addToDB() {
//		String email;
//		email = textField.getText();
//		try {
//
//			Connection c = null;
//			Statement st = null;
//			ResultSet rs = null;
//
//			String url = "jdbc:postgresql://localhost:5432/bloodbank";
//			String username1 = "postgres";
//			String password1 = "987987";
//			Class.forName("org.postgresql.Driver");
//			c = DriverManager.getConnection(url, username1, password1);
//			c.setAutoCommit(false);
//			st = c.createStatement();
//
////						String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
//			String nam = "Select blood_group from request where email_id='"+email+"';";
//
//			rs = st.executeQuery(nam);
//			while(rs.next()){
//				System.out.println(rs.getString(1));
//			}
//
////			rs = st.executeQuery(pin);
////			rs = st.executeQuery(dob);
//
//			c.commit();
//
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//	}
//
//}



















































