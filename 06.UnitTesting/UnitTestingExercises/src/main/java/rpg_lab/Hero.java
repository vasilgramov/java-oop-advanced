package rpg_lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventar;

    public Hero(String name, Weapon axe) {
        this.name = name;
        this.experience = 0;
        this.weapon = new Axe(10, 10);

        this.inventar = new ArrayList<Weapon>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target, RandomProvider ranodm) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventar.add(target.giveWeapon(ranodm));
        }
    }

    public Iterable<Weapon> getInventory() {
        return this.inventar;
    }


    public static void main(String[] args) {
        Weapon weapon = new Axe(10, 10);
        Hero hero = new Hero("Goshko", weapon);

        List<Weapon> weapons = new ArrayList<Weapon>();
        weapons.add(new Axe(20, 20));
        weapons.add(new Axe(30, 30));


    }
}