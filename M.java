import java.util.Scanner;

public class M {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountService as = new AccountService();

        while (true) {
            System.out.println("\n1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    as.createAccount();
                    break;
                case 2:
                    as.deposit();
                    break;
                case 3:
                    as.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank You 🙏");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
