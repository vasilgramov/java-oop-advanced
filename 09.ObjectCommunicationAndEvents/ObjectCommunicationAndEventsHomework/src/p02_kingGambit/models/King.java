package p02_kingGambit.models;

/**
 * Created by vladix on 4/12/17.
 */
public class King extends BasePerson {

    public King(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
    }
}
