package app;

import app.commands.Command;
import app.commands.executors.CommandExecutor;
import app.commands.executors.Executor;
import app.commands.groups.GroupAttackCommand;
import app.commands.groups.GroupTargetCommand;
import app.controllers.CombatLogger;
import app.controllers.ErrorLogger;
import app.controllers.EventLogger;
import app.controllers.Handler;
import app.mediators.AttackGroup;
import app.mediators.Group;
import app.models.attackers.Attacker;
import app.models.attackers.Warrior;
import app.models.targets.Dragon;
import app.models.targets.Target;
import app.observers.ObservableTarget;
import app.observers.Observer;

public class Main {

    public static void main(String[] args) {
        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();
        Handler errorHandler = new ErrorLogger();

        eventHandler.setSuccessor(errorHandler);
        combatHandler.setSuccessor(eventHandler);

        Attacker warrior1 = new Warrior(combatHandler, "Goshko", 100);
        Attacker warrior2 = new Warrior(combatHandler, "Peshko", 101);
        ObservableTarget dragon = new Dragon("A Dragon", 200, 69);

        AttackGroup group = new Group();
        group.addMember(warrior1);
        group.addMember(warrior2);

        Command groupTargetCommand = new GroupTargetCommand(group, dragon);
        Command groupAttackCommand = new GroupAttackCommand(group);

        Executor executor = new CommandExecutor();
        executor.executeCommand(groupTargetCommand);
        executor.executeCommand(groupAttackCommand);
    }
}
