import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        String item;
        double price;
        int quantity;
        char currency = '$';
        double tax = 0.20;
        double total;
        double result;

        Scanner input = new Scanner(System.in);
        System.out.print("What item would you like to buy?: ");
        item = input.nextLine();

        System.out.print("What is the price for each?: ");
        price = input.nextDouble();

        System.out.print("How many would you like?: ");
        quantity = input.nextInt();

        total = price * quantity;
        result = (total * tax) + total;


        System.out.println("\nYou have bought "+ quantity + " " + item + " \s");
        System.out.println("Your total is " + currency + result);


        input.close();


    }
}