package p05_kingGambit.castle;

import p05_kingGambit.models.BasePerson;

/**
 * Created by vladix on 4/12/17.
 */
public interface Castle {

    void setKing(String name);

    void addPerson(BasePerson person);

    void killPerson(String personName);

    void attack();

}