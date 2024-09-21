public class Atross extends Obstacle{
    Atross(Player player) {
        Definition.Atross atross = new Definition.Apostle("Atross", 1084,1084,85,150);
        super(atross.getName(), atross.getDamage(), atross.getAward(), atross.getHealth(), atross.getMaxNumber());
    }
}
