import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your date of birth: ");
        int birthday = scanner.nextInt();
        System.out.println("Your Birthday is: " + (2024 - birthday));
        System.out.println();

        System.out.println("Please enter two numbers: ");
        int number = scanner.nextInt();
        int number1 = scanner.nextInt();

        System.out.println("the smaller number: " + Math.min(number1, number));
        System.out.println("sum of two numbers: " + (number1 + number));
        System.out.println("difference of two numbers: " + (number1 - number));
        System.out.println("quotient of two numbers: " + (number1 / number));

        System.out.println("What is your name");
        String name = scanner.next();

        int lastCharacter = name.length() - 1;
        int numberCharacters = name.length();
        System.out.println("last character: " + lastCharacter);
        System.out.println("number characters: " + numberCharacters);
        System.out.println("Last letter of your name: " + name.charAt(lastCharacter));
        scanner.close();
    }
}