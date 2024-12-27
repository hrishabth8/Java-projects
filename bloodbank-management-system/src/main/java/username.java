import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class username extends JFrame {
	private CellStyle cellstyle;
	private Color mycolor;
	private String excelFilePath;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					username frame = new username();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public username() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground((new java.awt.Color(75, 128, 215)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Email ID:",SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel.setBounds(35, 68, 152, 55);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(197, 78, 258, 30);
		textField.setBorder(new EmptyBorder(1,1,1,1));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password:",SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_1.setBounds(35, 194, 152, 37);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(197, 195, 258, 30);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.add(passwordField);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setForeground((new java.awt.Color(255, 255, 255)));
		btnNewButton_1.setBackground((new java.awt.Color(75, 128, 215)));
		btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_1.setBorder(new LineBorder(java.awt.Color.white,2));

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

				String q1 = textField.getText();
				String q2 = passwordField.getText();
				try {

					Connection c=null;
					Statement st = null;
					ResultSet rs = null;

					String url = "jdbc:postgresql://localhost:5433/bloodbank";
					String username1 = "postgres";
					String password1 = "123";
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection(url, username1, password1);
					c.setAutoCommit(false);
					st = c.createStatement();

					boolean x = checkemail(q1);
					System.out.println(x);
					if(x){
						JOptionPane.showMessageDialog(null, "            Email Exist    ", "ERROR", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
						username m = new username();
						m.setVisible(true);					}
					else {
						ResultSet rsq = null;
//						String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
						String sql = "insert into login values('" + q1 + "','" + q2 + "');";
						st.executeUpdate(sql);
						c.commit();
						Login1 m = new Login1();
						m.setVisible(true);
					}

				} catch (Exception ex){
					System.out.println(ex);
				}
//				int noOfRows = sh.getLastRowNum();
//				boolean k =true;
//				for(int j =1; j<=noOfRows;j++) {
//					Cell c1 = sh.getRow(j).getCell(0);
//					String b1 = c1.toString();
//
//				if (b1.equals(q1)) {
//					textField.setText(null);
//					passwordField.setText(null);
//					JOptionPane.showMessageDialog(null, "            Username already exsits        ", "ERROR",JOptionPane.ERROR_MESSAGE);
//					k = false;
//					break;
//
//
//				}
//
//				}
//			while(k) {
//				for (int i = 1; i <= noOfRows; i++) {
//
//					Cell r1 = sh.getRow(i).getCell(0);
//					String a1 = r1.toString();
//					if (q1.equals("") || q2.equals("")) {
//						textField.setText(null);
//						passwordField.setText(null);
//						JOptionPane.showMessageDialog(null, "           Fill all Details       ", "ERROR",JOptionPane.ERROR_MESSAGE);
//						k=false;
//						break;
//						}
//
//
//					else if (!a1.equals(q1)) {
//
//						int noOfRows1 = sh.getLastRowNum();
//						row = sh.createRow(noOfRows1 + 1);
//						cell = row.createCell(0);
//						cell.setCellValue(q1);
//						cell = row.createCell(1);
//						cell.setCellValue(q2);
//
//						// System.out.println(cell.getStringCellValue());
//						try {
//							fos = new FileOutputStream("./Booook.xlsx");
//						} catch (FileNotFoundException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//						try {
//							wb.write(fos);
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//						try {
//							fos.flush();
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//						try {
//							fos.close();
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//						Login1.main(null);
//						dispose();
//						JOptionPane.showMessageDialog(null, "Your profile has been saved", "",JOptionPane.INFORMATION_MESSAGE);
//						k=false;
//						break;
//					}
//					}
//				}
			}});
		btnNewButton_1.setBounds(163, 261, 170, 37);
		contentPane.add(btnNewButton_1);
	}

	public boolean checkemail(String q1){
		boolean ans=false;
		try {
			Connection c=null;
			Statement st = null;
			ResultSet rs = null;
			String url = "jdbc:postgresql://localhost:5433/bloodbank";
			String username1 = "postgres";
			String password1 = "123";
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, username1, password1);
			c.setAutoCommit(false);
			st = c.createStatement();

//			  String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
			String sql = "SELECT email_id FROM login WHERE email_id='"+q1+"';";
			rs=st.executeQuery(sql);
			while (rs.next()){
				System.out.println(rs.getString(1));
				if(rs.getString(1).toString().equals(q1)){
					ans=true;
				}
			}
			dispose();
			c.commit();
		} catch (Exception ex){
			System.out.println(ex);
		}
		return ans;
	}
}