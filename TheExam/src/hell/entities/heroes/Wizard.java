package hell.entities.heroes;

/**
 * Created by vladix on 4/21/17.
 */
public class Wizard extends BaseHero {

    private static final String WIZARD = "Wizard";

    private static final long WIZARD_STRENGTH = 25;
    private static final long WIZARD_AGILITY = 25;
    private static final long WIZARD_INTELLIGENCE = 100;
    private static final long WIZARD_HITPOINTS = 100;
    private static final long WIZARD_DAMAGE = 250;

    public Wizard(String name) {
        super(name,
                WIZARD_STRENGTH,
                WIZARD_AGILITY,
                WIZARD_INTELLIGENCE,
                WIZARD_HITPOINTS,
                WIZARD_DAMAGE);
    }

    @Override
    public String toString() {
        String result = super.toString();
        return String.format(result, WIZARD);
    }
}
