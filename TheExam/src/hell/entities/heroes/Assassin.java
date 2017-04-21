package hell.entities.heroes;

/**
 * Created by vladix on 4/21/17.
 */
public class Assassin extends BaseHero {

    private static final String ASSASSIN = "Assassin";

    private static final long ASSASSIN_STRENGTH = 25;
    private static final long ASSASSIN_AGILITY = 100;
    private static final long ASSASSIN_INTELLIGENCE = 15;
    private static final long ASSASSIN_HITPOINTS = 150;
    private static final long ASSASSIN_DAMAGE = 300;

    public Assassin(String name) {
        super(name,
                ASSASSIN_STRENGTH,
                ASSASSIN_AGILITY,
                ASSASSIN_INTELLIGENCE,
                ASSASSIN_HITPOINTS,
                ASSASSIN_DAMAGE);
    }

    @Override
    public String toString() {
        String result = super.toString();
        return String.format(result, ASSASSIN);
    }
}
