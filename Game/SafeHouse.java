public class SafeHouse extends NormalLoc{

    SafeHouse(String name, Player player) {
        super("Home", player);
    }
    public boolean getLocation() {
        player.setHealthy(player.getHealthy());
        System.out.println("Your health has improved: ");
        System.out.println("You are home.");
        return true;
    }
}
