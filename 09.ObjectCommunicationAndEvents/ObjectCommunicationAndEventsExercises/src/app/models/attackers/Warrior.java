package app.models.attackers;

import app.controllers.Handler;
import app.enums.LogType;
import app.models.targets.Target;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(Handler handler, String id, int dmg) {
        super(handler, id, dmg);
    }

    @Override
    protected void executeClassSpecificAttack(Handler handler, Target target, int dmg) {
        handler.handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));

        target.receiveDamage(dmg);
    }
}
