package p10_infernoInfinity.models.weapons;


import p10_infernoInfinity.enums.WeaponType;
import p10_infernoInfinity.interfaces.Weapon;

public class Sword extends BaseWeapon implements Weapon {

    public Sword(String name) {
        super(name, WeaponType.SWORD.getMinDMG(), WeaponType.SWORD.getMaxDMG(), WeaponType.SWORD.getNumberOfSockets());
    }
}
