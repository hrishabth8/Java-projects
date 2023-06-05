import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.Statement;

public class edit_bloodstock extends JFrame {

	private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JButton btnNewButton;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JLabel label;
	private JTextField TextField_hid;
    private JLabel label_1;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_bloodstock frame = new edit_bloodstock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public edit_bloodstock() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new java.awt.Color(186, 218, 250));
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));

		btnNewButton_8 = new JButton("<<BACK");
		btnNewButton_8.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_8.setForeground(new java.awt.Color(0, 0, 0));
		btnNewButton_8.setBackground(new java.awt.Color(186, 218, 250));
		btnNewButton_8.setBorder(new EmptyBorder(1, 1, 1, 1));

		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_8.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_8.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_8.setBorderPainted(true);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_8.setBackground(new java.awt.Color(186, 218, 250));
				btnNewButton_8.setForeground(new java.awt.Color(0, 0, 0));
			}

		});

		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Admin.main(null);
				} catch (EncryptedDocumentException e1) {

					e1.printStackTrace();
				} catch (NullPointerException e1) {

					e1.printStackTrace();
				}
				dispose();
			}
		});
		contentPane.add(btnNewButton_8);

/* =================================================================================================================================================================================*/
	// used to add spaces between the back buttons and the edit all button
	/// This code **
	//		JLabel label = new JLabel("");
	//		contentPane.add(label);
	//		JLabel label_1 = new JLabel("");
	//		contentPane.add(label_1);
	///  	**
	// commenting off the above space so that the edit button in the same line as the back button

		TextField_hid = new JTextField();
		TextField_hid.setBackground(new java.awt.Color(186, 218, 250));
		TextField_hid.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		TextField_hid.setHorizontalAlignment(JTextField.CENTER);
		TextField_hid.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(TextField_hid);
		TextField_hid.setColumns(10);


/* =================================================================================================================================================================================*/
/* edit all buttons,fields, and labels*/

// button created "edit all"
		JButton btnNewButtoned = new JButton("Edit All");
		btnNewButtoned.setBounds(40, 50, 100, 33);
		btnNewButtoned.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButtoned.setBackground(new java.awt.Color(0, 0, 0));
		btnNewButtoned.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButtoned.setBorder(new EmptyBorder(1,1,1,1));

// mouse listner functions for the button
		btnNewButtoned.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButtoned.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButtoned.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButtoned.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButtoned.setBackground(new java.awt.Color(0, 0, 0));
				btnNewButtoned.setForeground(new java.awt.Color(255, 255, 255));
			}
		});

// mouse action -- when clicked on the button, what it should do
		btnNewButtoned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q2 = textField_1.getText();//b+
				String q3 = textField_2.getText();//o+
				String q4 = textField_3.getText();//ab+
				String q5 = textField_4.getText();//a-
				String q6 = textField_5.getText();//b-
				String q7 = textField_6.getText();//0-
				String q8 = textField_7.getText();//ab-
				String q1 = textField.getText(); //a+
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set apve=" + q1 + ",bpve=" + q2 + ",anve=" + q5 + ",bnve=" + q6 + ",opve=" + q3 + ",onve=" + q7 + ",abpve=" + q4 + ",abnve=" + q8 + " where hospital_id='" + TextField_hid.getText() + "'";

				// first checks for hospital id
				if(TextField_hid.getText().equals("")){
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR",JOptionPane.ERROR_MESSAGE);
				}

				// checks for blank fields
				else if(q4.equals("")||q1.equals("")||q2.equals("")||q3.equals("")||q5.equals("")||q6.equals("")||q7.equals("")||q8.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
				}

				// execution of the statement query
				else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					}catch(Exception l) {
						System.out.println(l);
					}
				}
			}
		});
		contentPane.add(btnNewButtoned);


/* =================================================================================================================================================================================*/
/* A+ buttons,fields, and labels*/

		JLabel lblNewLabel = new JLabel("           A+");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(new java.awt.Color(186, 218, 250));
		textField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("Edit ");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q1 = textField.getText(); //a+
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set apve=" + q1 + " where hospital_id='" + TextField_hid.getText() + "'";
				if(TextField_hid.getText().equals("")){
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else if(q1.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					}catch(Exception l) {
						System.out.println(l);
					}
				}
				}});

		contentPane.add(btnNewButton_1);


/* =================================================================================================================================================================================*/
/* B+ buttons,fields, and labels*/

		JLabel lblNewLabel_2 = new JLabel("           B+");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBackground(new java.awt.Color(186, 218, 250));
		textField_1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnNewButton = new JButton("Edit ");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setBorder(new EmptyBorder(1,1,1,1));


		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q2 = textField_1.getText();//b+
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set bpve=" + q2 + " where hospital_id='" + TextField_hid.getText() + "'";
				if(TextField_hid.getText().equals("")){
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else if(q2.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					}catch(Exception l) {
						System.out.println(l);
					}
				}}});
		contentPane.add(btnNewButton);


/* =================================================================================================================================================================================*/
/* O+ buttons,fields, and labels*/

		JLabel lblNewLabel_1 = new JLabel("           O+");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setBackground(new java.awt.Color(186, 218, 250));
		textField_2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		textField_2.setHorizontalAlignment(JTextField.CENTER);
		textField_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		btnNewButton_2 = new JButton("Edit ");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_2.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_2.setBorder(new EmptyBorder(1,1,1,1));


		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q3 = textField_2.getText();//o+
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set opve=" + q3 + " where hospital_id='" + TextField_hid.getText() + "'";
				if (TextField_hid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else if (q3.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					} catch (Exception l) {
						System.out.println(l);
					}
				}
			}
			});
		contentPane.add(btnNewButton_2);


/* =================================================================================================================================================================================*/
/* AB+ buttons,fields, and labels*/


		JLabel lblNewLabel_3 = new JLabel("           AB+");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBackground(new java.awt.Color(186, 218, 250));
		textField_3.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		textField_3.setHorizontalAlignment(JTextField.CENTER);
		textField_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnNewButton_3 = new JButton("Edit ");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_3.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_3.setBorder(new EmptyBorder(1,1,1,1));


		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_3.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q4 = textField_3.getText();
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set abpve=" + q4 + " where hospital_id='" + TextField_hid.getText() + "'";
				if (TextField_hid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else if (q4.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					} catch (Exception l) {
						System.out.println(l);
					}
				}
			}
		});

		contentPane.add(btnNewButton_3);


/* =================================================================================================================================================================================*/
/* A- buttons,fields, and labels*/


		JLabel lblNewLabel_4 = new JLabel("           A-");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_4.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setBackground(new java.awt.Color(186, 218, 250));
		textField_4.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		textField_4.setHorizontalAlignment(JTextField.CENTER);
		textField_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		btnNewButton_4 = new JButton("Edit ");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_4.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_4.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_4.setBorder(new EmptyBorder(1,1,1,1));


		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_4.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_4.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_4.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q5 = textField_4.getText();
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set anve=" + q5 + " where hospital_id='" + TextField_hid.getText() + "'";
				if (TextField_hid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else if (q5.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					} catch (Exception l) {
						System.out.println(l);
					}
				}
			}
		});
		contentPane.add(btnNewButton_4);


/* =================================================================================================================================================================================*/
/* B- buttons,fields, and labels*/


		JLabel lblNewLabel_6 = new JLabel("           B-");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_6.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(lblNewLabel_6);

		textField_5 = new JTextField();
		textField_5.setBackground(new java.awt.Color(186, 218, 250));
		textField_5.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		textField_5.setHorizontalAlignment(JTextField.CENTER);
		textField_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		btnNewButton_5 = new JButton("Edit ");
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_5.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_5.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_5.setBorder(new EmptyBorder(1,1,1,1));


		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_5.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_5.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_5.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_5.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_5.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q6 = textField_5.getText();
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set bnve=" + q6 + " where hospital_id='" + TextField_hid.getText() + "'";
				if (TextField_hid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else if (q6.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					} catch (Exception l) {
						System.out.println(l);
					}
				}
			}
		});
		contentPane.add(btnNewButton_5);


/* =================================================================================================================================================================================*/
/* O- buttons,fields, and labels*/


		JLabel lblNewLabel_5 = new JLabel("           O-");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_5.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(lblNewLabel_5);

		textField_6 = new JTextField();
		textField_6.setBackground(new java.awt.Color(186, 218, 250));
		textField_6.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		textField_6.setHorizontalAlignment(JTextField.CENTER);
		textField_6.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		btnNewButton_6 = new JButton("Edit ");
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_6.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_6.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_6.setBorder(new EmptyBorder(1,1,1,1));


		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_6.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_6.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_6.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_6.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_6.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q7 = textField_6.getText();
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set onve=" + q7 + " where hospital_id='" + TextField_hid.getText() + "'";
				if (TextField_hid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else if (q7.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					} catch (Exception l) {
						System.out.println(l);
					}
				}
			}
		});
		contentPane.add(btnNewButton_6);


/* =================================================================================================================================================================================*/
/* AB- buttons,fields, and labels*/


		JLabel lblNewLabel_7 = new JLabel("           AB-");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_7.setForeground(new java.awt.Color(0, 0, 0));
		contentPane.add(lblNewLabel_7);

		textField_7 = new JTextField();
		textField_7.setBackground(new java.awt.Color(186, 218, 250));
		textField_7.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),1));
		textField_7.setHorizontalAlignment(JTextField.CENTER);
		textField_7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		btnNewButton_7 = new JButton("Edit ");
		btnNewButton_7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_7.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_7.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_7.setBorder(new EmptyBorder(1,1,1,1));


		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_7.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_7.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_7.setBorder(BorderFactory.createLineBorder(new java.awt.Color(75, 128, 215),5));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_7.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_7.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q8 = textField_7.getText();
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st;
				String query = "Update stock set abnve=" + q8 + " where hospital_id='" + TextField_hid.getText() + "'";
				if (TextField_hid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "            Enter hospital id     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else if (q8.equals("")) {
					JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						st = con.createStatement();
						System.out.println(st.executeUpdate(query));
					} catch (Exception l) {
						System.out.println(l);
					}
				}
			}
		});
		contentPane.add(btnNewButton_7);
	}
}