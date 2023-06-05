import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class BloodBankTable extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private String visa="0";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        BloodBankTable frame = new BloodBankTable();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public BloodBankTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 820, 440);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(85, 111, 213));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Hospital Details");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 11, 764, 23);
        contentPane.add(lblNewLabel);

        String[] columns = {"Hospital ID", "Hospital Name", "Pincode", "Address",
                "Phone No"};

        DefaultTableModel obj=new DefaultTableModel(columns,0);

        sqlconnect connection = new sqlconnect();
        Connection con = connection.connect();
        Statement st;
        String query="";
        try {
            st = con.createStatement();
            query = "Select * from blood_bank";
            //System.out.println(st.executeQuery(query));
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Object[] update =  {rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5)};
                obj.addRow(update);
            }
        }catch(Exception e) {
            System.out.println(e);
        }

        table = new JTable(obj);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 39, 770, 280);
        contentPane.add(scrollPane);

//        JButton btnNewButton_1 = new JButton("Book Flight");
        /*btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRowCount()==1)
                {
                    String visachoice= JOptionPane.showInputDialog(null,"Enter Y for having Visa and N for having no Visa",null);
                    if(visachoice.equals("N")) {
                        JOptionPane.showMessageDialog(null,"Sorry you can't book a flight");
                    }
                    else if(visachoice.equals("Y")){
                        String userchoice= JOptionPane.showInputDialog(null,"Enter 1 for Economy class and 2 for Business Class",null);


                        int slctClass = Integer.valueOf(userchoice);

                        switch (slctClass)
                        {
                            case 1:
                            {
                                String query  = "insert into bookings values('"+user+"','Economy','"+table.getValueAt(table.getSelectedRow(),0).toString()+"')";
                                sqlconnect connection = new sqlconnect();
                                Connection con = connection.connect();
                                Statement st=null;
                                try {
                                    st = con.createStatement();
                                    st.executeQuery(query);
                                    JOptionPane.showMessageDialog(null, "Your flight has been booked!");
                                }catch(Exception i) {

                                }finally {
                                    JOptionPane.showMessageDialog(null, "Your flight has been booked!");
                                }
                                break;
                            }
                            case 2:
                            {
                                String query  = "insert into bookings values('"+user+"','Business','"+table.getValueAt(table.getSelectedRow(),0).toString()+"')";
                                sqlconnect connection = new sqlconnect();
                                Connection con = connection.connect();
                                Statement st=null;
                                try {
                                    st = con.createStatement();
                                    st.executeQuery(query);

                                }catch(Exception i) {

                                }
                                finally {
                                    JOptionPane.showMessageDialog(null, "Your flight has been booked!");
                                }
                                break;
                            }
                            default:
                            {
                                JOptionPane.showMessageDialog(null, "You entered an invalid input. Try again");
                                break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println(visa);
                        JOptionPane.showMessageDialog(null, "Please enter '1' or '2' only.");
                    }
                }
                else if(table.getSelectedRowCount()==0)
                {
                    JOptionPane.showMessageDialog(null, "Please select a flight to book.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select one flight at a time.");
                }
            }
        });*/
//        btnNewButton_1.setBounds(185, 249, 111, 23);
//        contentPane.add(btnNewButton_1);

//        JButton btnNewButton_2 = new JButton("View Ticket Price");
//        btnNewButton_2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if(table.getSelectedRowCount()==0)
//                {
//                    JOptionPane.showMessageDialog(null, "Please select a flight to view price.");
//                    return;
//                }
//                double hour=Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 7));
//
//                double cost=(hour*20000)+((hour*20000)*10/100);
//                JOptionPane.showMessageDialog(null, "The cost for this flight is: "+cost);
//            }
//        });
//        btnNewButton_2.setBounds(306, 249, 163, 23);
//        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("<< Back");
        btnNewButton_3.setBounds(380, 350, 100, 30);
        btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
        btnNewButton_3.setBackground(new java.awt.Color(75, 128, 215));
        btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
        btnNewButton_3.setBorder(new EmptyBorder(1, 1, 1, 1));

        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton_3.setBackground(new java.awt.Color(25, 102, 224));
                btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
                btnNewButton_3.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton_3.setBackground(new java.awt.Color(75, 128, 215));
                btnNewButton_3.setForeground(new java.awt.Color(255, 255, 255));
            }
        });


        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(btnNewButton_3);

        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mainframe.main(null);
                dispose();
            }
        });
        contentPane.add(btnNewButton_3);

    }
}