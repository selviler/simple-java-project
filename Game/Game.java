import javax.tools.Tool;
import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);

    public void login()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the adventure game");
        System.out.println("What is your name?: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.charMenu();
    }

    public void start() {
       while (true){
           System.out.println("");
           System.out.println("===========");
           System.out.println();
           System.out.println("Make a choice to move: ");
           System.out.println("1st House ---> It belongs to you, you can use it to relax");
           System.out.println("2nd Cave ---> You can use it to fight - reptile animal");
           System.out.println("3rd Forest ---> You can use it to fight - predator");
           System.out.println("4. River ---> You can use it to fight - wild animal");
           System.out.println("5. Store ---> You can buy equipment");
           int choice = scanner.nextInt();
           while (choice < 0 || choice > 5) {
               System.out.println("make a valid choice");
               choice = scanner.nextInt();
           }

           switch (choice){
               case 1:
                   location = new SafeHouse("Home", player);
                   break;
               case 2:
                   location = new Cave(player);
               case 3:
                   location = new Forest(player);
               case 4:
                   location = new River(player);
               case 5:
                   location = new ToolScore("Store", player);
                   break;
               default:
                   location = new SafeHouse("Home", player);
           }

           if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().getFirewood() && player.getInv().getWater() && player.getInv().getFood()) {
                    System.out.println("Thank you");
                    break;
                }
           }
           if (!location.getLocation())
           {
               System.out.println("Game over!");
               break;
           }
       }
    }
}
