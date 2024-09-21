public class Bear extends Obstacle{
    Bear() {
        Definition.Bear bear = new Definition.Bear("Bear", 2,3,4,6);
        super(Bear.getName(), Bear.getDamage(), Bear.getAward(), Bear.getHealth(), Bear.getMaxNumber());
    }
}
