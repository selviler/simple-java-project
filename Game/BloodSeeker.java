public class BloodSeeker extends Obstacle{
    BloodSeeker(Player player) {
        Definition.BloodSeeker bloodSeeker = new Definition.BloodSeeker("BloodSeeker", 2,3,4,6);
        super(bloodSeeker.getName(), bloodSeeker.getDamage(), bloodSeeker.getAward(), bloodSeeker.getHealth(), bloodSeeker.getMaxNumber());
    }
}
