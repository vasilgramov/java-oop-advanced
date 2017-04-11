package app.commands.groups;

import app.commands.Command;
import app.mediators.AttackGroup;
import app.mediators.Group;

public class GroupAttackCommand implements Command {
    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        this.group.groupAttack();
    }
}
