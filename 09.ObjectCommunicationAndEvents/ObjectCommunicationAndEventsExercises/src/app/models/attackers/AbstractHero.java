package app.models.attackers;

import app.controllers.Handler;
import app.enums.LogType;
import app.models.targets.Target;
import app.observers.ObservableTarget;
import app.observers.Observer;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "app.models.targets.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";
    private static final String GET_AWARD_MESSAGE = "%s gains %s xp";

    private String id;
    private int dmg;
    private ObservableTarget target;
    private Handler handler;

    protected AbstractHero(Handler handler, String id, int dmg) {
        this.id = id;
        this.dmg = dmg;
        this.handler = handler;
    }

    public void setTarget(ObservableTarget target) {
        if (target == null) {
            this.handler.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            this.target.register(this);

            this.handler.handle(LogType.EVENT, String.format(SET_TARGET_MESSAGE, this, target));
        }

    }

    public final void attack() {
        if (this.target == null) {
            this.handler.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.handler.handle(LogType.ERROR, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.handler, this.target, this.dmg);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Handler handler, Target target, int dmg);

    @Override
    public void update(int reward) {
        this.handler.handle(LogType.EVENT, String.format(GET_AWARD_MESSAGE, this, reward));
    }
}
