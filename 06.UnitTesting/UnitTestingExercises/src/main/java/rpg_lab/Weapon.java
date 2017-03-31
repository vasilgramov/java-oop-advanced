package rpg_lab;

public interface Weapon {

    int getAttackPooints();

    int getDurabilityPoints();

    void attack(Target dummy);
}
