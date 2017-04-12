package p02_kingGambit.models;

/**
 * Created by vladix on 4/12/17.
 */
public class Footman extends BasePerson {

    public Footman(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(String.format("Footman %s is panicking!", super.getName()));
    }
}
