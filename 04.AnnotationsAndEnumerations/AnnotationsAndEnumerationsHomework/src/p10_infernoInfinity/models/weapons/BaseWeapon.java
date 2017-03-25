package p10_infernoInfinity.models.weapons;

import p10_infernoInfinity.interfaces.Gem;
import p10_infernoInfinity.interfaces.Weapon;

public abstract class BaseWeapon implements Weapon {
    private String name;
    private int minDMG;
    private int maxDMG;
    private int numberOfSockets;

    private Gem[] gems;

    private int bonusStrength;
    private int bonusAgility;
    private int bonusVitality;

    protected BaseWeapon(String name, int minDMG, int maxDMG, int numberOfSockets) {
        this.setName(name);
        this.setMinDMG(minDMG);
        this.setMaxDMG(maxDMG);
        this.setNumberOfSockets(numberOfSockets);
        this.setGems(new Gem[numberOfSockets]);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getMinDMG() {
        return this.minDMG;
    }

    private void setMinDMG(int minDMG) {
        this.minDMG = minDMG;
    }

    @Override
    public int getMaxDMG() {
        return this.maxDMG;
    }

    private void setMaxDMG(int maxDMG) {
        this.maxDMG = maxDMG;
    }

    @Override
    public int getNumberOfSockets() {
        return this.numberOfSockets;
    }

    @Override
    public double getItemLevel() {
        return ((this.getMinDMG() + this.getMaxDMG()) / 2.0) + this.getBonusStrength() + this.getBonusVitality() + this.getBonusAgility();
    }

    private void setNumberOfSockets(int numberOfSockets) {
        this.numberOfSockets = numberOfSockets;
    }

    public Gem[] getGems() {
        return this.gems;
    }

    private void setGems(Gem[] gems) {
        this.gems = gems;
    }

    public int getBonusStrength() {
        return this.bonusStrength;
    }

    private void setBonusStrength(int bonusStrength) {
        this.bonusStrength = bonusStrength;
    }

    public int getBonusAgility() {
        return this.bonusAgility;
    }

    private void setBonusAgility(int bonusAgility) {
        this.bonusAgility = bonusAgility;
    }

    public int getBonusVitality() {
        return this.bonusVitality;
    }

    private void setBonusVitality(int bonusVitality) {
        this.bonusVitality = bonusVitality;
    }

    @Override
    public void addGem(Gem gem, int index) {
        if (index >= 0 && index < this.getNumberOfSockets()) {
            if (this.getGems()[index] != null) {
                removeGem(index);
            }

            int minDMGToAdd = calculateMinDMGFromGem(gem);
            int maxDMGToAdd = calculateMaxDMGFomGem(gem);

            this.setMinDMG(this.getMinDMG() + minDMGToAdd);
            this.setMaxDMG(this.getMaxDMG() + maxDMGToAdd);

            this.setBonusStrength(this.getBonusStrength() + gem.getStrength());
            this.setBonusAgility(this.getBonusAgility() + gem.getAgility());
            this.setBonusVitality(this.getBonusVitality() + gem.getVitality());

            this.getGems()[index] = gem;
        }
    }

    @Override
    public void removeGem(int index) {
        if (index >= 0 && index < this.getNumberOfSockets() && this.getGems()[index] != null) {
            decreaseMinMaxDMG(this.getGems()[index]);
            decreaseStats(this.getGems()[index]);
        }
    }

    public String print() {
        return String.format("%s (Item Level: %.1f)", this.toString(), this.getItemLevel());
    }

    private void decreaseStats(Gem gem) {
        this.setBonusStrength(this.getBonusStrength() - gem.getStrength());
        this.setBonusAgility(this.getBonusAgility() - gem.getAgility());
        this.setBonusVitality(this.getBonusVitality() - gem.getVitality());
    }

    private void decreaseMinMaxDMG(Gem gem) {
        int minDMGToRemove = calculateMinDMGFromGem(gem);
        int maxDMGToRemove = calculateMaxDMGFomGem(gem);

        this.setMinDMG(this.getMinDMG() - minDMGToRemove);
        this.setMaxDMG(this.getMaxDMG() - maxDMGToRemove);
    }

    private int calculateMaxDMGFomGem(Gem gem) {
        return (gem.getStrength() * 3) + (gem.getAgility() * 4);
    }

    private int calculateMinDMGFromGem(Gem gem) {
        return (gem.getStrength() * 2) + gem.getAgility();
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(), this.getMinDMG(), this.getMaxDMG(), this.getBonusStrength(), this.getBonusAgility(), this.getBonusVitality());
    }

    @Override
    public int compareTo(Weapon other) {
        return Double.compare(this.getItemLevel(), other.getItemLevel());
    }
}
