package hell.entities.heroes;

/**
 * Created by vladix on 4/21/17.
 */
public class Barbarian extends BaseHero {

    private static final String BARBARIAN = "Barbarian";

    private static final long BARBARIAN_STRENGTH = 90;
    private static final long BARBARIAN_AGILITY = 25;
    private static final long BARBARIAN_INTELLIGENCE = 10;
    private static final long BARBARIAN_HITPOINTS = 350;
    private static final long BARBARIAN_DAMAGE = 150;

    public Barbarian(String name) {
        super(name,
                BARBARIAN_STRENGTH,
                BARBARIAN_AGILITY,
                BARBARIAN_INTELLIGENCE,
                BARBARIAN_HITPOINTS,
                BARBARIAN_DAMAGE);
    }

    @Override
    public String toString() {
        String result = super.toString();
        return String.format(result, BARBARIAN);
    }
}
