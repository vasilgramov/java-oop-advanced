package p10_infernoInfinity.models.weapons;

import p10_infernoInfinity.enums.WeaponType;
import p10_infernoInfinity.interfaces.Weapon;

public class Knife extends BaseWeapon implements Weapon {

    public Knife(String name) {
        super(name, WeaponType.KNIFE.getMinDMG(), WeaponType.KNIFE.getMaxDMG(), WeaponType.KNIFE.getNumberOfSockets());
    }
}
