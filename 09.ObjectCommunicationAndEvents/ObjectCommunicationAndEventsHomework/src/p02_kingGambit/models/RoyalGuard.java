package p02_kingGambit.models;

/**
 * Created by vladix on 4/12/17.
 */
public class RoyalGuard extends BasePerson {


    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
    }
}
