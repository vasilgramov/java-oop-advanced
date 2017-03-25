package p10_infernoInfinity;

import p10_infernoInfinity.annotations.WeaponInformation;
import p10_infernoInfinity.enums.GemType;
import p10_infernoInfinity.enums.WeaponType;
import p10_infernoInfinity.interfaces.Gem;
import p10_infernoInfinity.interfaces.Weapon;
import p10_infernoInfinity.models.gems.Amethyst;
import p10_infernoInfinity.models.gems.Emerald;
import p10_infernoInfinity.models.gems.Ruby;
import p10_infernoInfinity.models.weapons.Axe;
import p10_infernoInfinity.models.weapons.Knife;
import p10_infernoInfinity.models.weapons.Sword;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Weapon> weaponByName;

    public CommandManager() {
        this.weaponByName = new HashMap<>();
    }

    public void createWeapon(WeaponType weaponType, String name) {
        switch (weaponType) {
            case AXE:
                Weapon axe = new Axe(name);
                this.weaponByName.put(name, axe);
                break;
            case SWORD:
                Weapon sword = new Sword(name);
                this.weaponByName.put(name, sword);
                break;
            case KNIFE:
                Weapon knife = new Knife(name);
                this.weaponByName.put(name, knife);
                break;
        }
    }

    public void addGem(String weaponName, int index, GemType gemType) {
        if (this.weaponByName.containsKey(weaponName)) {
            Weapon weapon = this.weaponByName.get(weaponName);
            Gem gem = null;
            switch (gemType) {
                case RUBY:
                    gem = new Ruby();
                    break;
                case EMERALD:
                    gem = new Emerald();
                    break;
                case AMETHYST:
                    gem = new Amethyst();
                    break;
            }

            if (gem == null) {
                throw new IllegalArgumentException("No such Gem exists!");
            }

            weapon.addGem(gem, index);
        }
    }

    public void removeGem(String weaponName, int index) {
        if (this.weaponByName.containsKey(weaponName)) {
            Weapon weapon = this.weaponByName.get(weaponName);

            weapon.removeGem(index);
        }
    }

    public String print(String weaponName) {
        if (this.weaponByName.containsKey(weaponName)) {
            Weapon weapon = this.weaponByName.get(weaponName);

            return weapon.toString();
        }

        return null;
    }

    public String compare(String firstWeaponName, String secondWeaponName) {
        if (this.weaponByName.containsKey(firstWeaponName) && this.weaponByName.containsKey(secondWeaponName)) {
            Weapon firstWeapon = this.weaponByName.get(firstWeaponName);
            Weapon secondWeapon = this.weaponByName.get(secondWeaponName);
            if (firstWeapon.compareTo(secondWeapon) >= 0) {
                return firstWeapon.print();
            } else {
                return secondWeapon.print();
            }
        }

        return null;
    }

    public String extractAuthor() {
        Annotation[] annotations = Weapon.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof WeaponInformation) {
                WeaponInformation weaponInformation = (WeaponInformation) annotation;
                return weaponInformation.author();
            }
        }

        return null;
    }

    public int extractRevisions() {
        Annotation[] annotations = Weapon.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof WeaponInformation) {
                WeaponInformation weaponInformation = (WeaponInformation) annotation;
                return weaponInformation.revision();
            }
        }

        return 0;
    }

    public String extractDescription() {
        Annotation[] annotations = Weapon.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof WeaponInformation) {
                WeaponInformation weaponInformation = (WeaponInformation) annotation;
                return weaponInformation.description();
            }
        }

        return null;
    }

    public String extractReviewers() {
        Annotation[] annotations = Weapon.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof WeaponInformation) {
                WeaponInformation weaponInformation = (WeaponInformation) annotation;
                return Arrays.toString(weaponInformation.reviewers()).replace("[", "").replace("]", "");
            }
        }

        return null;
    }
}
