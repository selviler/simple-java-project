public class Golem extends Obstacle{
    Golem(Player player) {
        Definition.Golem golem = new Definition.Golem("Golem", 2,3,4,6);
        super(golem.getName(), golem.getDamage(), golem.getAward(), golem.getHealth(), golem.getMaxNumber());
    }
}
