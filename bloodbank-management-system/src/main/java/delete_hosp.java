
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.sql.*;

public class delete_hosp extends JFrame {

    private Color mycolor;
    private JPanel contentPane1;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel;
    private JButton btnNewButton_back;


    public static void main(String[] args) {
                try {
                    delete_hosp frame = new delete_hosp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }


    public delete_hosp() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        contentPane1 = new JPanel();
        contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane1.setBackground(new Color(75, 128, 215, 255));
        setContentPane(contentPane1);
        contentPane1.setLayout(null);

        lblNewLabel = new JLabel("Hospital Deletion");
        lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC| Font.BOLD, 23));
        lblNewLabel.setBounds(120, 20, 200, 30);
        contentPane1.add(lblNewLabel);


        lblNewLabel_1 = new JLabel("Hospital id");
        lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
        lblNewLabel_1.setBounds(40, 80, 118, 30);
        contentPane1.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(190, 80, 170, 30);
        textField.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
        textField.setForeground(new java.awt.Color(0, 0, 0));
        textField.setBorder(new EmptyBorder(1, 1, 1, 1));
        contentPane1.add(textField);
        textField.setColumns(10);

        btnNewButton_back = new JButton("<< Back");
        btnNewButton_back.setBackground(new java.awt.Color(75, 128, 215, 255));
        btnNewButton_back.setForeground(new java.awt.Color(255,255,255));
        btnNewButton_back.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        btnNewButton_back.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
        btnNewButton_back.setBounds(10, 11, 89, 23);

        btnNewButton_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton_back.setBackground(new java.awt.Color(25, 102, 224));
                btnNewButton_back.setForeground(new java.awt.Color(255, 255, 255));
                btnNewButton_back.setBorderPainted(true);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton_back.setBackground(new java.awt.Color(75, 128, 215));
                btnNewButton_back.setForeground(new java.awt.Color(255, 255, 255));
            }

        });

        btnNewButton_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.main(null);
                dispose();
            }
        });
        contentPane1.add(btnNewButton_back);


        JButton btnNewButton = new JButton("Delete");
        btnNewButton.setBounds(130, 130, 100, 30);
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD , 20));
        btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
        btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
        btnNewButton.setBorder(new EmptyBorder(1, 1, 1, 1));

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
        contentPane1.add(btnNewButton);

//        btnNewButton_1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                String r1 = textField.getText();
//                try {
//                    Class.forName("org.postgresql.Driver");
//                }
//                catch(ClassNotFoundException e1)
//                {
//                    System.out.println("Error in loading driver");
//                }
//                String url="jdbc:postgresql://localhost:5432/bloodbank";
//                String name="postgres";
//                String pass="987987";
//                Connection con;
//                try {
//
//
//                    con = DriverManager.getConnection(url,name,pass);
//                    PreparedStatement st = (PreparedStatement) con
//                            .prepareStatement("Select name,dob,pincode from logindetails where email_id =?");
//                    st.setString(1, r1);
//                    ResultSet rs = st.executeQuery();
//
//                    if(rs.next())
//                    {
//                        //display the details
//                        String a1 = rs.getString(1);
//                        String a2 = rs.getString(2);
//                        String a3 = rs.getString(3);
////						String a4 = rs.getString(4);
//
//                        JLabel lblNewLabel_2 = new JLabel(a1);
//                        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//                        lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255));
//                        lblNewLabel_2.setBounds(188, 99, 155, 27);
//                        contentPane1.add(lblNewLabel_2);
//
//                        JLabel lblNewLabel_4 = new JLabel(a2);
//                        lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//                        lblNewLabel_4.setForeground(new java.awt.Color(255, 255, 255));
//                        lblNewLabel_4.setBounds(188, 153, 166, 27);
//                        contentPane1.add(lblNewLabel_4);
//
//                        JLabel lblNewLabel_6 = new JLabel(a3);
//                        lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//                        lblNewLabel_6.setForeground(new java.awt.Color(255, 255, 255));
//                        lblNewLabel_6.setBounds(188, 209, 166, 21);
//                        contentPane1.add(lblNewLabel_6);
//                        setState(Viewprofile.ICONIFIED);
//                        setState(Viewprofile.NORMAL);
//
//                    }
//
//
//                    else if(r1.equals("")) {
//                        JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
//                    }
//                    else {
//                        JOptionPane.showMessageDialog(null, "		   Invalid User ID      ","ERROR",JOptionPane.ERROR_MESSAGE);
//                    }
//
//                }
//                catch (SQLException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                }
//            }
//        });
//
//        contentPane1.add(btnNewButton_1);
//
//        JLabel lblNewLabel_11 = new JLabel(" ");
//        lblNewLabel_11.setBounds(188, 210, 158, 27);
//        contentPane1.add(lblNewLabel_11);
//
//        JLabel lblNewLabel_12 = new JLabel(" ");
//        lblNewLabel_12.setBounds(188, 263, 156, 27);
//        contentPane1.add(lblNewLabel_12);
//
//        JLabel lblNewLabel_9_1 = new JLabel(" ");
//        lblNewLabel_9_1.setBounds(188, 156, 177, 21);
//        contentPane1.add(lblNewLabel_9_1);
//
//        JLabel lblNewLabel_11_1 = new JLabel(" ");
//        lblNewLabel_11_1.setBounds(188, 98, 158, 27);
//        contentPane1.add(lblNewLabel_11_1);
    }

    public void addToDB(){
        String hid;
        hid=textField.getText();
        int flag=0;

        if(hid.equals("")) {
            JOptionPane.showMessageDialog(null,"           Enter hospital id      ","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
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
                String sql = "delete from blood_bank where hospital_id ='"+hid+"';";

                st.executeUpdate(sql);
                flag=1;
                if(flag==1){
                    JOptionPane.showMessageDialog(null,"         SUCCESSFULLY DELETED      ","Successful",JOptionPane.PLAIN_MESSAGE);
                    flag=0;
                }
                c.commit();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}






































































































//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.Color;
//import javax.swing.JPasswordField;
//import java.awt.Font;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.awt.event.ActionEvent;
//import javax.swing.ImageIcon;
//import java.awt.Label;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class Viewprofile extends JFrame {
//
//	private static FileInputStream fis;
//	private static FileOutputStream fos;
//	private static Workbook wb;
//	private static Sheet sh;
//	private static Cell cell;
//	private static Row row;
//	private CellStyle cellstyle;
//	private Color mycolor;
//	private String excelFilePath;
//	private JPanel contentPane1;
//	private JTextField textField;
//	private JPasswordField passwordField;
//
//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Viewprofile frame = new Viewprofile();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//
//	public Viewprofile() throws EncryptedDocumentException, IOException {
//
//
//		fis = new FileInputStream("./Booook.xlsx");
//		wb = WorkbookFactory.create(fis);
//		sh = wb.getSheet("Sheet2");
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 500, 380);
//		contentPane1 = new JPanel();
//		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane1.setBackground(new Color(75, 128, 215, 255));
//		setContentPane(contentPane1);
//		contentPane1.setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("Email ID");
//		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
//		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
//		lblNewLabel.setBounds(40, 50, 118, 21);
//		contentPane1.add(lblNewLabel);
//
//		textField = new JTextField();
//		textField.setBounds(190, 45, 170, 30);
//		textField.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
//		textField.setForeground(new java.awt.Color(0, 0, 0));
//		textField.setBorder(new EmptyBorder(1, 1, 1, 1));
//		contentPane1.add(textField);
//		textField.setColumns(10);
//
//		JLabel lblNewLabel_1 = new JLabel("Name");
//		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
//		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
//		lblNewLabel_1.setBounds(39, 100, 118, 21);
//		contentPane1.add(lblNewLabel_1);
//
//
//		JLabel lblNewLabel_3 = new JLabel("DOB");
//		lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255));
//		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
//		lblNewLabel_3.setBounds(39, 155, 118, 21);
//		contentPane1.add(lblNewLabel_3);
//
//
//		JLabel lblNewLabel_5 = new JLabel("Pincode");
//		lblNewLabel_5.setForeground(new java.awt.Color(255, 255, 255));
//		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
//		lblNewLabel_5.setBounds(39, 210, 118, 21);
//		contentPane1.add(lblNewLabel_5);
//
//
////		JLabel lblNewLabel_7 = new JLabel("Blood Group");
////		lblNewLabel_7.setForeground(new java.awt.Color(255, 255, 255));
////		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
////		lblNewLabel_7.setBounds(39, 265, 150, 25);
////		contentPane1.add(lblNewLabel_7);
//
//
//		JButton btnNewButton = new JButton("<< Back");
//		btnNewButton.setBounds(10, 10, 100, 30);
//		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
//		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
//		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
//		btnNewButton.setBorder(new EmptyBorder(1, 1, 1, 1));
//
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
//				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
//				btnNewButton.setBorderPainted(true);
//			}
//
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
//		contentPane1.add(btnNewButton);
//
//		JButton btnNewButton_1 = new JButton("Search");
//		btnNewButton_1.setBounds(370, 300, 100, 30);
//		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
//		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
//		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//		btnNewButton_1.setBorder(new EmptyBorder(1, 1, 1, 1));
//
//		btnNewButton_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
//				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//				btnNewButton_1.setBorderPainted(true);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
//				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
//			}
//		});
//
//
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				addToDB();
//			}
//		});
////////				String r1 = textField.getText();
////////				int noOfRows=sh.getLastRowNum();
//////
//////				for(int i=1;i<=noOfRows;i++) {
//////
//////        			Cell q1 = sh.getRow(i).getCell(0);
//////
//////        			String a1 = q1.toString();
//////
//////        			if(a1.equals(r1)){
//////                   	 textField.setText(null);
//////                   	 Cell b1,b2,b3,b4;
//////                		String c1,c2,c3,c4;
//////
//////                		b1 = sh.getRow(i).getCell(0);
//////                		b2 = sh.getRow(i).getCell(1);
//////                		b3 = sh.getRow(i).getCell(2);
//////                		b4 = sh.getRow(i).getCell(3);
//////
//////                		c1 = b1.toString();
////                		c2 = b2.toString();
////                		c3 = b3.toString();
////                		c4 = b4.toString();
////
////                		JLabel lblNewLabel_2 = new JLabel(c1);
////               			lblNewLabel_2.setBounds(195, 100, 155, 27);
////						lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255));
////						lblNewLabel_2.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
////						contentPane1.add(lblNewLabel_2);
////
////               			JLabel lblNewLabel_4 = new JLabel(c2);
////						lblNewLabel_4.setForeground(new java.awt.Color(255, 255, 255));
////						lblNewLabel_4.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
////						lblNewLabel_4.setBounds(195, 155, 166, 27);
////               			contentPane1.add(lblNewLabel_4);
////
////               			JLabel lblNewLabel_6 = new JLabel(c3);
////						lblNewLabel_6.setForeground(new java.awt.Color(255, 255, 255));
////						lblNewLabel_6.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
////						lblNewLabel_6.setBounds(195, 210, 166, 21);
////               			contentPane1.add(lblNewLabel_6);
////
////               			JLabel lblNewLabel_8 = new JLabel(c4);
////						lblNewLabel_8.setForeground(new java.awt.Color(255, 255, 255));
////						lblNewLabel_8.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
////						lblNewLabel_8.setBounds(195, 260, 155, 26);
////               			contentPane1.add(lblNewLabel_8);
////
////                   	 setState(Viewprofile.ICONIFIED);
////   					 setState(Viewprofile.NORMAL);
////
////                   	 break;
////
////   				}
////        			else if(!a1.equals(r1)) {
////        				continue;
////
////        			}
////        			else {
////       				 JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
////
////          				break;
////	                	}
////			}
////
////		}});
//		contentPane1.add(btnNewButton_1);
//
//		JLabel lblNewLabel_11 = new JLabel(" ");
//		lblNewLabel_11.setBounds(188, 210, 158, 27);
//		contentPane1.add(lblNewLabel_11);
//
//		JLabel lblNewLabel_12 = new JLabel(" ");
//		lblNewLabel_12.setBounds(188, 263, 156, 27);
//		contentPane1.add(lblNewLabel_12);
//
//		JLabel lblNewLabel_9_1 = new JLabel(" ");
//		lblNewLabel_9_1.setBounds(188, 156, 177, 21);
//		contentPane1.add(lblNewLabel_9_1);
//
//		JLabel lblNewLabel_11_1 = new JLabel(" ");
//		lblNewLabel_11_1.setBounds(188, 98, 158, 27);
//		contentPane1.add(lblNewLabel_11_1);
//	}
//
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
//			String nam = "Select name from logindetails where email_id='"+email+"';";
//			String dob = "Select dob from LoginDetails where email_id='" + email + "';";
//			String pin = "Select pincode from LoginDetails where email_id='" + email + "';";
////			System.out.println(nam);
////			System.out.println(pin);
////			System.out.println(dob);
//			rs = st.executeQuery(nam);
//			while(rs.next()){
//				System.out.println(rs.getString(1));
//			}
//			rs = st.executeQuery(dob);
//			while(rs.next()){
//				System.out.println(rs.getString(1));
//			}
//			rs = st.executeQuery(pin);
//
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

































