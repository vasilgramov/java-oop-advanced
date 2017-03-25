package p10_infernoInfinity.models.gems;


import p10_infernoInfinity.interfaces.Gem;

public abstract class BaseGem implements Gem {
    private int strength;
    private int agility;
    private int vitality;

    protected BaseGem(int strength, int agility, int vitality) {
        this.setStrength(strength);
        this.setAgility(agility);
        this.setVitality(vitality);
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getAgility() {
        return this.agility;
    }

    private void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public int getVitality() {
        return this.vitality;
    }

    private void setVitality(int vitality) {
        this.vitality = vitality;
    }
}
