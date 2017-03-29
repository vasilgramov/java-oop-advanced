package pr0304Barracks.models.units;

public class Gunner extends AbstractUnit {
    private static final int GUNNERH_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;

    public Gunner() {
        super(GUNNERH_HEALTH, GUNNER_DAMAGE);
    }
}
