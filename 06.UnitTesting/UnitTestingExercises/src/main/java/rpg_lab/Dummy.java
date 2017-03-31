package rpg_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> items;

    public Dummy(int health, int experience, List<Weapon> items) {
        this.health = health;
        this.experience = experience;

        this.items = items;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }


    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon giveWeapon(RandomProvider random) {
        if (!isDead()) {
            throw new IllegalStateException("Target is not dead!");
        }

        int index = random.nextInt(this.items.size());
        return this.items.get(index);
    }
}