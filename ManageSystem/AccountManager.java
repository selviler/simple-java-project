package ManageSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountManager {

    private Connection connection;
    private Scanner scanner;
    AccountManager(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void creditMoney(long accountNumber) throws SQLException {
        scanner.nextLine();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter security pin: ");
        String securityPin = scanner.nextLine();

        try {
            connection.setAutoCommit(false);

            if (accountNumber != 0)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("select  * from account where securityPin = ? and where accountNumber = ?");
                preparedStatement.setLong(1, accountNumber);
                preparedStatement.setLong(2, securityPin);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String debitQuery = "UPDATE account SET balance = balance + ? WHERE account_number = ?";

                    PreparedStatement preparedStatement1 = connection.prepareStatement(debitQuery);

                    preparedStatement1.setDouble(1, amount);
                    preparedStatement1.setLong(2, receiverAccountNumber);

                    int rowAffected = preparedStatement1.executeUpdate();

                    if (rowAffected > 0) {
                        System.out.println("Transaction successful");
                        System.out.println("RS. " + amount +"Transaction successful");
                        connection.commit();
                        connection.setAutoCommit(true);
                        return;
                    }else {
                        System.out.println("Transaction not successful");
                        connection.rollback();
                        connection.setAutoCommit(true);
                    }
                }else{
                    System.out.println("Transaction not successful");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.setAutoCommit(true);


    }
    public void debitMoney(long accountNumber) throws SQLException {
       scanner.nextLine();
       double amount = scanner.nextDouble();
       scanner.nextLine();
       System.out.println("Enter security pin: ");
       String securityPin = scanner.nextLine();

       try {
           connection.setAutoCommit(false);

           if (accountNumber != 0)
           {
               PreparedStatement preparedStatement = connection.prepareStatement("select  * from account where securityPin = ? and where accountNumber = ?");
               preparedStatement.setLong(1, accountNumber);
               preparedStatement.setLong(2, securityPin);
               ResultSet resultSet = preparedStatement.executeQuery();

               if (resultSet.next()) {
                   double currentBalance = resultSet.getDouble("balance");

                   if (amount <= currentBalance) {
                       String debitQuery = "UPDATE account SET balance = balance - ? WHERE account_number = ?";

                       PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);
                       PreparedStatement debitPreparedStatement = connection.prepareStatement(debitQuery);
                       creditPreparedStatement.setDouble(1, amount);
                       creditPreparedStatement.setLong(2, receiverAccountNumber);
                       debitPreparedStatement.setDouble(1, currentBalance);
                       debitPreparedStatement.setLong(2, senderAccountNumber);

                       int rowAffected = debitPreparedStatement.executeUpdate();
                       int rowAffected1 = creditPreparedStatement.executeUpdate();

                       if (rowAffected > 0 && rowAffected1 > 0) {
                           System.out.println("Transaction successful");
                           System.out.println("RS. " + amount +"Transaction successful");
                           connection.commit();
                           connection.setAutoCommit(true);
                           return;
                       }else {
                           System.out.println("Transaction not successful");
                           connection.rollback();
                           connection.setAutoCommit(true);
                       }
                   }else{
                       System.out.println("Transaction not successful");
                   }
               }else{
                   System.out.println("Transaction not successful");
               }
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
        connection.setAutoCommit(true);

    }
    public void transferMoney(long senderAccountNumber) throws SQLException {
        scanner.nextLine();
        System.out.println("Enter receiver account number: ");
        long receiverAccountNumber = scanner.nextLong();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter security pin: ");
        String securityPin = scanner.nextLine();
        try {
            connection.setAutoCommit(false);
            if (senderAccountNumber != 0 && receiverAccountNumber != 0) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account where security_pin = ? and WHERE account_number = ?");
                preparedStatement.setLong(1, securityPin);
                preparedStatement.setString(2, receiverAccountNumber);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    double currentBalance = resultSet.getDouble("balance");

                    if (amount <= currentBalance) {
                        String debitQuery = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
                        String creditQuery = "UPDATE account SET balance = balance + ? WHERE account_number = ?";

                        PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);
                        PreparedStatement debitPreparedStatement = connection.prepareStatement(debitQuery);
                        creditPreparedStatement.setDouble(1, amount);
                        creditPreparedStatement.setLong(2, receiverAccountNumber);
                        debitPreparedStatement.setDouble(1, currentBalance);
                        debitPreparedStatement.setLong(2, senderAccountNumber);

                        int rowAffected = debitPreparedStatement.executeUpdate();
                        int rowAffected1 = creditPreparedStatement.executeUpdate();

                        if (rowAffected > 0 && rowAffected1 > 0) {
                            System.out.println("Transaction successful");
                            System.out.println("RS. " + amount +"Transaction successful");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        }else {
                            System.out.println("Transaction not successful");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }
                    }else{
                        System.out.println("Transaction not successful");
                    }
                }else{
                    System.out.println("Transaction not successful");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
    }
    public void getBalance(long accountNumber) throws SQLException {
        scanner.nextLine();
        System.out.println("Enter security pin: ");
        String securityPin = scanner.nextLine();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select balance from account where account_number = ? and security_pin = ?");
            preparedStatement.setLong(1, accountNumber);
            preparedStatement.setString(2, securityPin);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                System.out.println("Balance: " + balance);
            }else {
                System.out.println("Invalid security pin");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
