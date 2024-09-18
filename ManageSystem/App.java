package ManageSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    private static final String url = "jdbc:mysql://localhost:3306/bank";
    private static final String user = "myuser";
    private static final String password = "password";

    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Scanner scanner = new Scanner(System.in);
            User user = new User(connection, scanner);
            Account account = new Account(connection, scanner);
            AccountManager  accountManager = new AccountManager(connection, scanner);

            String email;
            long accountNumber;

            while (true){
                System.out.println("*** Welcome Bank App");
                System.out.println();
                System.out.println("1. Register");
                System.out.println("1. Login");
                System.out.println("3. Exit");
                int choice1 = scanner.nextInt();

                switch (choice1){
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email = user.login();
                        if (email != null){
                            System.out.println();
                            System.out.println("User Logged In");

                            if (!account.accountExist(email)){
                                System.out.println();
                                System.out.println("1. Open a Bank Account");
                                System.out.println("2. Exist");

                                if (scanner.nextInt() == 1) {
                                    accountNumber = account.openAccount(email);
                                    System.out.println("Account Created Successfully");
                                    System.out.println("Your account number: " + accountNumber);
                                }else {
                                    break;
                                }
                            }

                            accountNumber = account.getAccountNumber(email);
                            int choice2 = 0;
                            while (choice2 != 5){
                                System.out.println();
                                System.out.println("1. Debit money");
                                System.out.println("2. Credit money");
                                System.out.println("3. Transfer money");
                                System.out.println("4. Check balance");
                                System.out.println("5. Log out");
                                System.out.println("Enter your choice: ");
                                choice2 = scanner.nextInt();

                                switch (choice2){
                                    case 1:
                                        accountManager.debitMoney(accountNumber);
                                        break;
                                    case 2:
                                        accountManager.creditMoney(accountNumber);
                                        break;
                                    case 3:
                                        accountManager.transferMoney(accountNumber);
                                        break;
                                    case 4:
                                        accountManager.getBalance(accountNumber);
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("enter valid choice");
                                        break;
                                }
                            }
                        }
                        else {
                            System.out.println("Incorrect email or password");
                        }
                    case 3:
                        System.out.println("Thank you");
                        System.out.println("exiting system");
                        return;
                    default:
                        System.out.println("Enter valid choice");
                        break;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Connecting to the database...");
    }
}
