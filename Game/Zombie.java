public class Zombie extends Obstacle{
    Zombie() {
        Definition.Zombie zombie = new Definition.Zombie("zombie", 2,3,4,6);
        super(zombie.getName(), zombie.getDamage(), zombie.getAward(), zombie.getHealth(), zombie.getMaxNumber());
    }
//    Zombie() {
//        super("Zombi", 3, 10, 4, 3);
//    }
}
