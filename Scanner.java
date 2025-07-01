import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        try{
            String name;
            String surname;
            String noun;
            String verb;
            int age;
            char gender;
            boolean control;

            System.out.print("Enter your name: ");
            name = scanner.nextLine();

            System.out.print("Enter your surname: ");
            surname = scanner.nextLine();

            System.out.print("Enter your noun: ");
            noun = scanner.nextLine();

            System.out.print("Enter your verb: ");
            verb = scanner.nextLine();

            System.out.print("Enter your age: ");
            age = scanner.nextInt();

            System.out.print("Enter your gender: ");
            gender = scanner.next().charAt(0);

            System.out.print("Enter your control (y/n):  ");

            control = scanner.next().equals("y");

            if (control) {
                System.out.println("Your name: " + name);
                System.out.println("Your surname: " + surname);
                System.out.println("Your fullname: " + name + " " + surname);
                System.out.println("Noun: " + noun);
                System.out.println("Verb: " + verb);
                System.out.println("Your age: " + age);
                System.out.println("Your gender: " + gender);
            }else {
                System.out.println("Invalid input");
            }
        }catch (Exception e){
            System.out.println("Invalid input");
        }
    }
}