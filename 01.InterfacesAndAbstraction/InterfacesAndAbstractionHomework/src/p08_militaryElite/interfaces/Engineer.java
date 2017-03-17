package p08_militaryElite.interfaces;


import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {
    Collection<Repair> getReparis();
}
