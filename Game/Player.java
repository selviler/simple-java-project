import java.util.Scanner;

public class Player {
    private int damage, healthy, money, rHealthy;
    private String name, cName;
    public Inventory inventory;
    Scanner scan = new Scanner(System.in);

    Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar()
    {
       switch (charMenu()){
           case 1:
               setcName("Samurai");
               setDamage(5);
               setHealthy(21);
               setMoney(15);
               setrHealthy(rHealthy);
               break;
           case 2:
               setcName("Archer");
               setDamage(7);
               setHealthy(18);
               setMoney(20);
               setrHealthy(rHealthy);
               break;
           case 3:
               setcName("Knight");
               setDamage(8);
               setHealthy(24);
               setMoney(5);
               setrHealthy(rHealthy);
               break;
           default:
               break;
       }
       System.out.println("Character: +" + getcName() + "\t Damage: " + getDamage() + "\t Health: " + getHealthy() + "\t Money: " + getMoney());
    }
    public int getTotalDamage()
    {
        return this.getDamage() + this.getInv().getDamage();
    }
    public void setInv(Inventory inventory)
    {
        this.inventory = inventory;
    }
    public Inventory getInv()
    {
        return this.inventory;
    }
    public int charMenu()
    {
        System.out.println("please select character: ");
        System.out.println("1- Samurai \t Damage : 5 \t Health: 21 \t Money: 15");
        System.out.println("2- Archer \t Damage : 7 \t Health: 18 \t Money: 20");
        System.out.println("3- Knight \t Damage : 8 \t Health: 24 \t Money: 5");
        int chaID = scan.nextInt();
        while (chaID < 1 || chaID > 3){
            System.out.println("Please select a valid character. ");
            chaID = scan.nextInt();
        }
        return chaID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setDamage(int demage){
        this.damage = demage;
    }
    public int getDamage(){
        return this.damage;
    }
    public void setHealthy(int healthy){
        this.healthy = healthy;
    }
    public int getHealthy(){
        return this.healthy;
    }
    public void setMoney(int money)
    {
        this.money = money;
    }
    public int getMoney()
    {
        return this.money;
    }
    public void setcName(String name){
        this.cName = name;
    }
    public String getcName(){
        return this.cName;
    }
    public void setrHealthy(int rHealthy)
    {
        this.rHealthy = rHealthy;
    }
    public int getrHealthy()
    {
        return this.rHealthy;
    }
}
