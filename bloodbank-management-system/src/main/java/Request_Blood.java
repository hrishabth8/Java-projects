import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Request_Blood extends JFrame {

	private JPanel contentPane;
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Request_Blood frame = new Request_Blood();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public Request_Blood() throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet3");
		final String q1,q2,q3,q4,q5,q6,q7,q8;
		Cell r1,r2,r3,r4,r5,r6,r7,r8;
		final float num1,num2,num3,num4,num5,num6,num7,num8;
	
		r1 = sh.getRow(1).getCell(0);
		r2 = sh.getRow(1).getCell(1);
		r3 = sh.getRow(1).getCell(2);
		r4 = sh.getRow(1).getCell(3);
		r5 = sh.getRow(1).getCell(4);
		r6 = sh.getRow(1).getCell(5);
		r7 = sh.getRow(1).getCell(6);
		r8 = sh.getRow(1).getCell(7);
		q1 = r1.toString();
		q2 = r2.toString();
		q3 = r3.toString();
		q4 = r4.toString();
		q5 = r5.toString();
		q6 = r6.toString();
		q7 = r7.toString();
		q8 = r8.toString();
	
		num1  =Float.parseFloat(q1);
		
		num2 =Float.parseFloat(q2); 
		num3 =Float.parseFloat(q3);
		num4 =Float.parseFloat(q4); 
		num5 =Float.parseFloat(q5);
		num6 =Float.parseFloat(q6); 
		num7 =Float.parseFloat(q7);
		num8 =Float.parseFloat(q8); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(75, 128, 215));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{119, 136, 117, 0};
		gbl_contentPane.rowHeights = new int[]{76, 30, 29, 29, 29, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("SINGLE STOCK");
		lblNewLabel.setBounds(40,10,180,30);
		lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 30));


		JButton btnNewButton_b = new JButton("<<<");
		btnNewButton_b.setBounds(15, 0, 120, 30);
		btnNewButton_b.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_b.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_b.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_b.setBorder(new EmptyBorder(1,1,1,1));

		btnNewButton_b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_b.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_b.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton_b.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_b.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_b.setForeground(new java.awt.Color(255, 255, 255));
			}

		});

		btnNewButton_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Requestblood_access.main(null);
				dispose();

			}
		});
		contentPane.add(btnNewButton_b);

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("  A+ ");
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

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
				
				if(q1.equals("0")) {
					JOptionPane.showMessageDialog(null,"         BLOOD STOCK UNAVALIABLE      ","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"           RECIVIE AT HOSIPITAL WITH IN A DAY      ","", JOptionPane.INFORMATION_MESSAGE);
	    			row = sh.createRow(1);
	    			cell = row.createCell(0);
	    			cell.setCellValue(num1-1);
	    			cell = row.createCell(1);
	    			cell.setCellValue(q2);
	    			cell = row.createCell(2);
	    			cell.setCellValue(q3);
	    			cell = row.createCell(3);
	    			cell.setCellValue(q4);
	    			cell = row.createCell(4);
	    			cell.setCellValue(q5);
	    			cell = row.createCell(5);
	    			cell.setCellValue(q6);
	    			cell = row.createCell(6);
	    			cell.setCellValue(q7);
	    			cell = row.createCell(7);
	    			cell.setCellValue(q8);
	    			try {
	    				fos = new FileOutputStream("./Booook.xlsx");
	    			} catch (FileNotFoundException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				wb.write(fos);
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.flush();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.close();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			Mainframe.main(null);
	    			dispose();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);



		JButton btnNewButton_4 = new JButton("  A-  ");
		btnNewButton_4.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_4.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_4.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_4.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_4.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

			}

		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q5.equals("0")) {
					JOptionPane.showMessageDialog(null,"         BLOOD STOCK UNAVALIABLE      ","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"          RECIVIE AT HOSIPITAL WITH IN A DAY    ","", JOptionPane.INFORMATION_MESSAGE);
	    			row = sh.createRow(1);
	    			cell = row.createCell(0);
	    			cell.setCellValue(q1);
	    			cell = row.createCell(1);
	    			cell.setCellValue(q2);
	    			cell = row.createCell(2);
	    			cell.setCellValue(q3);
	    			cell = row.createCell(3);
	    			cell.setCellValue(q4);
	    			cell = row.createCell(4);
	    			cell.setCellValue(num5-1);
	    			cell = row.createCell(5);
	    			cell.setCellValue(q6);
	    			cell = row.createCell(6);
	    			cell.setCellValue(q7);
	    			cell = row.createCell(7);
	    			cell.setCellValue(q8);
	    			try {
	    				fos = new FileOutputStream("./Booook.xlsx");
	    			} catch (FileNotFoundException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				wb.write(fos);
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.flush();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.close();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			Mainframe.main(null);
	    			dispose();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 1;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);



		JButton btnNewButton_1 = new JButton("  B+ ");
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

			}

		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q2.equals("0")) {
					JOptionPane.showMessageDialog(null,"         BLOOD STOCK UNAVALIABLE      ","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"          RECIVIE AT HOSIPITAL WITH IN A DAY    ","", JOptionPane.INFORMATION_MESSAGE);
	    			row = sh.createRow(1);
	    			cell = row.createCell(0);
	    			cell.setCellValue(q1);
	    			cell = row.createCell(1);
	    			cell.setCellValue(num2-1);
	    			cell = row.createCell(2);
	    			cell.setCellValue(q3);
	    			cell = row.createCell(3);
	    			cell.setCellValue(q4);
	    			cell = row.createCell(4);
	    			cell.setCellValue(q5);
	    			cell = row.createCell(5);
	    			cell.setCellValue(q6);
	    			cell = row.createCell(6);
	    			cell.setCellValue(q7);
	    			cell = row.createCell(7);
	    			cell.setCellValue(q8);
	    			try {
	    				fos = new FileOutputStream("./Booook.xlsx");
	    			} catch (FileNotFoundException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				wb.write(fos);
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.flush();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.close();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			Mainframe.main(null);
	    			dispose();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("  B-  ");
		btnNewButton_5.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_5.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_5.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_5.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_5.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_5.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_5.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

			}

		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q6.equals("0")) {
					JOptionPane.showMessageDialog(null,"         BLOOD STOCK UNAVALIABLE      ","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"          RECIVIE AT HOSIPITAL WITH IN A DAY    ","", JOptionPane.INFORMATION_MESSAGE);
	    			row = sh.createRow(1);
	    			cell = row.createCell(0);
	    			cell.setCellValue(q1);
	    			cell = row.createCell(1);
	    			cell.setCellValue(q2);
	    			cell = row.createCell(2);
	    			cell.setCellValue(q3);
	    			cell = row.createCell(3);
	    			cell.setCellValue(q4);
	    			cell = row.createCell(4);
	    			cell.setCellValue(q5);
	    			cell = row.createCell(5);
	    			cell.setCellValue(num6-1);
	    			cell = row.createCell(6);
	    			cell.setCellValue(q7);
	    			cell = row.createCell(7);
	    			cell.setCellValue(q8);
	    			try {
	    				fos = new FileOutputStream("./Booook.xlsx");
	    			} catch (FileNotFoundException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				wb.write(fos);
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.flush();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.close();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			Mainframe.main(null);
	    			dispose();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 2;
		contentPane.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton(" O+ ");
		btnNewButton_2.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_2.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

			}

		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q3.equals("0")) {
					JOptionPane.showMessageDialog(null,"         BLOOD STOCK UNAVALIABLE      ","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"          RECIVIE AT HOSIPITAL WITH IN A DAY    ","", JOptionPane.INFORMATION_MESSAGE);
	    			row = sh.createRow(1);
	    			cell = row.createCell(0);
	    			cell.setCellValue(q1);
	    			cell = row.createCell(1);
	    			cell.setCellValue(q2);
	    			cell = row.createCell(2);
	    			cell.setCellValue(num3-1);
	    			cell = row.createCell(3);
	    			cell.setCellValue(q4);
	    			cell = row.createCell(4);
	    			cell.setCellValue(q5);
	    			cell = row.createCell(5);
	    			cell.setCellValue(q6);
	    			cell = row.createCell(6);
	    			cell.setCellValue(q7);
	    			cell = row.createCell(7);
	    			cell.setCellValue(q8);
	    			try {
	    				fos = new FileOutputStream("./Booook.xlsx");
	    			} catch (FileNotFoundException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				wb.write(fos);
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.flush();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.close();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			Mainframe.main(null);
	    			dispose();
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton(" O- ");
		btnNewButton_6.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_6.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_6.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_6.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_6.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_6.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_6.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
			}

		});

		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q7.equals("0")) {
					JOptionPane.showMessageDialog(null,"         BLOOD STOCK UNAVALIABLE      ","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"          RECIVIE AT HOSIPITAL WITH IN A DAY    ","", JOptionPane.INFORMATION_MESSAGE);
	    			row = sh.createRow(1);
	    			cell = row.createCell(0);
	    			cell.setCellValue(q1);
	    			cell = row.createCell(1);
	    			cell.setCellValue(q2);
	    			cell = row.createCell(2);
	    			cell.setCellValue(q3);
	    			cell = row.createCell(3);
	    			cell.setCellValue(q4);
	    			cell = row.createCell(4);
	    			cell.setCellValue(q5);
	    			cell = row.createCell(5);
	    			cell.setCellValue(q6);
	    			cell = row.createCell(6);
	    			cell.setCellValue(num7-1);
	    			cell = row.createCell(7);
	    			cell.setCellValue(q8);
	    			try {
	    				fos = new FileOutputStream("./Booook.xlsx");
	    			} catch (FileNotFoundException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				wb.write(fos);
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.flush();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.close();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			Mainframe.main(null);
	    			dispose();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 2;
		gbc_btnNewButton_6.gridy = 3;
		contentPane.add(btnNewButton_6, gbc_btnNewButton_6);



		JButton btnNewButton_3 = new JButton("AB+");
		btnNewButton_3.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_3.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

			}

		});


		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q4.equals("0")) {
					JOptionPane.showMessageDialog(null,"         BLOOD STOCK UNAVALIABLE      ","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"          RECIVIE AT HOSIPITAL WITH IN A DAY    ","", JOptionPane.INFORMATION_MESSAGE);
	    			row = sh.createRow(1);
	    			cell = row.createCell(0);
	    			cell.setCellValue(q1);
	    			cell = row.createCell(1);
	    			cell.setCellValue(q2);
	    			cell = row.createCell(2);
	    			cell.setCellValue(q3);
	    			cell = row.createCell(3);
	    			cell.setCellValue(num4-1);
	    			cell = row.createCell(4);
	    			cell.setCellValue(q5);
	    			cell = row.createCell(5);
	    			cell.setCellValue(q6);
	    			cell = row.createCell(6);
	    			cell.setCellValue(q7);
	    			cell = row.createCell(7);
	    			cell.setCellValue(q8);
	    			try {
	    				fos = new FileOutputStream("./Booook.xlsx");
	    			} catch (FileNotFoundException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				wb.write(fos);
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.flush();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.close();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			Mainframe.main(null);
	    			dispose();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 4;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("AB-");
		btnNewButton_7.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_7.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_7.setBorder(new EmptyBorder(1,1,1,1));
		btnNewButton_7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_7.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton_7.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255),1));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_7.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton_7.setForeground(new java.awt.Color(255, 255, 255));
				//btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

			}

		});

		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q8.equals("0")) {
					JOptionPane.showMessageDialog(null,"         BLOOD STOCK UNAVALIABLE      ","", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"          RECIVIE AT HOSIPITAL WITH IN A DAY    ","", JOptionPane.INFORMATION_MESSAGE);
	    			row = sh.createRow(1);
	    			cell = row.createCell(0);
	    			cell.setCellValue(q1);
	    			cell = row.createCell(1);
	    			cell.setCellValue(q2);
	    			cell = row.createCell(2);
	    			cell.setCellValue(q3);
	    			cell = row.createCell(3);
	    			cell.setCellValue(q4);
	    			cell = row.createCell(4);
	    			cell.setCellValue(q5);
	    			cell = row.createCell(5);
	    			cell.setCellValue(q6);
	    			cell = row.createCell(6);
	    			cell.setCellValue(q7);
	    			cell = row.createCell(7);
	    			cell.setCellValue(num8-1);
	    			try {
	    				fos = new FileOutputStream("./Booook.xlsx");
	    			} catch (FileNotFoundException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				wb.write(fos);
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.flush();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			try {
	    				fos.close();
	    			} catch (IOException e1) {
	    				e1.printStackTrace();
	    			}
	    			Mainframe.main(null);
	    			dispose();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_7.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_7.gridx = 2;
		gbc_btnNewButton_7.gridy = 4;
		contentPane.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JLabel lblNewLabel_1 = new JLabel("For more than 1 unit contact BLOOD BANK");
		lblNewLabel_1.setBackground(new java.awt.Color(75, 128, 215));
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));

		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 7;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}
}