package app.commands.groups;

import app.commands.Command;
import app.mediators.AttackGroup;
import app.models.targets.Target;
import app.observers.ObservableTarget;

public class GroupTargetCommand implements Command {

    private ObservableTarget target;
    private AttackGroup attackGroup;

    public GroupTargetCommand(AttackGroup attackGroup, ObservableTarget target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        attackGroup.groupTarget(target);
    }
}
