package p05_kingGambit.models;

/**
 * Created by vladix on 4/12/17.
 */
public class Footman extends BasePerson {

    private static final int FOOTMAN_LIVE_POINTS = 2;

    public Footman(String name) {
        super(name, FOOTMAN_LIVE_POINTS);
    }

    @Override
    public void attack() {
        if (this.getLivePoints() > 0) {
            System.out.println(String.format("Footman %s is panicking!", super.getName()));
        }
    }

    @Override
    public void hurt() {
        super.setLivePoints(super.getLivePoints() - 1);
    }
}
