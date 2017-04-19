package p05_kingGambit.models;

/**
 * Created by vladix on 4/12/17.
 */
public class King extends BasePerson {

    private static final int INFINITY = Integer.MAX_VALUE;

    public King(String name) {
        super(name, INFINITY);
    }

    @Override
    public void attack() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
    }

    @Override
    public void hurt() {
        throw new IllegalArgumentException("King cannot be hurt!");
    }
}
