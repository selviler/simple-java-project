public class Ape extends Obstacle{
    Ape(Player player) {
        Definition.Ape ape = new Definition.Ape("Ape", 218,240,30,150);
        super(ape.getName(), ape.getDamage(), ape.getAward(), ape.getHealth(), ape.getMaxNumber());
    }
}
