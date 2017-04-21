package hell.entities.items;

import hell.interfaces.Item;

/**
 * Created by vladix on 4/21/17.
 */
public abstract class BaseItem implements Item {

    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int healthPointsBonus;
    private int damageBonus;

    protected BaseItem(String name,
                       int strengthBonus,
                       int agilityBonus,
                       int intelligenceBonus,
                       int healthPointsBonus,
                       int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.healthPointsBonus = healthPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.healthPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("###Item: %s", this.getName())).append(System.lineSeparator())
                .append(String.format("###+%s Strength", this.getStrengthBonus())).append(System.lineSeparator())
                .append(String.format("###+%s Agility", this.getAgilityBonus())).append(System.lineSeparator())
                .append(String.format("###+%s Intelligence", this.getIntelligenceBonus())).append(System.lineSeparator())
                .append(String.format("###+%s HitPoints", this.getHitPointsBonus())).append(System.lineSeparator())
                .append(String.format("###+%s Damage", this.getDamageBonus()));

        return builder.toString();
    }
}
