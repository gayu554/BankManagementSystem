import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AccountService {

    Scanner sc = new Scanner(System.in);

    // CREATE ACCOUNT
    public void createAccount() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Customer ID: ");
            int cid = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Mobile: ");
            String mobile = sc.next();

            System.out.print("Account No: ");
            String accNo = sc.next();   // ⭐ STRING

            System.out.print("Balance: ");
            double balance = sc.nextDouble();

            ps.setInt(1, cid);
            ps.setString(2, name);
            ps.setString(3, mobile);
            ps.setString(4, accNo);
            ps.setDouble(5, balance);

            ps.executeUpdate();
            System.out.println("✅ Account Created Successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DEPOSIT
    public void deposit() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Account No: ");
            String accNo = sc.next();

            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();

            String sql = "UPDATE customer SET balance = balance + ? WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amt);
            ps.setString(2, accNo);

            ps.executeUpdate();
            System.out.println("✅ Amount Deposited");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CHECK BALANCE
    public void checkBalance() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Account No: ");
            String accNo = sc.next();

            String sql = "SELECT balance FROM customer WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("💰 Balance: " + rs.getDouble(1));
            } else {
                System.out.println("❌ Account Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
