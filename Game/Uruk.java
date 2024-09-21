public class Uruk extends Obstacle{
    Uruk(Player player) {
        Definition.Uruk uruk = new Definition.Uruk("Uruk", 2,3,4,6);
        super(uruk.getName(), uruk.getDamage(), uruk.getAward(), uruk.getHealth(), uruk.getMaxNumber());
    }
}
