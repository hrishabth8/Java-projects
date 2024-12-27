import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.*;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Donate_Blood extends JFrame {

	private JPanel contentPane;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	
	private final JList list = new JList();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_loc;
	private JTextField textField_hosp;
	


	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donate_Blood frame = new Donate_Blood();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Donate_Blood() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is a method in the swing lib that tells what to do when the X on frame is clicked
		setBounds(100, 100, 600, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(75, 128, 215, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
				Mainframe.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);


		JLabel lblNewLabel = new JLabel("Slot Booking",SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel.setBounds(196, 30, 250, 35);
		contentPane.add(lblNewLabel);


		//user
		JLabel lblNewLabel_3 = new JLabel("Email ID");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_3.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel_3.setBounds(83, 100, 180, 23);
		contentPane.add(lblNewLabel_3);
		//user
		textField_2 = new JTextField();
		textField_2.setBounds(273, 100, 170, 26);
		textField_2.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		textField_2.setForeground(java.awt.Color.black);
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(textField_2);
		textField_2.setColumns(10);


		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_4.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel_4.setBounds(83, 145, 180, 23);
		contentPane.add(lblNewLabel_4);
//
		textField_3 = new JTextField();
		textField_3.setBounds(273, 145, 170, 26);
		textField_3.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		textField_3.setForeground(java.awt.Color.black);
		textField_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(textField_3);
		textField_3.setColumns(10);



		JLabel lblNewLabel_1 = new JLabel("Enter Date");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel_1.setBounds(83, 190, 180, 23);
		contentPane.add(lblNewLabel_1);
		//date
		textField = new JTextField();
		textField.setBounds(273, 190, 170, 26);
		textField.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		textField.setForeground(java.awt.Color.black);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(textField);
		textField.setColumns(10);


		JLabel lblNewLabel_2 = new JLabel("Enter Time");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_2.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel_2.setBounds(83, 235, 180, 23);
		contentPane.add(lblNewLabel_2);
		//time
		textField_1 = new JTextField();
		textField_1.setBounds(273, 235, 170, 26);
		textField_1.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		textField_1.setForeground(java.awt.Color.black);
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(textField_1);
		textField_1.setColumns(10);


		JLabel lblNewLabel_loc = new JLabel("Pincode");
		lblNewLabel_loc.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_loc.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_loc.setBounds(83, 280, 180, 23);
		contentPane.add(lblNewLabel_loc);

		textField_loc = new JTextField();
		textField_loc.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_loc.setBorder(new EmptyBorder(1,1,1,1));
		textField_loc.setForeground(new java.awt.Color(0, 0, 0));
		textField_loc.setBounds(273, 280, 170, 26);
		contentPane.add(textField_loc);
		textField_loc.setColumns(10);


		JLabel lblNewLabel_hosp = new JLabel("Hospital ID");
		lblNewLabel_hosp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_hosp.setForeground(new java.awt.Color(255,255,255));
		lblNewLabel_hosp.setBounds(83, 325, 180, 23);
		contentPane.add(lblNewLabel_hosp);
		//date
		textField_hosp = new JTextField();
		textField_hosp.setBounds(273, 325, 170, 26);
		textField_hosp.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		textField_hosp.setForeground(java.awt.Color.black);
		textField_hosp.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(textField_hosp);
		textField_hosp.setColumns(10);


		JButton btnNewButton = new JButton("Book Slot");
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215, 255));
		btnNewButton.setForeground(new java.awt.Color(255,255,255));
		btnNewButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 26));
		btnNewButton.setBounds(210, 370, 174, 42);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(new LineBorder(java.awt.Color.white ,1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
			}

		});

//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Mainframe.main(null);
//				dispose();
//			}
//		});


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToDB();
				}
				});
		contentPane.add(btnNewButton);

	}

	public void addToDB(){
		String email,date,time,pin,hid,pass;
		email=textField_2.getText();
		date=textField.getText();
		time=textField_1.getText();
		pin=textField_loc.getText();
		hid=textField_hosp.getText();
		pass=textField_3.getText();

		if(email.equals("")||date.equals("")||time.equals("")||pin.equals("")||hid.equals("")||pass.equals("")) {
			JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		else{
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
				String sql = "insert into blood_donation_slots values('" + email + "','" + date + "','" + time + "','" + pin + "','" + hid + "','" + pass + "');";

				System.out.println(sql);
				st.executeUpdate(sql);
				slotbook.main(null);
				dispose();
				c.commit();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}

}