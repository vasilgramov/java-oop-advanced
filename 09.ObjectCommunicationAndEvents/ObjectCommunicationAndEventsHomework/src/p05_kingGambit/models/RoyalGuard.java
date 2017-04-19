package p05_kingGambit.models;

/**
 * Created by vladix on 4/12/17.
 */
public class RoyalGuard extends BasePerson {

    private static final int ROYAL_GUARD_LIVE_POINTS = 3;


    public RoyalGuard(String name) {
        super(name, ROYAL_GUARD_LIVE_POINTS);
    }

    @Override
    public void attack() {
        if (this.getLivePoints() > 0) {
            System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
        }
    }

    @Override
    public void hurt() {
        super.setLivePoints(super.getLivePoints() - 1);
    }
}
