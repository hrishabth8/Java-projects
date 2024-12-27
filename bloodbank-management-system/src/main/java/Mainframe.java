import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.apache.poi.EncryptedDocumentException;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Canvas;

public class Mainframe extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Mainframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// is a method in the swing lib that tells what to do when the X on frame is clicked
		setBounds(100, 100, 639, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBackground(new Color(75, 128, 215, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("./bb.jpg"));
		lblNewLabel.setBounds(0, 0, 627, 436);
		contentPane.add(lblNewLabel);


		JButton btnNewButton = new JButton("Donate Blood");
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBorder(new LineBorder(new Color(25, 102, 224), 2));
		btnNewButton.setBounds(35, 245, 245, 75);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

			}

		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Donate_Blood.main(null);
				} catch (EncryptedDocumentException e1) {
					
					e1.printStackTrace();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				dispose();
			}
		});
		contentPane.add(btnNewButton);





		JButton btnNewButton_hosp = new JButton("Blood Bank");
		btnNewButton_hosp.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_hosp.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_hosp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_hosp.setBorder(new LineBorder(new Color(25, 102, 224), 2));
		btnNewButton_hosp.setBounds(180, 160, 245, 75);
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
				btnNewButton_hosp.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_hosp.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
			}
		});
		btnNewButton_hosp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BloodBankTable.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton_hosp);


		JButton btnNewButton_1 = new JButton("Request Blood");
		btnNewButton_1.setBounds(315, 245, 245, 75);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_1.setBorder(new LineBorder(new Color(25, 102, 224), 2,true));
		contentPane.add(btnNewButton_1);

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
				Requestblood_access.main(null);
				dispose();
			}
		});


		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_3.setBorder(new LineBorder(new Color(25, 102, 224), 2));
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_3.setBounds(495, 390, 118, 40);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton_3.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton_3.setBorder(new EmptyBorder(1,1,1,1));

			}

		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login1.main(null);
				dispose();
				
			}
		});
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_3);


		JButton btnNewButton_2 = new JButton("Change Password");
		btnNewButton_2.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_2.setBorder(new LineBorder(new Color(25, 102, 224), 2));
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(6, 395, 200, 36);


				btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton_3.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton_3.setBorder(new EmptyBorder(1,1,1,1));

			}

		});

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Change_password.main(null);
				} catch (EncryptedDocumentException e) {
					
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_2);
	}
}