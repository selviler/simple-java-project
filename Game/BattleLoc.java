public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;
    BattleLoc(String name, Player player, Obstacle obstacle, String award) {
        super(name, player);
        this.obstacle = obstacle;
        this.award = award;
    }

    public boolean getLocation()
    {
        int absCount = obstacle.count();
        System.out.println("Now " + getName());
        System.out.println("Be careful here " + absCount + "one " + obstacle.getName() + " lives!");
        System.out.println("<W>ar or <R>un");
        String selCase = scanner.next();

        selCase = selCase.toUpperCase();

        if (selCase.equals("S")){
            if (combat(absCount)) {
                System.out.println(this.getName() + " all enemies in the region have been cleared");
                if (this.award.equals("Food") && player.getInv().getFood() == false) {
                    System.out.println(this.award + " You win ");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Water") && player.getInv().getWater() == false) {
                    System.out.println(this.award + " You win ");
                    player.getInv().setWater(true);
                } else if (this.award.equals("Firewood") && player.getInv().getFirewood() == false) {
                    System.out.println(this.award + " You win ");
                    player.getInv().setFirewood(true);
                }
                return true;
            }
            if (player.getHealthy() <= 0)
            {
                System.out.println("you're dead");
                return false;
            }
        }
        return true;
    }

    public boolean combat (int obsCount)
    {
        for (int i = 0; i < obsCount; i++){
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealthy() > 0 && obstacle.getHealth() > 0)
            {
                System.out.println("<W>ar or <R>un");
                String selCase = scanner.next();
                selCase = selCase.toUpperCase();
                 if (selCase.equals("V")){
                     System.out.println("You shot !");
                     obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());

                     afterHit();
                     if (obstacle.getHealth() > 0)
                     {
                         System.out.println();
                         System.out.println("Cavanar hit");
                         System.out.println(player.getHealthy() - (obstacle.getHealth() - player.getInv().getArmor()));
                     }
                 }else{
                     break;
                 }
            }
            if (obstacle.getHealth() < player.getHealthy()) {
                System.out.println("You defeated the enemy");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Balance: " + player.getMoney());
                obstacle.setHealth(defObsHealth);
            }else{
                return false;
            }
            System.out.println("--------------------------------------------");
        }
        return true;
    }

    public void playerStats(){
        System.out.println("Player values\n-------------");
        System.out.println("Can: " + player.getHealthy());
        System.out.println("Can: " + player.getTotalDamage());
        System.out.println("Can: " + player.getMoney());
        if (player.getInv().getDamage() > 0)
        {
            System.out.println("Armor: " + player.getInv().getArmor());
        }
        if (player.getInv().getArmor() > 0)
        {
            System.out.println("Armor: " + player.getInv().getaName());
        }
    }
    public void enemyStats(){
        System.out.println(obstacle.getName() + "Player values\n---------------------");
        System.out.println("Can: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
    }

    public void afterHit()
    {
        System.out.println("Player's life: " + player.getHealthy());
        System.out.println(obstacle.getName() + "Help " + obstacle.getHealth());
        System.out.println();
    }
}
