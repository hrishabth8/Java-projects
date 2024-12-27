import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import javax.swing.border.LineBorder;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class blood_bank extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private JTextField textField_ph;
    private JTextField textField_loc;
    private JTextField textField_q;
    private JTextField textField_hosp;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    blood_bank frame = new blood_bank();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public blood_bank() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
        contentPane.setBackground(new java.awt.Color(75, 128, 215));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Hospital Registration");
        lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel_3.setBounds(100, 50, 240, 35);
        contentPane.add(lblNewLabel_3);

       /* JLabel lblNewLabel = new JLabel("Hospital ID ");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel.setBounds(31, 70, 200, 60);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Hospital name");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel_1.setBounds(31, 115, 150, 26);
        contentPane.add(lblNewLabel_1);*/



        JLabel lblNewLabel_hosp = new JLabel("Hospital ID");
        lblNewLabel_hosp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel_hosp.setForeground(new java.awt.Color(255,255,255));
        lblNewLabel_hosp.setBounds(31, 260, 200, 60);
        contentPane.add(lblNewLabel_hosp);
        //hosp
        textField_hosp = new JTextField();
        textField_hosp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
        textField_hosp.setHorizontalAlignment(SwingConstants.CENTER);
        textField_hosp.setBounds(240, 275, 150, 26);
        textField_hosp.setBorder(new EmptyBorder(1,1,1,1));
        textField_hosp.setForeground(java.awt.Color.black);
        contentPane.add(textField_hosp);
        textField_hosp.setColumns(10);


//        textField = new JTextField();
//        textField.setBounds(240, 70, 150, 26);
//        textField.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
//        textField.setHorizontalAlignment(SwingConstants.CENTER);
//        textField.setBorder(new EmptyBorder(1,1,1,1));
//        textField.setForeground(new java.awt.Color(0, 0, 0));
//        contentPane.add(textField);
//        textField.setColumns(10);

//        textField_1 = new JTextField();
//        textField_1.setBounds(240, 115, 150, 26);
//        textField_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
//        textField_1.setBorder(new EmptyBorder(1,1,1,1));
////        textField.setForeground(new java.awt.Color(0, 0, 0));
//        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
//        contentPane.add(textField_1);
//        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Pincode");
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel_2.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel_2.setBounds(31, 110, 200, 60);
        contentPane.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
        textField_2.setBorder(new EmptyBorder(1,1,1,1));
        textField_2.setForeground(new java.awt.Color(0, 0, 0));
        textField_2.setBounds(240, 125, 150, 26);
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(textField_2);
        textField_2.setColumns(10);


        JLabel lblNewLabel_q = new JLabel("Address");
        lblNewLabel_q.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel_q.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel_q.setBounds(31, 160, 200, 60);
        contentPane.add(lblNewLabel_q);

        textField_q = new JTextField();
        textField_q.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
        textField_q.setBorder(new EmptyBorder(1,1,1,1));
        textField_q.setForeground(new java.awt.Color(0, 0, 0));
        textField_q.setHorizontalAlignment(SwingConstants.CENTER);
        textField_q.setBounds(240, 175, 150, 26);
        contentPane.add(textField_q);
        textField_q.setColumns(10);


        JLabel lblNewLabel_loc = new JLabel("Hospital Name");
        lblNewLabel_loc.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel_loc.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel_loc.setBounds(31, 205, 200, 60);
        contentPane.add(lblNewLabel_loc);

        textField_loc = new JTextField();
        textField_loc.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
        textField_loc.setBorder(new EmptyBorder(1,1,1,1));
        textField_loc.setForeground(new java.awt.Color(0, 0, 0));
        textField_loc.setHorizontalAlignment(SwingConstants.CENTER);
        textField_loc.setBounds(240, 225, 150, 26);
        contentPane.add(textField_loc);
        textField_loc.setColumns(10);

        JLabel lblNewLabel_ph = new JLabel("Phone.no ");
        lblNewLabel_ph.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel_ph.setForeground(new java.awt.Color(255,255,255));
        lblNewLabel_ph.setBounds(31, 310, 200, 60);
        contentPane.add(lblNewLabel_ph);
        //hosp
        textField_ph = new JTextField();
        textField_ph.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
        textField_ph.setHorizontalAlignment(SwingConstants.CENTER);
        textField_ph.setBounds(240, 325, 150, 26);
        textField_ph.setBorder(new EmptyBorder(1,1,1,1));
        textField_ph.setForeground(java.awt.Color.black);
        contentPane.add(textField_ph);
        textField_ph.setColumns(10);

        JButton btnNewButton = new JButton("Register");
        btnNewButton.setBounds(305, 400, 120, 35);
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
        btnNewButton.setBackground(new java.awt.Color(75, 128, 215));
        btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
        btnNewButton.setBorder(new EmptyBorder(1,1,1,1));

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
            }});
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("< Back");
        btnNewButton_1.setBounds(10, 5, 100, 30);
        btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        btnNewButton_1.setBackground(new java.awt.Color(75, 128, 215));
        btnNewButton_1.setForeground(new java.awt.Color(255, 255, 255));
        btnNewButton_1.setBorder(new EmptyBorder(1,1,1,1));

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
            public void actionPerformed(ActionEvent arg0) {
                Admin.main(null);
                dispose();

            }
        });
        contentPane.add(btnNewButton_1);
    }
    public void addToDB(){
        boolean ans=false;
        String hid,hname,pin,add,phno;
        hname=textField_loc.getText();
        phno=textField_ph.getText();
        pin=textField_2.getText();
        hid=textField_hosp.getText();
        add=textField_q.getText();
        if(hname.equals("") || phno.equals("")|| pin.equals("") || hid.equals("")||add.equals("")){
            JOptionPane.showMessageDialog(null, "            Fields not filled    ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
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
                ResultSet rsq = null;
//						String sql = "INSERT INTO logindetails VALUES('"+s1+"','"+s2+"','"+s4+"','"+s5+"');";
                String sql = "insert into blood_bank values('"+hid+"','"+hname+"','"+pin+"','"+add+"','"+phno+"');";
                System.out.println(sql);
                st.executeUpdate(sql);

                c.commit();
                ans =true;
                if(ans){
                    JOptionPane.showMessageDialog(null, "       Registred Successfully         ", "Successful", JOptionPane.PLAIN_MESSAGE);
                    textField_loc.setText(null);
                    textField_ph.setText(null);
                    textField_hosp.setText(null);
                    textField_2.setText(null);
                    textField_q.setText(null);
                }
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
}