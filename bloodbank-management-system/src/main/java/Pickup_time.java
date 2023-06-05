import java.awt.*;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;

public class Pickup_time extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pickup_time frame = new Pickup_time();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Pickup_time() throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground((new java.awt.Color(75, 128, 215)));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		JLabel lblNewLabel = new JLabel("Enter Received Time", SwingConstants.CENTER);
		lblNewLabel.setForeground((new java.awt.Color(255, 255, 255)));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(138, 6, 240, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setForeground((new java.awt.Color(255, 255, 255)));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setBounds(30, 100, 150, 20);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(200, 95, 170, 30);
		textField.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date & Time");
		lblNewLabel_2.setForeground((new java.awt.Color(255, 255, 255)));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_2.setBounds(30, 180, 200, 20);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 171, 170, 30);
		textField_1.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setBorder(new EmptyBorder(1,1,0,1));
		btnNewButton.setBounds(327, 237, 117, 29);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(25, 102, 224));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(new LineBorder(java.awt.Color.white,2));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
				btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
				btnNewButton.setBorder(new EmptyBorder(1,1,1,1));
			}

		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = textField.getText();
				String t2 = textField_1.getText();
				int noOfRows=sh.getLastRowNum();
				int j =1;
				for(int i=1;i<=noOfRows;i++) {
					j=i;
        			Cell r1 = sh.getRow(i).getCell(0);
        			Cell r2 = sh.getRow(i).getCell(1);
        			Cell r3 = sh.getRow(i).getCell(2);
        			Cell r4 = sh.getRow(i).getCell(3);
        			Cell r5 = sh.getRow(i).getCell(4);
        			String a1 = r1.toString();
        			String a2 = r2.toString();
        			String a3 = r3.toString();
        			String a4 = r4.toString();
        			String a5 = r5.toString();
        			
        			if(a1.equals(t1)){   
      	              
	                 	
      	              
             			row = sh.createRow(i);
             			cell = row.createCell(0);
             			cell.setCellValue(t1);
             			cell = row.createCell(1);
             			cell.setCellValue(a2);
             			cell = row.createCell(2);
             			cell.setCellValue(a3);
             			cell = row.createCell(3);
             			cell.setCellValue(a4);
             			cell = row.createCell(4);
             			cell.setCellValue(a5);
             			cell = row.createCell(5);
             			cell.setCellValue(t2);
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
             			JOptionPane.showMessageDialog(null,"            ENTERED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
             			textField.setText(null);
       				   textField_1.setText(null);
             			break;
    	              }
        			
        			 else if(t1.equals("") || t2.equals("") ) {
        				 textField.setText(null);
        				 textField_1.setText(null);
        				
        				 JOptionPane.showMessageDialog(null, "           INVALID DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
  						break;
        			 }
	          
				
			}
				Cell c1 = sh.getRow(j).getCell(0);
				String b1 = c1.toString();
				if(!b1.equals(t1)) {
   				 JOptionPane.showMessageDialog(null, "           INVALID DETAILS      ", "ERROR",JOptionPane.ERROR_MESSAGE);
				
               	}
			}});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<Back");

		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_1.setBorder(new EmptyBorder(1,1,0,1));
		btnNewButton_1.setBounds(-3, 1, 117, 29);

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
				Admin.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("EX:-13JAN 12:30");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_3.setBounds(200, 200, 159, 16);
		contentPane.add(lblNewLabel_3);
	}
}