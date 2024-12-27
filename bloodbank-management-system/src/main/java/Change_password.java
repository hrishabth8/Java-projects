import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Change_password extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_password frame = new Change_password();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Change_password() {
// content pane
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(115, 150, 213));
		setContentPane(contentPane);
		contentPane.setLayout(null);


// username label
		JLabel lblNewLabel = new JLabel("Email ID\r\n",SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel.setBounds(101, 78, 157, 22);
		contentPane.add(lblNewLabel);

//username textfield
		textField = new JTextField();
		textField.setBounds(314, 78, 170, 22);
		textField.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		contentPane.add(textField);
		textField.setColumns(10);

// Current Password label
		JLabel lblNewLabel_1 = new JLabel("Current Password");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_1.setBounds(101, 141, 210, 22);
		contentPane.add(lblNewLabel_1);

// Current Password textfield
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		textField_1.setBounds(314, 141, 170, 22);
		contentPane.add(textField_1);

// New Password label
		JLabel lblNewLabel_1_1 = new JLabel("    New Password");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1_1.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(101, 203, 190, 22);
		contentPane.add(lblNewLabel_1_1);

// New Password textfield
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		textField_2.setBounds(314, 203, 170, 22);
		contentPane.add(textField_2);


		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//        		String s1 = textField.getText();
//    			String s2 = textField_1.getText();
//    			String s4 = textField_2.getText();
//    			int noOfRows=sh.getLastRowNum();
//        		for(int i=1;i<=noOfRows;i++) {
//        			Cell a1 = sh.getRow(i).getCell(0);
//        			Cell a2 = sh.getRow(i).getCell(1);
//
//        			String b1 = a1.toString();
//        			String b2 = a2.toString();
//
//        		 if(!b1.equals(s1) || !b2.equals(s2)) {
//	                	continue;}
//	              else if(b1.equals(s1) && b2.equals(s2)){
//
//                	 }
//
//        			row = sh.createRow(i);
//        			cell = row.createCell(0);
//        			cell.setCellValue(s1);
//        			cell = row.createCell(1);
//        			cell.setCellValue(s4);
//
//        			try {
//						fos = new FileOutputStream("./Booook.xlsx");
//					} catch (FileNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//        			try {
//						wb.write(fos);
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//        			try {
//						fos.flush();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//        			try {
//						fos.close();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//
//    			JOptionPane.showMessageDialog(null,"          PASSWORD CHANGED SUCCESSFULLY LOGIN AGAIN       ","CHANGE PASSWORD", JOptionPane.INFORMATION_MESSAGE);
//    			textField.setText(null);
//    			textField_1.setText(null);
//    			textField_2.setText(null);
//    			Login1.main(null);
//    			dispose();
//
//        		}
			addToDB();
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setBounds(180, 290, 220, 29);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(new LineBorder(java.awt.Color.white));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(new LineBorder(java.awt.Color.white));
			}

		});

		contentPane.add(btnNewButton);
	}
	public void addToDB(){
		boolean ans=false;
		String email,curpass,newpass;
		email=textField.getText();
		curpass=textField_1.getText();
		newpass=textField_2.getText();
		if(email.equals("") || curpass.equals("")|| newpass.equals("")){
			JOptionPane.showMessageDialog(null, "            Fields not filled    ", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
			Connection c = null;
			Statement st = null;
			ResultSet rs = null;
//			ResultSet rs1 = null;
			String url = "jdbc:postgresql://localhost:5433/bloodbank";
			String username1 = "postgres";
			String password1 = "123";
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, username1, password1);
			c.setAutoCommit(false);
			st = c.createStatement();
			ResultSet rsq = null;
//						String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
			String sql = "select password from login where email_id='"+email+"'";
//			String sql1 = "select login set password = '"+newpass+"' where email_id='"+email+"'";
			rs=st.executeQuery(sql);
				while (rs.next()){				//to iterate through the rows of the sql tables
					if(rs.getString(1).toString().equals(curpass) ){  // checks if the result from the database is the same the one from the textfield
						ans=true;
					}
					else{
						JOptionPane.showMessageDialog(null, "            Email or Password is wrong    ", "ERROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			c.commit();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		}
		if(ans){
			try {
				Connection c = null;
				Statement st = null;
				ResultSet rs = null;

				String url = "jdbc:postgresql://localhost:5433/bloodbank";
				String username1 = "postgres";
				String password1 = "123";
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection(url, username1, password1);
				c.setAutoCommit(false);
				st = c.createStatement();
				ResultSet rsq = null;
//						String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
				String sql = "update login set password = '"+newpass+"' where email_id='"+email+"'";
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