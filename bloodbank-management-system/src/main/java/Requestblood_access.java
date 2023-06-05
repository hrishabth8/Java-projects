import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

import javax.swing.border.LineBorder;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class Requestblood_access extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	private JTextField textField_q;
	private JTextField textField_loc;
	private JTextField textField_hosp;
	private JTextField textField_ph;
	private JTextField textField_dt;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requestblood_access frame = new Requestblood_access();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Requestblood_access() throws EncryptedDocumentException, IOException {
		
//		fis = new FileInputStream("./Booook.xlsx");
//		wb=WorkbookFactory.create(fis);
//		sh=wb.getSheet("Sheet1");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		contentPane.setBackground(new java.awt.Color(75, 128, 215));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Request Blood");
		lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_3.setBounds(180, 10, 170, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Email ID ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel.setBounds(31, 70, 121, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_1.setBounds(31, 115, 121, 20);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(240, 70, 150, 26);
		textField.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(new EmptyBorder(1,1,1,1));
		textField.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 115, 150, 26);
		textField_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		textField_1.setBorder(new EmptyBorder(1,1,1,1));
		textField.setForeground(new java.awt.Color(0, 0, 0));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Required Blood </br>Group</html>");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_2.setBounds(31, 150, 200, 60);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		textField_2.setBorder(new EmptyBorder(1,1,1,1));
		textField_2.setForeground(new java.awt.Color(0, 0, 0));
		textField_2.setBounds(240, 165, 150, 26);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textField_2);
		textField_2.setColumns(10);


		JLabel lblNewLabel_q = new JLabel("Quantity");
		lblNewLabel_q.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_q.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_q.setBounds(31, 200, 200, 60);
		contentPane.add(lblNewLabel_q);

		textField_q = new JTextField();
		textField_q.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		textField_q.setBorder(new EmptyBorder(1,1,1,1));
		textField_q.setForeground(new java.awt.Color(0, 0, 0));
		textField_q.setHorizontalAlignment(SwingConstants.CENTER);
		textField_q.setBounds(240, 215, 150, 26);
		contentPane.add(textField_q);
		textField_q.setColumns(10);


		JLabel lblNewLabel_loc = new JLabel("Pincode");
		lblNewLabel_loc.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_loc.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_loc.setBounds(31, 245, 200, 60);
		contentPane.add(lblNewLabel_loc);

		textField_loc = new JTextField();
		textField_loc.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		textField_loc.setBorder(new EmptyBorder(1,1,1,1));
		textField_loc.setForeground(new java.awt.Color(0, 0, 0));
		textField_loc.setHorizontalAlignment(SwingConstants.CENTER);
		textField_loc.setBounds(240, 265, 150, 26);
		contentPane.add(textField_loc);
		textField_loc.setColumns(10);


		JLabel lblNewLabel_hosp = new JLabel("Hospital ID");
		lblNewLabel_hosp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_hosp.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel_hosp.setBounds(31, 300, 200, 60);
		contentPane.add(lblNewLabel_hosp);
		//hosp
		textField_hosp = new JTextField();
		textField_hosp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		textField_hosp.setHorizontalAlignment(SwingConstants.CENTER);
		textField_hosp.setBounds(240, 315, 150, 26);
		textField_hosp.setBorder(new EmptyBorder(1,1,1,1));
		textField_hosp.setForeground(java.awt.Color.black);
		contentPane.add(textField_hosp);
		textField_hosp.setColumns(10);


		JLabel lblNewLabel_ph = new JLabel("Phone.no ");
		lblNewLabel_ph.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_ph.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel_ph.setBounds(31, 350, 200, 60);
		contentPane.add(lblNewLabel_ph);
		//hosp
		textField_ph = new JTextField();
		textField_ph.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		textField_ph.setHorizontalAlignment(SwingConstants.CENTER);
		textField_ph.setBounds(240, 365, 150, 26);
		textField_ph.setBorder(new EmptyBorder(1,1,1,1));
		textField_ph.setForeground(java.awt.Color.black);
		contentPane.add(textField_ph);
		textField_ph.setColumns(10);


		JLabel lblNewLabel_dt = new JLabel("Date ");
		lblNewLabel_dt.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_dt.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel_dt.setBounds(31, 400, 200, 60);
		contentPane.add(lblNewLabel_dt);
		//hosp
		textField_dt = new JTextField();
		textField_dt.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		textField_dt.setHorizontalAlignment(SwingConstants.CENTER);
		textField_dt.setBounds(240, 415, 150, 26);
		textField_dt.setBorder(new EmptyBorder(1,1,1,1));
		textField_dt.setForeground(java.awt.Color.black);
		contentPane.add(textField_dt);
		textField_dt.setColumns(10);


		/*JButton btnNewButton_ss = new JButton("Single Stock");
		btnNewButton_ss.setBounds(10, 320, 190, 35);
		btnNewButton_ss.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_ss.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_ss.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_ss.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton_ss.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_ss.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_ss.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_ss.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_ss.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_ss.setForeground(new java.awt.Color(255, 255, 255));
			}

		});
		btnNewButton_ss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Request_Blood.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton_ss);
*/





		JButton btnNewButton = new JButton("Next >");
		btnNewButton.setBounds(355, 470, 120, 35);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
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
				addToDB();
				JOptionPane.showMessageDialog(null, "           DETAILS ENTERED     ", "",JOptionPane.INFORMATION_MESSAGE);
				dispose();
		}
		});
//				String t1 = textField.getText();
//				String t2 = textField_1.getText();
//				String t3 = textField_2.getText();
//
//				JOptionPane.showMessageDialog(null, "           DETAILS ENTERED     ", "",JOptionPane.INFORMATION_MESSAGE);
//
//				int noOfRows=sh.getLastRowNum();
//				int j = 1;
//				for(int i=1;i<=noOfRows;i++) {
//					j=i;
//        			Cell r1 = sh.getRow(i).getCell(0);
//        			Cell r2 = sh.getRow(i).getCell(1);
//        			Cell r3 = sh.getRow(i).getCell(2);
//        			Cell r4 = sh.getRow(i).getCell(3);
//
//        			String a1 = r1.toString();
//        			String a2 = r2.toString();
//        			String a3 = r3.toString();
//        			String a4 = r4.toString();
//        			if(a1.equals(t1)&& a2.equals(t2)){
//
//
//
//             			row = sh.createRow(i);
//             			cell = row.createCell(0);
//             			cell.setCellValue(t1);
//             			cell = row.createCell(1);
//             			cell.setCellValue(t2);
//             			cell = row.createCell(2);
//             			cell.setCellValue(a3);
//             			cell = row.createCell(3);
//             			cell.setCellValue(a4);
//             			cell = row.createCell(4);
//             			cell.setCellValue(t3);
//
//             			try {
//    						fos = new FileOutputStream("./Booook.xlsx");
//    					} catch (FileNotFoundException e1) {
//
//    						e1.printStackTrace();
//    					}
//             			try {
//    						wb.write(fos);
//    					} catch (IOException e1) {
//
//    						e1.printStackTrace();
//    					}
//             			try {
//    						fos.flush();
//    					} catch (IOException e1) {
//
//    						e1.printStackTrace();
//    					}
//             			try {
//    						fos.close();
//    					} catch (IOException e1) {
//
//    						e1.printStackTrace();
//    					}
//             			Request_Blood.main(null);
//             			dispose();
//             			break;
//    	              }
//        			else if(!a1.equals(t1) || !a2.equals(t2)) {
//        				continue;
//	                	}
//        			 else if(t1.equals("") || t2.equals("") || t3.equals("")) {
//        				 textField.setText(null);
//        				 textField_1.setText(null);
//        				 textField_2.setText(null);
//        				 JOptionPane.showMessageDialog(null, "          INVALID DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
//  						break;
//        			 }
//			}
//				Cell c1 = sh.getRow(j).getCell(0);
//    			Cell c2 = sh.getRow(j).getCell(1);
//    			String b1 = c1.toString();
//    			String b2 = c2.toString();
//    			if(!b1.equals(t1) && !b2.equals(t2)) {
//    				textField.setText(null);
//   				 textField_1.setText(null);
//   				 textField_2.setText(null);
//   				 JOptionPane.showMessageDialog(null, "          INVALID DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
//
//                	}
//
//		}
//		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.setBounds(10, 5, 100, 30);
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
			public void actionPerformed(ActionEvent arg0) {
				Mainframe.main(null);
				dispose();
				
			}
		});
		contentPane.add(btnNewButton_1);
	}

	public void addToDB() {
		String qnt, bldgrp, pass, email,pin,hid,phno,date;
		email = textField.getText();
		pass = textField_1.getText();
		bldgrp=textField_2.getText();
		qnt = textField_q.getText();
		pin = textField_loc.getText();
		hid = textField_hosp.getText();
		phno = textField_ph.getText();
		date = textField_dt.getText();

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
			String sql = "insert into request values('"+email+"','" +bldgrp+ "','" + qnt + "','" + pin + "','" + hid + "','" + phno + "','" + date + "');";
			System.out.println(sql);
			st.executeUpdate(sql);

			c.commit();

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
}