public class Cave extends BattleLoc{
    Cave(Player player) {
        Definition.Cave cave = new Definition.Cave("Cave", 2,3,4,6);
        super(cave.getName(), cave.getDamage(), cave.getAward(), cave.getHealth(), cave.getMaxNumber());
    }
}
