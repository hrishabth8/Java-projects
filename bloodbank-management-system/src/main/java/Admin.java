import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.apache.poi.EncryptedDocumentException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GraphicsEnvironment;
import java.awt.FontFormatException;


public class Admin extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_hosp_del;

	public static void main(String[] args) {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	// for hovering funtion
	/*
	public class Hover extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton btnNewButton = (JButton) e.getComponent();
			btnNewButton.setBackground(new Color(0, 0, 0));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			JButton btnNewButton = (JButton) e.getComponent();
			btnNewButton.setBackground(new Color(0, 0, 0));
		}
	}
*/
	public Admin() {

		// exception to create a new font
		/*try{
			// load a custom font in your project folder
			Beautiful = Font.createFont(Font.TRUETYPE_FONT, new File("Beautiful.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Beautiful.ttf")));
		}
		catch(IOException | FontFormatException e){

		}
*/
		// the background panel for it
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 128, 215));
		contentPane.setBorder(new EmptyBorder(100, 100, 100, 100));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// for the picture
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("./admin1.png"));
		lblNewLabel_1.setBounds(100, 120, 250, 250);
		contentPane.add(lblNewLabel_1);

		// for the heading

		JLabel lblNewLabel = new JLabel("Welcome", SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Serif",Font.BOLD | Font.PLAIN, 60));
		lblNewLabel.setBounds(280, 0, 240, 80);
		lblNewLabel.setHorizontalAlignment(lblNewLabel.CENTER);
		contentPane.add(lblNewLabel);


		/* ==========================================================================================================================================================*/
/* ==========================================================================================================================================================*/

		// blood search button
		JButton btnNewButton_3 = new JButton("Search Profile");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setBackground(new Color(25, 102, 224));
				btnNewButton_3.setForeground(new Color(255, 255, 255));
				btnNewButton_3.setBorderPainted(true);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(new Color(75, 128, 215));
				btnNewButton_3.setForeground(new Color(255, 255, 255));
			}

		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewprofile.main(null);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(75, 128, 215));
		btnNewButton_3.setBounds(444, 160, 230, 52);
		btnNewButton_3.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.add(btnNewButton_3);

/* ==========================================================================================================================================================*/
/*  ========================================================================================================================================================*/

		// blood stock button
		JButton btnNewButton_4 = new JButton("Edit Blood Stock");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(25, 102, 224));
				btnNewButton_4.setForeground(new Color(255, 255, 255));
				btnNewButton_4.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(75, 128, 215));
				btnNewButton_4.setForeground(new Color(255, 255, 255));
				btnNewButton_4.setBorder(new EmptyBorder(1, 1, 1, 1));
			}

		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					edit_bloodstock.main(null);
				}
//				catch (EncryptedDocumentException e1) {
//
//					e1.printStackTrace();
//				}
				catch (Exception e1) {
					
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(75, 128, 215));
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_4.setBounds(444, 96, 230, 52);
		btnNewButton_4.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.add(btnNewButton_4);

/* ==========================================================================================================================================================*/
/*  ========================================================================================================================================================*/

		// search donation
		JButton btnNewButton_1 = new JButton("Search Donation");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(25, 102, 224));
				btnNewButton_1.setForeground(new Color(255, 255, 255));
				btnNewButton_1.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(75, 128, 215));
				btnNewButton_1.setForeground(new Color(255, 255, 255));
			}

		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_donations.main(null);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(75, 128, 215));
		btnNewButton_1.setBounds(444, 225, 230, 52);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.add(btnNewButton_1);

/* ==========================================================================================================================================================*/
/*  ========================================================================================================================================================*/

		// search REQUESTS
		JButton btnNewButton_2 = new JButton("Search Request");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(25, 102, 224));
				btnNewButton_2.setForeground(new Color(255, 255, 255));
				btnNewButton_2.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(75, 128, 215));
				btnNewButton_2.setForeground(new Color(255, 255, 255));
			}

		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_requests.main(null);
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(75, 128, 215));
		btnNewButton_2.setBounds(444, 295, 230, 52);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_2.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.add(btnNewButton_2);

/* ==========================================================================================================================================================*/
/*  ========================================================================================================================================================*/
/*
		// enter time received
		JButton btnNewButton_5 = new JButton("Enter Received Time");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_5.setBackground(new Color(25, 102, 224));
				btnNewButton_5.setForeground(new Color(255, 255, 255));
				btnNewButton_5.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_5.setBackground(new Color(75, 128, 215));
				btnNewButton_5.setForeground(new Color(255, 255, 255));
			}

		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pickup_time.main(null);
				dispose();
			}
		});
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(75, 128, 215));
		btnNewButton_5.setBounds(444, 365, 230, 52);
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_5.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.add(btnNewButton_5);
*/


		JButton btnNewButton_hosp = new JButton("Hospital Register");
		btnNewButton_hosp.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_hosp.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_hosp.setBorder(new EmptyBorder(1, 1, 1, 1));
		btnNewButton_hosp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_hosp.setBounds(444, 365, 230, 52);




		btnNewButton_hosp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_hosp.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_hosp.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_hosp.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_hosp.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
			}
		});

		btnNewButton_hosp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blood_bank.main(null);
				dispose();
			}
		});

		contentPane.add(btnNewButton_hosp);

/* ==========================================================================================================================================================*/
/*  ========================================================================================================================================================*/
// hospital deletion button and function

		btnNewButton_hosp_del = new JButton("Hospital Deletion");
		btnNewButton_hosp_del.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_hosp_del.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_hosp_del.setBorder(new EmptyBorder(1, 1, 1, 1));
		btnNewButton_hosp_del.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_hosp_del.setBounds(230, 420, 230, 52);


		btnNewButton_hosp_del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_hosp_del.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_hosp_del.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_hosp_del.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_hosp_del.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
			}
		});

		btnNewButton_hosp_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_hosp.main(null);
				dispose();
			}
		});

		contentPane.add(btnNewButton_hosp_del);

/* ==========================================================================================================================================================*/
/*  ========================================================================================================================================================*/

		// logout button
		JButton btnNewButton = new JButton("<< LogOut");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(25, 102, 224));
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(75, 128, 215));
				btnNewButton.setForeground(new Color(255, 255, 255));
			}

		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login1.main(null);
				dispose();
			}
		});

		btnNewButton.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		btnNewButton.setBounds(633, 442, 122, 35);
		btnNewButton.setBackground(new Color(75, 128, 215));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.add(btnNewButton);

	}
}