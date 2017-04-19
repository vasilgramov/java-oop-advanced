package p05_kingGambit.castle;

import p05_kingGambit.models.BasePerson;
import p05_kingGambit.models.King;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vladix on 4/12/17.
 */
public class CastleImpl implements Castle {

    private BasePerson king;
    Map<String, BasePerson> personByName;

    public CastleImpl() {
        this.personByName = new LinkedHashMap<>();
    }

    @Override
    public void setKing(String name) {
        this.king = new King(name);
    }

    @Override
    public void addPerson(BasePerson person) {
        this.personByName.put(person.getName(), person);
    }

    @Override
    public void killPerson(String personName) {
        BasePerson basePerson = this.personByName.get(personName);
        basePerson.hurt();
    }

    @Override
    public void attack() {
        this.king.attack();

        for (BasePerson person : personByName.values()) {
            person.attack();
        }
    }
}
