package app.models.attackers;

import app.models.targets.Target;
import app.observers.ObservableTarget;

public interface Attacker {

    void attack();

    void setTarget(ObservableTarget target);

}
