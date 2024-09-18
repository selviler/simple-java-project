package ManageSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {

    private Connection connection;
    private Scanner scanner;

    User(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void register()
    {
        scanner.nextLine();
        System.out.println("Full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        if (userExist(email)){
            System.out.println("Email already exists");
            return;
        }
        String registerQuery = "INSERT INTO User(full_name, email, password) VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(registerQuery);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Register Successful");
            }else{
                System.out.println("Register Failed");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public String login()
    {
        scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        String loginQuery = "SELECT * FROM User WHERE email = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return email;
            }else{
                return null;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean userExist(String email)
    {
        String query = "SELECT * FROM User WHERE email = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
