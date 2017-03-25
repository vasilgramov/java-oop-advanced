package p10_infernoInfinity.models.weapons;

import p10_infernoInfinity.enums.WeaponType;
import p10_infernoInfinity.interfaces.Weapon;

public class Axe extends BaseWeapon implements Weapon {

    public Axe(String name) {
        super(name, WeaponType.AXE.getMinDMG(), WeaponType.AXE.getMaxDMG(), WeaponType.AXE.getNumberOfSockets());
    }
}
