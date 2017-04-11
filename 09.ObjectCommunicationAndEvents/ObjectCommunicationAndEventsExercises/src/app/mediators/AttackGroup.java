package app.mediators;

import app.models.attackers.Attacker;
import app.models.targets.Target;
import app.observers.ObservableTarget;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();

}
