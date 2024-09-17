import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] study = new int[7];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Math: ");
        study[0] = scanner.nextInt();
        System.out.println("Literature: ");
        study[1] = scanner.nextInt();
        System.out.println("Physics: ");
        study[2] = scanner.nextInt();
        System.out.println("History: ");
        study[3] = scanner.nextInt();
        System.out.println("Chemistry: ");
        study[4] = scanner.nextInt();
        System.out.println("Music: ");
        study[5] = scanner.nextInt();
        System.out.println("Biology: ");
        study[6] = scanner.nextInt();


        int total = 0;
        for (int item : study)
        {
            total += item;
        }
        System.out.println("Total: " + total);
        System.out.println("Average: " + total / study.length);

        Random rand = new Random();
        int token = 10;
        int number = rand.nextInt(100);
        int[] list = new int[10];

        Scanner scanner1 = new Scanner(System.in);

        while (token > 0){
            System.out.println("Enter to number: ");
            int forecast = scanner1.nextInt();

            if (forecast < 0 || forecast > 100)
            {
                System.out.println("Invalid input");
                break;
            }
            if (forecast == number){
                System.out.println("bravo you've got it right.");
                for (int nmbr : list) {
                    System.out.println("previous forecasts :"+ nmbr);
                }
                break;
            }else{
                list[token - 1] = forecast;
                System.out.println("your remaining number of coins: "+ token);
                System.out.println("Please try again");
            }
            token--;
        }

        for (int i : list)
        {
            System.out.println("forecast list:" + i);
        }
    }
}