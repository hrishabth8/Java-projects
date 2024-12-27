import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class Search_donations extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private CellStyle cellstyle;
	private Color mycolor;
	private String excelFilePath;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_donations frame = new Search_donations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Search_donations() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(75, 128, 215, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Email ID");
		lblNewLabel.setBounds(40,40,150,70);
		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		contentPane.add(lblNewLabel);

		contentPane.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		contentPane.setBackground(new java.awt.Color(75, 128, 215));
		textField = new JTextField();
		textField.setBounds(210, 62, 180, 26);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN|Font.BOLD, 15));
		textField.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.add(textField);
		textField.setColumns(10);


		JLabel lblNewLabel_1 = new JLabel("Appointed Date and Time");
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(105, 112, 220, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date: ");
		lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255, 255));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(20, 160, 80, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Time: ");
		lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255, 255));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(20, 200, 80, 20);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(335, 270, 125, 32);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setBorder(new EmptyBorder(1,1,1,1));


// the functions of mouse such as entering the button area or exiting the button area
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

			}

		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String r1 = textField.getText();

				// check the userid and display the date and time

				try {
					Class.forName("org.postgresql.Driver");
				}
				catch(ClassNotFoundException e1)
				{
					System.out.println("Error in loading driver");
				}
				String url="jdbc:postgresql://localhost:5433/bloodbank";
				String name="postgres";
				String pass="123";
				Connection con;
				try {
					con = DriverManager.getConnection(url,name,pass);
					PreparedStatement st = (PreparedStatement) con
							.prepareStatement("Select date,time from blood_donation_slots where email_id =?");

					st.setString(1, r1);

					ResultSet rs = st.executeQuery();


					if(rs.next()) {
						String a1 = rs.getString("date");
						String a2 = rs.getString("time");
						JLabel lblNewLabel_4 = new JLabel(a1);
						lblNewLabel_4.setBounds(135, 160, 154, 16);
						lblNewLabel_4.setForeground(new java.awt.Color(255, 255, 255, 255));
						lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));

						contentPane.add(lblNewLabel_4);

						JLabel lblNewLabel_5 = new JLabel(a2);
						lblNewLabel_5.setBounds(135, 200, 154, 16);
						lblNewLabel_5.setForeground(new java.awt.Color(255, 255, 255, 255));
						lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));

						contentPane.add(lblNewLabel_5);

						setState(Viewprofile.ICONIFIED);
						setState(Viewprofile.NORMAL);


					}
					else {
						JOptionPane.showMessageDialog(null, "No such user");
					}
				}
				catch(SQLException e1) {
					System.out.println(e1);
				}
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<<Back ");
		btnNewButton_1.setBounds(10, 10, 115, 30);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));


// the functions of mouse such as entering the button area or exiting the button area
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));

			}

		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
	}


}











































































































//import java.awt.*;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
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
//import java.awt.event.ActionListener;
//
//public class Search_donations extends JFrame {
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
//					Search_donations frame = new Search_donations();
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
//	public Search_donations() throws EncryptedDocumentException, IOException {
//		fis = new FileInputStream("./Booook.xlsx");
//		wb=WorkbookFactory.create(fis);
//		sh=wb.getSheet("Sheet1");
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 500, 350);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBackground(new java.awt.Color(75, 128, 215, 255));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("Email ID");
//		lblNewLabel.setBounds(40,40,150,70);
//		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255, 255));
//		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//		contentPane.add(lblNewLabel);
//
//		contentPane.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//		contentPane.setBackground(new java.awt.Color(75, 128, 215));
//		textField = new JTextField();
//		textField.setBounds(210, 62, 180, 26);
//		textField.setHorizontalAlignment(SwingConstants.CENTER);
//		textField.setFont(new Font("Lucida Grande", Font.PLAIN|Font.BOLD, 15));
//		textField.setBorder(new EmptyBorder(1,1,1,1));
//		contentPane.add(textField);
//		textField.setColumns(10);
//
//
//		JLabel lblNewLabel_1 = new JLabel("Appointed Date and Time");
//		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255, 255));
//		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
//		lblNewLabel_1.setBounds(105, 112, 220, 25);
//		contentPane.add(lblNewLabel_1);
//
//		JLabel lblNewLabel_2 = new JLabel("Date: ");
//		lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255, 255));
//		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
//		lblNewLabel_2.setBounds(20, 160, 80, 20);
//		contentPane.add(lblNewLabel_2);
//
//		JLabel lblNewLabel_3 = new JLabel("Time: ");
//		lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255, 255));
//		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
//		lblNewLabel_3.setBounds(20, 200, 80, 20);
//		contentPane.add(lblNewLabel_3);
//
//		JLabel lblNewLabel_st = new JLabel("Status: ");
//		lblNewLabel_st.setForeground(new java.awt.Color(255, 255, 255, 255));
//		lblNewLabel_st.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
//		lblNewLabel_st.setBounds(20, 240, 80, 20);
//		contentPane.add(lblNewLabel_st);
//
//
//		JButton btnNewButton = new JButton("Search");
//		btnNewButton.setBounds(335, 270, 125, 32);
//		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
//		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
//		btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
//
//
//// the functions of mouse such as entering the button area or exiting the button area
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
//				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
//				btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));
//
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
//				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
//				btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
//
//			}
//
//		});
//
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//               String r1 = textField.getText();
//
//
//				int noOfRows=sh.getLastRowNum();
//
//
//				for(int i=1;i<=noOfRows;i++) {
//
//        			Cell q1 = sh.getRow(i).getCell(0);
//        			String a1 = q1.toString();
//        			if(a1.equals(r1)){
//                   	 textField.setText(null);
//                   	 Cell b1,b2;
//                 		String c1,c2;
//
//                 		b1 = sh.getRow(i).getCell(2);
//                 		b2 = sh.getRow(i).getCell(3);
//                 		c1 = b1.toString();
//                		c2 = b2.toString();
//                		System.out.println(b1);
//                		JLabel lblNewLabel_4 = new JLabel(c1);
//               			lblNewLabel_4.setBounds(135, 160, 154, 16);
//						lblNewLabel_4.setForeground(new java.awt.Color(255, 255, 255, 255));
//						lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
//
//						contentPane.add(lblNewLabel_4);
//
//               		JLabel lblNewLabel_5 = new JLabel(c2);
//               		lblNewLabel_5.setBounds(135, 200, 154, 16);
//						lblNewLabel_5.setForeground(new java.awt.Color(255, 255, 255, 255));
//						lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
//
//						contentPane.add(lblNewLabel_5);
//
//               		setState(Viewprofile.ICONIFIED);
//   					 setState(Viewprofile.NORMAL);
//
//                  	 break;
//
//   				}
//        			else if(r1.equals("")) {
//          				JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
//          				break;
//          			}
//
//	               }
//
//				}
//		});
//		contentPane.add(btnNewButton);
//
//		JButton btnNewButton_1 = new JButton("<<Back ");
//		btnNewButton_1.setBounds(10, 10, 115, 30);
//		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
//		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//		btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));
//
//
//// the functions of mouse such as entering the button area or exiting the button area
//		btnNewButton_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
//				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//				btnNewButton_1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));
//
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
//				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//				btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));
//
//			}
//
//		});
//
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Admin.main(null);
//				dispose();
//			}
//		});
//		contentPane.add(btnNewButton_1);
//	}
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
//			String date = "Select date from donate where email_id='"+email+"';";
//			String time = "Select time from donate where email_id='" + email + "';";
////			System.out.println(nam);
////			System.out.println(pin);
////			System.out.println(dob);
//			rs = st.executeQuery(date);
//			while(rs.next()){
//				System.out.println(rs.getString(1));
//			}
//			rs = st.executeQuery(time);
//			while(rs.next()){
//				System.out.println(rs.getString(1));
//			}
////			rs = st.executeQuery(pin);
////			rs = st.executeQuery(dob);
//
//			c.commit();
//
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//	}
//}


























