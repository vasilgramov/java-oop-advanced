package p02_blobs.models;


import p02_blobs.interfaces.Attack;
import p02_blobs.models.attacks.AbstractAttack;
import p02_blobs.models.attacks.PutridFart;
import p02_blobs.models.behavors.AbstractBehavior;
import p02_blobs.models.behavors.Aggressive;

public class Blob {

    private String name;
    private int health;
    private int damage;
    private AbstractBehavior behavior;
    private Attack attack;
    private int triggerCount;

    private int initialHealth;
    private int initialDamage;

    public Blob(String name, int health, int damage, AbstractBehavior behavior, Attack attack) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;

        this.initialHealth = health;
        this.initialDamage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;

        if (this.health < 0) {
            this.health = 0;
        }

        if (this.health <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.triggerBehavior();
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public void attack(Blob target) {
        if (this.attack instanceof PutridFart) {
            this.attackAffectTarget(this, target);
        }
    }

    public void respond(int damage) {
        int currentHealth = this.getHealth();
        currentHealth -= damage;
        this.setHealth(currentHealth);
    }

    public void triggerBehavior() {
        if (this.behavior instanceof Aggressive) {
            if (this.behavior.isTriggered()) {
                ((Aggressive) this.behavior).setIsTriggered(true);
                this.applyAgressiveTriggerEffect();
            }
        }
    }

    public AbstractBehavior getBehavior() {
        return this.behavior;
    }

    public String getName() {
        return this.name;
    }

    public void update() {
        if (this.behavior.isTriggered()) {
            if (this.behavior instanceof Aggressive) {
                if (this.behavior.isTriggered()) {
                    ((Aggressive) this.behavior).setIsTriggered(true);
                    this.applyAgressiveRecurrentEffect();
                }
            }
        }
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("IBlob %s KILLED", this.getName());
        }

        return String.format("IBlob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }

    private void attackAffectSource(Blob source) {
        source.setHealth(source.getHealth() - source.getHealth() / 2);
    }

    private void attackAffectTarget(Blob source, Blob target) {
        target.respond(source.getDamage() * 2);
    }

    private void applyAgressiveTriggerEffect() {
        this.setDamage(this.getDamage() * 2);
    }

    private void applyAgressiveRecurrentEffect() {
        if (((Aggressive)this.behavior).toDelayRecurrentEffect()) {
            ((Aggressive)this.behavior).setToDelayRecurrentEffect(false);
        } else {
            this.setDamage(this.getDamage() - 5);

            if (this.getDamage() <= this.initialHealth) {
                this.setDamage(this.initialDamage);
            }
        }
    }
}
