import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class newuser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private CellStyle cellstyle;
	private Color mycolor;
	private String excelFilePath;


	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newuser frame = new newuser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public newuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 50, 50));
		contentPane.setBackground(new java.awt.Color(75, 128, 215));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Email ID: ");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_3.setBounds(15, 310, 170, 56);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBackground(java.awt.Color.white);
		textField_3.setForeground(java.awt.Color.BLACK);
		textField_3.setBorder(new EmptyBorder(1, 1, 1, 1));
		textField_3.setBounds(215, 320, 200, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel.setBounds(15, 40, 155, 56);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(java.awt.Color.white);
		textField.setForeground(java.awt.Color.BLACK);
		textField.setBorder(new EmptyBorder(1, 1, 1, 1));
		textField.setBounds(214, 55, 200, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Date of Birth: ");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_1.setBounds(15, 130, 155, 56);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBackground(java.awt.Color.white);
		textField_1.setBounds(214, 145, 200, 30);
		textField_1.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Pincode:");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_2.setBounds(15, 217, 155, 56);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBackground(java.awt.Color.white);
		textField_2.setBorder(new EmptyBorder(1, 1, 1, 1));
		textField_2.setBounds(214, 227, 200, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);


		try {
			if (textField_2.getText() == "" || textField.getText() == "" || textField_1.getText() == "" || textField_3.getText() == "") {
				JOptionPane.showMessageDialog(null, "            Enter All Fields    ", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}catch(NullPointerException e){
			e.printStackTrace();
		}

		JButton btnNewButton = new JButton("Next >>");
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215, 255));
		btnNewButton.setForeground(new java.awt.Color(255,255,255));
		btnNewButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(200, 395, 97, 39);

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
				addToDB();
			}
		});
//				String s1 = textField.getText();
//				String s2 = textField_1.getText();
//				String s4 = textField_2.getText();
//				String s5 = textField_3.getText();
//
//				try {
//
//					Connection c=null;
//					Statement st = null;
//					ResultSet rs = null;
//
//					String url = "jdbc:postgresql://localhost:5432/bloodbank";
//					String username1 = "postgres";
//					String password1 = "987987";
//					Class.forName("org.postgresql.Driver");
//					c = DriverManager.getConnection(url, username1, password1);
//					c.setAutoCommit(false);
//					st = c.createStatement();
//
//					ResultSet rsq = null;
////					String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
//					String sql = "SELECT * FROM logindetails;";
//					rsq = st.executeQuery(sql);
//
//					while(rsq.next()){
//						System.out.println(rsq.getString(2));
//					}
//
//					c.commit();
//
//			} catch (Exception ex){
//					System.out.println(ex);
//				}
//
//				while (true) {
//					if (s1.equals("") || s2.equals("") || s4.equals("") || s5.equals("")) {
//						JOptionPane.showMessageDialog(null, "           FILL ALL Details      ", "ERROR",JOptionPane.ERROR_MESSAGE);
//						break;
//					} else if (true) {
//						int noOfRows = sh.getLastRowNum();
//						row = sh.createRow(noOfRows + 1);
//						cell = row.createCell(0);
//						cell.setCellValue(s1);
//						cell = row.createCell(1);
//						cell.setCellValue(s2);
//						cell = row.createCell(2);
//						cell.setCellValue(s4);
//						cell = row.createCell(3);
//						cell.setCellValue(s5);
//						try {
//							fos = new FileOutputStream("./Booook.xlsx");
//						} catch (FileNotFoundException e1) {
//							e1.printStackTrace();
//						}
//						try {
//							wb.write(fos);
//						} catch (IOException e1) {
//							e1.printStackTrace();
//						}
//						try {
//							fos.flush();
//						} catch (IOException e1) {
//							e1.printStackTrace();
//						}
//						try {
//							fos.close();
//						} catch (IOException e1) {
//							e1.printStackTrace();
//						}
//
//						try {
//							username.main(null);
//						} catch (EncryptedDocumentException e1) {
//
//							e1.printStackTrace();
//						} catch (IOException e1) {
//
//							e1.printStackTrace();
//						}
//						dispose();
//						break;
//					}
//				}
//			}
//		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<< Back");
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215, 255));
		btnNewButton_1.setForeground(new java.awt.Color(255,255,255));
		btnNewButton_1.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(10, 11, 89, 23);

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
				Login1.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_5 = new JLabel("dd-mm-yyyy");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_5.setBounds(220, 175, 112, 30);
		contentPane.add(lblNewLabel_5);

	}


	public void addToDB() {
		String name, dob, pin, email;
		name = textField.getText();
		dob = textField_1.getText();
		pin = textField_2.getText();
		email = textField_3.getText();
		if(name.equals("") || dob.equals("") || pin.equals("") || email.equals("")){
			JOptionPane.showMessageDialog(null, "            Fill in the details    ", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else {
			try {

				Connection c = null;
				Statement st = null;
				ResultSet rs = null;

				String url = "jdbc:postgresql://localhost:5432/bloodbank";
				String username1 = "postgres";
				String password1 = "987987";
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection(url, username1, password1);
				c.setAutoCommit(false);
				st = c.createStatement();

				ResultSet rsq = null;
//						String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
				String sql = "insert into logindetails values('" + name + "','" + dob + "','" + pin + "','" + email + "');";
				System.out.println(sql);
				st.executeUpdate(sql);
				username.main(null);
				dispose();


				c.commit();

			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}
}