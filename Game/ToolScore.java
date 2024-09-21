import java.util.Scanner;

public class ToolScore extends NormalLoc{

    Scanner scanner = new Scanner(System.in);

    ToolScore(String name, Player player) {
        super("Store", player);
    }

    public boolean getLocation()
    {
        System.out.println("Money: " + player.getMoney());
        System.out.println("1. Arrow");
        System.out.println("2. Armor");
        System.out.println("3. Exit");
        System.out.println("Your choice: ");
        int selTool = scanner.nextInt();
        int selItemID = scanner.nextInt();
        switch (selTool){
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                break;
            default:
                break;
        }
        return true;
    }

    public int armorMenu()
    {
        System.out.println("1. Lightweight\t < Money: 15 - Damage : 1 >");
        System.out.println("2. Middle\t < Money: 25 - Damage : 2 >");
        System.out.println("3. Heavy\t < Money: 40 - Damage : 5 >");
        System.out.println("4. Exist");
        System.out.println("Select Armor: ");
        int selArmorID = scanner.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID)
    {
        int avoid = 0, price = 0;
        String aName = "";
        switch (itemID)
        {
            case 1:
                avoid = 1;
                aName = "Light armor";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Medium armor";
                price = 25;
                break;
            case 3:
                avoid = 5;
                aName = "Heavy armor";
                price = 40;
                break;
            case 4:
                System.out.println("Exit is in progress");
                break;
            default:
                System.out.println("Error");
                break;
        }

        if (price > 0) {
            if (player.getMoney() > price) {

                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);


                player.setMoney(player.getMoney() - price);
                System.out.println(
                        aName + "Armor purchased, previous damage: "
                                + player.getDamage()
                                + "New damage: "
                                + (player.getDamage()
                                + player.getInv().getDamage()
                                + player.getTotalDamage()
                        ));
                System.out.println("Balance: " + player.getMoney());
            }else{
                System.out.println("Error");
            }
        }
    }
    public int weaponMenu()
    {
        System.out.println("1. Ok\t < Money: 25 - Damage : 2 >");
        System.out.println("2. Arrow\t < Money: 35 - Damage : 3 >");
        System.out.println("3. Rifle\t < Money: 45 - Damage : 7 >");
        System.out.println("3. exist");
        System.out.println("Select Armor: ");
        int selWeaponID = scanner.nextInt();
        return selWeaponID;
    }
    public void buyWeapon(int itemID)
    {
        int damage = 0, price = 0;
        String wName = "";

            switch (itemID)
            {
                case 1:
                    damage = 2;
                    wName = "Ok";
                    price = 5;
                    break;
                case 2:
                    damage = 3;
                    wName = "Arrow";
                    price = 35;
                    break;
                case 3:
                    damage = 7;
                    wName = "Rifle";
                    price = 45;
                    break;
                case 4:
                    System.out.println("Exit is in progress");
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

           if (price > 0) {
               if (player.getMoney() > price) {
                   player.getInv().setDamage(damage);
                   player.getInv().setaName(wName);
                   player.setMoney(player.getMoney() - price);
                   System.out.println(
                           wName + "Armor purchased, previous damage: "
                                   + player.getDamage()
                                   + "New damage: "
                                   + (player.getDamage()
                                   + player.getInv().getDamage()
                                   + player.getTotalDamage()
                           ));
                   System.out.println("Balance: " + player.getMoney());
               }else{
                   System.out.println("Error");
               }
           }
    }
}
