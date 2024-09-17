import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
//       String text1 = "yatay";
//       String control = "";
//
//       for (int i = text1.length()-1; i >= 0; i--) {
//           control += text1.charAt(i);
//       }
//
//       if (text1.equals(control)) {
//           System.out.println("equal");
//       }else{
//           System.out.println("not equal");
//       }
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;
        System.out.println("Welcome to the game");
        System.out.println("please enter the dimensions you want to play");
        row = scanner.nextInt();
        System.out.println();
        column = scanner.nextInt();

        Game game = new Game(row, column);
        game.handle();

    }
}