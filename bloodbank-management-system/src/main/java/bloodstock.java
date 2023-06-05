import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class bloodstock extends JFrame {

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
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet3");
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bloodstock frame = new bloodstock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public bloodstock() {
		String q1,q2,q3,q4,q5,q6,q7,q8;
		Cell r1,r2,r3,r4,r5,r6,r7,r8;
		
	
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

		// the main content page
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(75, 128, 215));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		// adding this code to create jtable
/*
		JTable table = new JTable(data, columns);
		//add the table to the frame
		this.add(new JScrollPane(table));

		// adding a new row
		tableModel.insertRow(tableModel.getRowCount(), new Object[] { "ExpressJS" });
		JFrame f = new JFrame();
		f.setSize(550, 350);
		f.add(new JScrollPane(table));
		f.setVisible(true);
*/

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 100, 530, 250);
		scrollPane.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 10));
		scrollPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		scrollPane.setAlignmentX(40);
		contentPane.add(scrollPane);

		String[][] data = {{"A+",r1.toString()},{"B+",r2.toString()},{"O+",r3.toString()},{"AB+",r4.toString()},
				{"A-",r5.toString()},{"B-",r6.toString()},{"O-",r7.toString()},{"AB-",r8.toString()},};
		String[] column= {"Blood group","Quantity"};

		JTable jt1 = new JTable(data,column);
		jt1.setBackground(new java.awt.Color(137, 153, 178));
		jt1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		jt1.setDefaultEditor(Object.class, null);
		jt1.setRowHeight(30);
		JTableHeader header = jt1.getTableHeader();
		header.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		header.setBackground(new java.awt.Color(58, 65, 75));
		header.setForeground(new java.awt.Color(255, 255, 255));

		scrollPane.setViewportView(jt1);


		// back button
		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.setBounds(10, 11, 100, 33);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
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
				Admin.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton);




		/*
		JLabel lblNewLabel = new JLabel("				A+");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(50, 55, 91, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("				O+");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setBounds(50, 106, 78, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("				B+");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_2.setBounds(50, 151, 78, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("				AB+");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_3.setBounds(50, 199, 78, 39);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("				A-");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_4.setBounds(50, 249, 78, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("				O-");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_5.setBounds(50, 293, 78, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("				B-");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_6.setBounds(50, 333, 78, 39);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("				AB-");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_7.setBounds(50, 378, 78, 39);
		contentPane.add(lblNewLabel_7);



		JLabel lblNewLabel_8 = new JLabel(q1);
		lblNewLabel_8.setBounds(138, 67, 61, 16);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel(q2);
		lblNewLabel_9.setBounds(138, 115, 61, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(q3);
		lblNewLabel_10.setBounds(138, 163, 61, 16);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(q4);
		lblNewLabel_11.setBounds(138, 211, 61, 16);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(q5);
		lblNewLabel_12.setBounds(138, 258, 61, 16);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(q6);
		lblNewLabel_13.setBounds(138, 305, 61, 16);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(q7);
		lblNewLabel_14.setBounds(138, 342, 61, 16);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel(q8);
		lblNewLabel_15.setBounds(138, 390, 61, 16);
		contentPane.add(lblNewLabel_15);
*/

		// EDIT BLOOD STOCK
		JButton btnNewButton_1 = new JButton("Edit Blood Stock");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
		btnNewButton_1.setBorder(new EmptyBorder(1, 1, 1, 1));
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.main(null);
				dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					edit_bloodstock.main(null);
				} catch (EncryptedDocumentException e1) {
					
					e1.printStackTrace();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton_1.setBounds(324, 385, 217, 29);
		contentPane.add(btnNewButton_1);
	}

}