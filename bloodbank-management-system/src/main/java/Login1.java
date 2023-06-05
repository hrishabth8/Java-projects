import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login1 extends JFrame {
	private CellStyle cellstyle;
	private Color mycolor;
	private String excelFilePath;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	public static void main(String[] args) {
				try {
					Login1 frame = new Login1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
/* =================================================================================================================================================================================*/
	public Login1() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is a method in the swing lib that tells what to do when the X on frame is clicked
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel(); //contentPane is obeject of the Jpanel class
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(75, 128, 215, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblNewLabel_2 = new JLabel("Login"); // lblNewLabel_2 is object of the class Jlabel
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_2.setForeground(new Color(255, 255, 255, 255));
		lblNewLabel_2.setBounds(191, 0, 120, 49);
		contentPane.add(lblNewLabel_2);


		JLabel lblNewLabel = new JLabel("Email ID");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(36, 74, 130, 22);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(36, 128, 130, 22);
		contentPane.add(lblNewLabel_1);

// for getting email_id
		textField = new JTextField(); // textfielde is used to get user inputs
		textField.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		textField.setForeground(Color.black);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField.setBounds(159, 78, 176, 20);
		contentPane.add(textField); // add is used to add it to the main frame (contenpane)
		textField.setColumns(10);
		String t1 = textField.getText();

// for getting password
		passwordField = new JPasswordField();
		passwordField.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		passwordField.setForeground(Color.black);
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		passwordField.setBounds(159, 130, 176, 20);
		contentPane.add(passwordField);
		String t2 = passwordField.getText();


// new user button creation
		JButton btnNewButton = new JButton("New User"); // btnNewButton object of the class jbutton
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(Color.white));


// code to overides the properties of the button
		/**
		 here btnNewButton is object of class jbutton
		 here .addMouseListener is a method used to register button object in swing, when it is called
		 it passes an object of the class that implements the interface mouselistner

		 object of the class that implements the interface mouselistner --- is done using "new MouseAdapter()"

		 MouseAdapter is an abstract class provides empty method implementations for all of the interface's methods.
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override // is for anotation purpose but it also causes the compiler to check the method is actually overiding
			public void mouseEntered(MouseEvent e) //mouseEntered(MouseEvent e) is an interface method
			{
				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		/**
		 The addActionListener method takes an instance of an object that implements the ActionListener interface.
		 */

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { /**The actionPerformed method is called when the button is clicked. It calls*/
				try {
					newuser.main(null);
				}
//				catch (EncryptedDocumentException e1) {
//					e1.printStackTrace();
//				}
				catch (NullPointerException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setBounds(63, 191, 89, 23);
		contentPane.add(btnNewButton);


		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_1.setBorder(new LineBorder(Color.white));

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
			}

		});


		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = textField.getText();
				String t2 = passwordField.getText();

				if (t1.equals("ADMIN") && t2.equals("ADMIN")) {
					Admin.main(null);
					dispose();

				}

				else{
					boolean x = checkPassword(t1,t2); // passes the textfield values as arguements to the checkpassword method
					System.out.println(x);
					if(x){ 					// if true creates an object of the maniframe class and set the layout to be visible
						Mainframe m = new Mainframe();
						m.setVisible(true);
					}
					else {
						//else the joption prints an error in a pop up window and resets the textfields to blank
						JOptionPane.showMessageDialog(null, "            INVALID LOGIN    ", "ERROR", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
					}
				}

			}
		});
		btnNewButton_1.setBounds(246, 191, 89, 23);
		contentPane.add(btnNewButton_1);

	}

	public boolean checkPassword(String a, String b){
		boolean ans=false;
		try {
			Connection c=null;
			Statement st = null; // used to execute sql queries
			ResultSet rs = null; //used to access the data returned by sql command
			String url = "jdbc:postgresql://localhost:5432/bloodbank";
			String username1 = "postgres";
			String password1 = "987987";
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, username1, password1);
			c.setAutoCommit(false);
			st = c.createStatement();
//			  String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
			String sql = "SELECT password FROM login WHERE email_id='"+a+"';";   // sql stores the command
			rs=st.executeQuery(sql);  //and rs is used to access the data using the statement
			while (rs.next()){				//to iterate through the rows of the sql tables
				System.out.println(rs.getString(1)+" "+b);
				if(rs.getString(1).toString().equals(b)){  // checks if the result from the database is the same the one from the textfield
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