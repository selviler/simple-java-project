public class BloodDon extends Obstacle{
    BloodDon(Player player) {
        Definition.BloodDon bloodDon = new Definition.BloodDon("bloodDon", 2,3,4,6);
        super(bloodDon.getName(), bloodDon.getDamage(), bloodDon.getAward(), bloodDon.getHealth(), bloodDon.getMaxNumber());
    }
}
