package p05_kingGambit.models;

import p05_kingGambit.models.interfaces.Attackable;
import p05_kingGambit.models.interfaces.Hurtable;
import p05_kingGambit.models.interfaces.Nameable;

/**
 * Created by vladix on 4/12/17.
 */
public abstract class BasePerson implements Nameable, Attackable, Hurtable {

    private String name;
    private int livePoints;

    protected BasePerson(String name, int livePoints) {
        this.name = name;
        this.livePoints = livePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected int getLivePoints() {
        return this.livePoints;
    }

    protected void setLivePoints(int livePoints) {
        this.livePoints = livePoints;
    }

}
