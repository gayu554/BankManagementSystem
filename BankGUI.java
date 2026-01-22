import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class BankGUI {

    public static void main(String[] args) {

        JFrame f = new JFrame("Create Account");

        JLabel l1 = new JLabel("Customer ID:");
        JLabel l2 = new JLabel("Name:");
        JLabel l3 = new JLabel("Mobile:");
        JLabel l4 = new JLabel("Account No:");
        JLabel l5 = new JLabel("Balance:");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();

        JButton btn = new JButton("Create Account");

        l1.setBounds(30, 30, 100, 25);
        t1.setBounds(150, 30, 150, 25);

        l2.setBounds(30, 70, 100, 25);
        t2.setBounds(150, 70, 150, 25);

        l3.setBounds(30, 110, 100, 25);
        t3.setBounds(150, 110, 150, 25);

        l4.setBounds(30, 150, 100, 25);
        t4.setBounds(150, 150, 150, 25);

        l5.setBounds(30, 190, 100, 25);
        t5.setBounds(150, 190, 150, 25);

        btn.setBounds(120, 230, 150, 30);

        // 👉 BUTTON ACTION
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(f, "Button Clicked 👍");
                     try {
                        int cid = Integer.parseInt(t1.getText());
                        String name = t2.getText();
                        String mobile = t3.getText();
                        String accNo = t4.getText();
                        double balance = Double.parseDouble(t5.getText());

                        Connection con = DBConnection.getConnection();

                        String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(sql);

                        ps.setInt(1, cid);
                        ps.setString(2, name);
                        ps.setString(3, mobile);
                        ps.setString(4, accNo);
                        ps.setDouble(5, balance);

                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(f, "Account Created Successfully ✅");

                        con.close();

                    } catch (Exception ex) {
                            JOptionPane.showMessageDialog(f, ex.getMessage());
                    }    
            }
        });

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(l4); f.add(t4);
        f.add(l5); f.add(t5);
        f.add(btn);

        f.setSize(350, 330);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
