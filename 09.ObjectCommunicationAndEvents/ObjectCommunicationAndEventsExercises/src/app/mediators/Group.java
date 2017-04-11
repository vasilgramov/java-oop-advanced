package app.mediators;

import app.models.attackers.Attacker;
import app.models.targets.Target;
import app.observers.ObservableTarget;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {
    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        for (Attacker attacker : this.attackers) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : this.attackers) {
            attacker.attack();
        }
    }
}
