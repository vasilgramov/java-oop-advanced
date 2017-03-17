package p08_militaryElite.interfaces;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier {
    Collection<Mission> getMissions();
}
