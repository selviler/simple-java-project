public class Ancient extends Obstacle{
    Ancient(Player player) {
        Definition.Ancient ancient = new Definition.Ancient("Ancient", 587,587,50,150);
        super(ancient.getName(), ancient.getDamage(), ancient.getAward(), ancient.getHealth(), ancient.getMaxNumber());
    }
}
