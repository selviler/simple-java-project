package ManageSystem;

import java.sql.*;
import java.util.Scanner;

public class Account {

    private Connection conn;
    private Scanner scanner;
    Account(Connection conn, Scanner scanner) {
        this.conn = conn;
        this.scanner = scanner;
    }

    public long openAccount(String email)
    {
        if (!accountExist(email)){
            String openAccountQuery = "INSERT INTO Accounts(account_number, full_name, email, balance, security_pin) VALUES (?, ?, ?, ?, ?)";
            scanner.nextLine();
            System.out.println("Enter full name: ");
            String fullName = scanner.nextLine();
            System.out.println("Enter amount: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter Security Pin: ");
            String securityPin = scanner.nextLine();

            try {
                long accountNumber = generateAccountNumber();
                PreparedStatement preparedStatement = conn.prepareStatement(openAccountQuery);
                preparedStatement.setLong(1, accountNumber);
                preparedStatement.setString(2, fullName);
                preparedStatement.setString(3, email);
                preparedStatement.setDouble(4, balance);
                preparedStatement.setString(5, securityPin);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0){
                    return accountNumber;
                }else {
                    throw new SQLException("Account created failed");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Account already exists");
    }

    public long getAccountNumber(String email)
    {
        String query = "SELECT account_number FROM Accounts WHERE email = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getLong("account_number");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        throw new RuntimeException("Account does not exist");
    }

    private long generateAccountNumber()
    {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT account_number FROM accounts Order By  account_number DESC limit 1");
            if (resultSet.next()){
                long lastAccountNumber = resultSet.getLong("account_number");
                return lastAccountNumber + 1;
            }else{
                return 10000100;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 10000100;
    }
    public boolean accountExist(String email)
    {
        String query = "SELECT account_number FROM Accounts WHERE email = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
