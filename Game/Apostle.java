public class Apostle extends Obstacle{
    Apostle(Player player) {
        Definition.Apostle apostle = new Definition.Apostle("Apostle", 218,240,30,150);
        super(apostle.getName(), apostle.getDamage(), apostle.getAward(), apostle.getHealth(), apostle.getMaxNumber());
    }
}
